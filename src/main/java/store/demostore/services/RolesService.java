package store.demostore.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.interfaces.RolesServiceInterface;
import store.demostore.models.entities.RolesEntity;

public class RolesService implements RolesServiceInterface {

    @Override
    public List<RolesEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ResponseEntity<?> save(RolesEntity rol) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ResponseEntity<?> update(String id, RolesEntity rol) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
