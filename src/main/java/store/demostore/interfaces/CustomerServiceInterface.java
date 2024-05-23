package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.CustomerEntity;

public interface CustomerServiceInterface {

    List<CustomerEntity> findAll();

    Optional<CustomerEntity> findById(String id);

    CustomerEntity save(CustomerEntity customer);

    CustomerEntity update(String id, CustomerEntity company);

    void delete(String id);

}
