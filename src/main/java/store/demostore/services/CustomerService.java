package store.demostore.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.interfaces.CustomerServiceInterface;
import store.demostore.models.entities.CustomerEntity;

public class CustomerService implements CustomerServiceInterface {

    @Override
    public List<CustomerEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ResponseEntity<?> save(CustomerEntity customer) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ResponseEntity<?> update(String id, CustomerEntity company) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
