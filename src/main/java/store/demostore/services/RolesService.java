package store.demostore.services;

import java.util.List;
import java.util.Optional;

import store.demostore.interfaces.RolesServiceInterface;
import store.demostore.models.entities.RolesEntity;

public class RolesService implements RolesServiceInterface {

    @Override
    public List<RolesEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<RolesEntity> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public RolesEntity save(RolesEntity rol) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public RolesEntity update(String id, RolesEntity rol) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
