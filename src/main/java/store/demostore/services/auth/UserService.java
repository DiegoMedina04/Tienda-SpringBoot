package store.demostore.services.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.auth.UserServiceInterfaz;
import store.demostore.models.entities.auth.UserEntity;
import store.demostore.repositories.auth.UserRepository;

@Service
public class UserService implements UserServiceInterfaz {

    @Autowired
    private UserRepository userRepository;

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

        UserEntity savedUser = userRepository.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @Override
    public ResponseEntity<?> update(String id, UserEntity user) {
        return userRepository.findById(id)
                .map(record -> {

                    record.setName(user.getName());
                    record.setLastName(user.getLastName());
                    record.setPhone(user.getPhone());
                    record.setEmail(user.getEmail());
                    record.setPassword(user.getPassword());
                    record.setActive(user.isActive());
                    record.setRoles(user.getRoles());
                    record.setCompanys(user.getCompanys());

                    UserEntity updatedUser = userRepository.save(record);
                    return ResponseEntity.ok().body(updatedUser);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        return userRepository.findById(id)
                .map(record -> {
                    userRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
