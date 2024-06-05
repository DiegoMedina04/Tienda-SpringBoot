package store.demostore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.CustomerServiceInterface;
import store.demostore.interfaces.auth.UserServiceInterfaz;
import store.demostore.models.entities.CustomerEntity;
import store.demostore.models.entities.auth.UserEntity;
import store.demostore.repositories.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserServiceInterfaz userService;

    @Override
    public List<CustomerEntity> findAll() {
        return (List<CustomerEntity>) customerRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        return customerRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> save(CustomerEntity customer) {

        ResponseEntity<?> validateUser = validateUser(customer);
        if (validateUser != null) {
            return validateUser;
        }
        return ResponseEntity.ok().body(customerRepository.save(customer));
    }

    @Override
    public ResponseEntity<?> update(String id, CustomerEntity customer) {

        Optional<CustomerEntity> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }

        ResponseEntity<?> validateUser = validateUser(customer);
        // creando pull request
        if (validateUser != null || validateUser != null) {
            return validateUser;
        }
        CustomerEntity customerToUpdate = customerOptional.orElseThrow();
        customerToUpdate.setUserId(customer.getUserId());
        customerToUpdate.setIsActive(customer.getIsActive());

        return ResponseEntity.ok().body(customerRepository.save(customerToUpdate));
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        return customerRepository.findById(id)
                .map(record -> {
                    customerRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validateUser(CustomerEntity customer) {
        ResponseEntity<?> userOptional = userService.findById(customer.getUserId().getId());
        if (userOptional.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        boolean findUser = customerRepository.findByUserId(customer.getUserId()).stream().anyMatch(e -> {
            return true;
        });
        if (findUser) {
            return ResponseEntity.badRequest().body("Usuario ya existente");
        }
        return null;
    }

}
