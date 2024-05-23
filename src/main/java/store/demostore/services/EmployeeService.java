package store.demostore.services;

import java.util.List;
import java.util.Optional;

import store.demostore.interfaces.EmployeeServiceInterface;
import store.demostore.models.entities.EmployeeEntity;

public class EmployeeService implements EmployeeServiceInterface {

    @Override
    public List<EmployeeEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<EmployeeEntity> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public EmployeeEntity update(String id, EmployeeEntity employee) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
