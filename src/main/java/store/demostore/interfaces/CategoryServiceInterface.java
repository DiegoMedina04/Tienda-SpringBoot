package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.CategoryEntity;

public interface CategoryServiceInterface {

    List<CategoryEntity> findAll();

    Optional<CategoryEntity> findById(String id);

    CategoryEntity save(CategoryEntity category);

    CategoryEntity update(String id, CategoryEntity category);

    void delete(String id);
}
