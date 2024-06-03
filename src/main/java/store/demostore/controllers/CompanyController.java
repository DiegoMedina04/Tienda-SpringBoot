package store.demostore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.demostore.utils.Constants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import store.demostore.interfaces.CompanyServiceInterface;
import store.demostore.models.entities.CompanyEntity;

@RestController
@RequestMapping(Constants.BASE_URL + "/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @GetMapping
    public List<CompanyEntity> findAll() {
        return companyServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return companyServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody CompanyEntity company) {
        return companyServiceInterface.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable String id, @RequestBody CompanyEntity company) {
        return companyServiceInterface.update(id, company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@RequestParam String id) {
        return companyServiceInterface.delete(id);
    }
}
