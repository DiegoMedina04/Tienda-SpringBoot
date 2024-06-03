package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.demostore.interfaces.EmployeeServiceInterface;
import store.demostore.models.entities.EmployeeEntity;
import store.demostore.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_URL + "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        return employeeServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeServiceInterface.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody EmployeeEntity employee) {
        return employeeServiceInterface.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        return employeeServiceInterface.delete(id);
    }
}
