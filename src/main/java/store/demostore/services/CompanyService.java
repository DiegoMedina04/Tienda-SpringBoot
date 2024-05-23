package store.demostore.services;

import java.util.List;
import java.util.Optional;

import store.demostore.interfaces.CompanyServiceInterface;
import store.demostore.models.entities.CompanyEntity;

public class CompanyService implements CompanyServiceInterface {

    @Override
    public List<CompanyEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<CompanyEntity> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public CompanyEntity save(CompanyEntity company) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public CompanyEntity update(String id, CompanyEntity company) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
