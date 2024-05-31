package store.demostore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import store.demostore.interfaces.PromotionsServiceInterface;
import store.demostore.models.entities.PromotionsEntity;

public class PromotionsService implements PromotionsServiceInterface {

    @Override
    public List<PromotionsEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ResponseEntity<?> save(PromotionsEntity promotion) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ResponseEntity<?> update(String id, PromotionsEntity promotion) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
