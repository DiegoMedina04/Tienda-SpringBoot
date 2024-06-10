package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import store.demostore.interfaces.CustomerServiceInterface;
import store.demostore.models.entities.CustomerEntity;
import store.demostore.services.handleErrors.HandleErrorsService;
import store.demostore.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_URL + "/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceInterface customerService;

    @Autowired
    private HandleErrorsService handleErrorsService;

    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);

        }
        return customerService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerEntity customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);

        }
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@Valid @PathVariable String id, @RequestBody CustomerEntity customer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);

        }
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);

        }
        return customerService.delete(id);
    }
}
