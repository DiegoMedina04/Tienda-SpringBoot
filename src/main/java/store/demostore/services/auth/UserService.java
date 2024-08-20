package store.demostore.services.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.CompanyServiceInterface;
import store.demostore.interfaces.auth.RolesServiceInterface;
import store.demostore.interfaces.auth.UserServiceInterfaz;
import store.demostore.models.entities.auth.UserEntity;
import store.demostore.repositories.auth.UserRepository;

@Service
public class UserService implements UserServiceInterfaz {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @Autowired
    private RolesServiceInterface rolesServiceInterface;

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        return userRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> save(UserEntity user) {
        try {
            ResponseEntity<?> findRol = roleValidate(user);
            ResponseEntity<?> findCompany = companyValidate(user);
            if (findRol != null || findCompany != null) {
                return findRol != null ? findRol : findCompany;
            }
            Optional<UserEntity> findUser = findUserByEmail(user.getEmail());
            if (findUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ya registrado");
            }
            System.out.println("--------------------------------------------------");
            System.out.println("paso a crear el usuario");
            return ResponseEntity.ok().body(userRepository.save(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> update(String id, UserEntity user) {
        try {

            Optional<UserEntity> userOptional = userRepository.findById(id);
            if (userOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
            }

            ResponseEntity<?> findRol = roleValidate(user);
            ResponseEntity<?> findCompany = companyValidate(user);
            if (findRol != null || findCompany != null) {
                return findRol == null ? findRol : findCompany;
            }

            UserEntity userToUpdate = userOptional.orElseThrow();
            userToUpdate.setName(user.getName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setPhone(user.getPhone());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setActive(user.isActive());
            userToUpdate.setRoles(user.getRoles());
            userToUpdate.setCompanys(user.getCompanys());
            userToUpdate.setAddress(user.getAddress());
            userToUpdate.setBirthdayDate(user.getBirthdayDate());

            return ResponseEntity.ok().body(userRepository.save(userToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @Override
    public ResponseEntity<?> delete(String id) {
        return userRepository.findById(id)
                .map(record -> {
                    userRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> roleValidate(UserEntity user) {
        boolean rolNotFound = user.getRoles().stream().anyMatch(
                role -> rolesServiceInterface.findById(role.getId()).getStatusCode() == HttpStatus.BAD_REQUEST);

        if (rolNotFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
        return null;
    }

    private ResponseEntity<?> companyValidate(UserEntity user) {

        boolean companyNotFound = user.getCompanys().stream()
                .anyMatch(company -> companyServiceInterface.findById(company.getId())
                        .getStatusCode() == HttpStatus.NOT_FOUND);
        if (companyNotFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compañia no encontrada");
        }
        return null;
    }

    private Optional<UserEntity> findUserByEmail(String email) {
        return userRepository.findFirstByEmail(email);
        
    }


}

// return userRepository.findByEmail(email).isEmpty() ? 
//         ResponseEntity.notFound().build()
//         : ResponseEntity.ok().body("Usuario ya registrado");