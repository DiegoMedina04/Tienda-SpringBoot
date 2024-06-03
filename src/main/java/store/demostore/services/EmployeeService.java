package store.demostore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.EmployeeServiceInterface;
import store.demostore.interfaces.PositionServiceInterface;
import store.demostore.interfaces.auth.UserServiceInterfaz;
import store.demostore.models.entities.EmployeeEntity;
import store.demostore.repositories.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserServiceInterfaz userServiceInterfaz;

    @Autowired
    private PositionServiceInterface positionServiceInterface;

    @Override
    public List<EmployeeEntity> findAll() {
        return (List<EmployeeEntity>) employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        return employeeRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> save(EmployeeEntity employee) {
        // try {
        // ResponseEntity<?> findUser = validateUser(employee);
        // ResponseEntity<?> findPosition = validatePosition(employee);

        // if (findUser != null || findPosition != null) {
        // return findUser != null ? findUser : findPosition;
        // }
        // return ResponseEntity.ok().body(employee);
        return ResponseEntity.ok().body(employeeRepository.save(employee));
        // } catch (Exception e) {
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        // }
    }

    @Override
    public ResponseEntity<?> update(String id, EmployeeEntity employee) {
        Optional<EmployeeEntity> findemploye = employeeRepository.findById(id);
        if (findemploye.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ResponseEntity<?> findPosition = validatePosition(employee);
        if (findPosition != null) {
            return findPosition;
        }
        EmployeeEntity employeeToUpdate = findemploye.orElseThrow();
        employeeToUpdate.setCode(employee.getCode());
        employeeToUpdate.setUserId(employee.getUserId());
        employeeToUpdate.setSalary(employee.getSalary());
        employeeToUpdate.setPosition(employee.getPosition());

        return ResponseEntity.ok().body(employeeRepository.save(employeeToUpdate));

    }

    @Override
    public ResponseEntity<?> delete(String id) {
        return employeeRepository.findById(id)
                .map(record -> {
                    employeeRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validateUser(EmployeeEntity employee) {
        boolean findUser = userServiceInterfaz.findById(employee.getUserId().getId()).getStatusCode() == HttpStatus.OK;
        if (!findUser) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado");
        }
        return null;
    }

    private ResponseEntity<?> validatePosition(EmployeeEntity employee) {
        boolean findPosition = employee.getPosition().stream().anyMatch(
                position -> positionServiceInterface.findById(position.getId()).getStatusCode() == HttpStatus.OK);
        if (!findPosition) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cargo no encontrado");
        }
        return null;
    }
}
