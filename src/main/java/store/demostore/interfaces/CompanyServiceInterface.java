package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.CompanyEntity;

public interface CompanyServiceInterface {

    List<CompanyEntity> findAll();

    Optional<CompanyEntity> findById(String id);

    CompanyEntity save(CompanyEntity company);

    CompanyEntity update(String id, CompanyEntity company);

    void delete(String id);

}
