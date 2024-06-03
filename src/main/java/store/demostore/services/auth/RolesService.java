package store.demostore.services.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.auth.RolesServiceInterface;
import store.demostore.models.entities.auth.RolesEntity;
import store.demostore.repositories.auth.RolesRepository;

@Service
public class RolesService implements RolesServiceInterface {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<RolesEntity> findAll() {

        return (List<RolesEntity>) rolesRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        Optional<RolesEntity> role = rolesRepository.findById(id);
        if (role.isPresent()) {
            return ResponseEntity.ok(role.get());
        }
        return ResponseEntity.badRequest().body("Role not found");

    }

    @Override
    public ResponseEntity<?> save(RolesEntity rol) {
        return ResponseEntity.ok(rolesRepository.save(rol));
    }

    @Override
    public ResponseEntity<?> update(String id, RolesEntity rol) {

        return rolesRepository.findById(id)
                .map(roleDb -> {

                    roleDb.setName(rol.getName());
                    roleDb.setDescription(rol.getDescription());

                    RolesEntity rolUpdate = rolesRepository.save(roleDb);
                    return ResponseEntity.ok().body(rolUpdate);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        Optional<RolesEntity> role = rolesRepository.findById(id);
        if (role.isPresent()) {
            rolesRepository.deleteById(id);
            return ResponseEntity.ok("Role eliminado!!");
        }
        return ResponseEntity.badRequest().body("Role no encontrado!");
    }

}
