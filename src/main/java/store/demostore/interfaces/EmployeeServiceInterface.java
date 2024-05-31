package store.demostore.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.EmployeeEntity;

public interface EmployeeServiceInterface {
    List<EmployeeEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(EmployeeEntity employee);

    ResponseEntity<?> update(String id, EmployeeEntity employee);

    ResponseEntity<?> delete(String id);

}
