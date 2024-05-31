package store.demostore.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.CustomerEntity;

public interface CustomerServiceInterface {

    List<CustomerEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(CustomerEntity customer);

    ResponseEntity<?> update(String id, CustomerEntity company);

    ResponseEntity<?> delete(String id);

}
