package store.demostore.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.CompanyEntity;

public interface CompanyServiceInterface {

    List<CompanyEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(CompanyEntity company);

    ResponseEntity<?> update(String id, CompanyEntity company);

    ResponseEntity<?> delete(String id);

}
