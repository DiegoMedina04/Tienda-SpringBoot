package store.demostore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import store.demostore.interfaces.EmployeeServiceInterface;
import store.demostore.models.entities.EmployeeEntity;

public class EmployeeService implements EmployeeServiceInterface {

    @Override
    public List<EmployeeEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ResponseEntity<?> save(EmployeeEntity employee) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ResponseEntity<?> update(String id, EmployeeEntity employee) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
