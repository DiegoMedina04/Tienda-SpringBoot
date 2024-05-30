package store.demostore.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.CategoryEntity;

public interface CategoryServiceInterface {

    List<CategoryEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(CategoryEntity category);

    ResponseEntity<?> update(String id, CategoryEntity category);

    ResponseEntity<?> delete(String id);
}
