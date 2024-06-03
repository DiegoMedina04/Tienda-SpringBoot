package store.demostore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.CompanyServiceInterface;
import store.demostore.models.entities.CompanyEntity;
import store.demostore.repositories.CompanyRepository;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyEntity> findAll() {
        return (List<CompanyEntity>) companyRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        return companyRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> save(CompanyEntity company) {
        CompanyEntity savedCompany = companyRepository.save(company);
        return ResponseEntity.ok().body(savedCompany);
    }

    @Override
    public ResponseEntity<?> update(String id, CompanyEntity company) {
        return companyRepository.findById(id)
                .map(record -> {
                    record.setName(company.getName());
                    record.setAddress(company.getAddress());
                    CompanyEntity updatedCompany = companyRepository.save(record);
                    return ResponseEntity.ok().body(updatedCompany);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        return companyRepository.findById(id)
                .map(record -> {
                    companyRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
