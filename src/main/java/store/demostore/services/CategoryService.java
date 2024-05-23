package store.demostore.services;

import java.util.List;
import java.util.Optional;

import store.demostore.interfaces.CategoryServiceInterface;
import store.demostore.models.entities.CategoryEntity;

public class CategoryService implements CategoryServiceInterface {

    @Override
    public List<CategoryEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<CategoryEntity> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public CategoryEntity update(String id, CategoryEntity category) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
