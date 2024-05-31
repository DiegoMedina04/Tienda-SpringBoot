package store.demostore.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.interfaces.CompanyServiceInterface;
import store.demostore.models.entities.CompanyEntity;

public class CompanyService implements CompanyServiceInterface {

    @Override
    public List<CompanyEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ResponseEntity<?> save(CompanyEntity company) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ResponseEntity<?> update(String id, CompanyEntity company) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
