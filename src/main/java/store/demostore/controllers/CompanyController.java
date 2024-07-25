package store.demostore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import store.demostore.utils.Constants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import store.demostore.interfaces.CompanyServiceInterface;
import store.demostore.models.entities.CompanyEntity;
import store.demostore.services.handleErrors.HandleErrorsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.BASE_URL + "/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @Autowired
    private HandleErrorsService handleErrorsService;

    @GetMapping
    public List<CompanyEntity> findAll() {
        return companyServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return companyServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@Valid @RequestBody CompanyEntity company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return companyServiceInterface.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@Valid @PathVariable String id, @RequestBody CompanyEntity company,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return companyServiceInterface.update(id, company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@Valid @RequestParam String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return companyServiceInterface.delete(id);
    }

}
