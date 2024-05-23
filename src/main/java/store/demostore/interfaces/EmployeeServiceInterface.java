package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.EmployeeEntity;

public interface EmployeeServiceInterface {
    List<EmployeeEntity> findAll();

    Optional<EmployeeEntity> findById(String id);

    EmployeeEntity save(EmployeeEntity employee);

    EmployeeEntity update(String id, EmployeeEntity employee);

    void delete(String id);

}
