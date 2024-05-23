package store.demostore.services;

import java.util.List;
import java.util.Optional;

import store.demostore.interfaces.CustomerServiceInterface;
import store.demostore.models.entities.CustomerEntity;

public class CustomerService implements CustomerServiceInterface {

    @Override
    public List<CustomerEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<CustomerEntity> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public CustomerEntity save(CustomerEntity customer) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public CustomerEntity update(String id, CustomerEntity company) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
