package store.demostore.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.PositionServiceInterface;
import store.demostore.models.entities.PositionEntity;

@Service
public class PositionService implements PositionServiceInterface {

    @Override
    public List<PositionEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ResponseEntity<?> save(PositionEntity position) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ResponseEntity<?> update(String id, PositionEntity position) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
