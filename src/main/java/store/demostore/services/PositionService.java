package store.demostore.services;

import java.util.List;
import java.util.Optional;

import store.demostore.interfaces.PositionServiceInterface;
import store.demostore.models.entities.PositionEntity;

public class PositionService implements PositionServiceInterface {

    @Override
    public List<PositionEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<PositionEntity> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public PositionEntity save(PositionEntity position) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public PositionEntity update(String id, PositionEntity position) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
