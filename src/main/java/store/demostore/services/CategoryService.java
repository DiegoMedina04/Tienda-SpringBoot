package store.demostore.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.CategoryServiceInterface;
import store.demostore.models.entities.CategoryEntity;
import store.demostore.repositories.CategoryRepository;

@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAll() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return ResponseEntity.ok(optionalCategory.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> save(CategoryEntity category) {
        Optional<CategoryEntity> nameCategory = findCategoryName(category.getName());
        if (nameCategory.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria con nombre existente");
        }
        category.setIsActive(true);
        category.setUpdatedAt(new Date().toString());
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @Override
    public ResponseEntity<?> update(String id, CategoryEntity category) {
        Optional<CategoryEntity> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
        }

        List<CategoryEntity> nameCategory = findCategoryNameDifferentId(category.getId(), category.getName());

        if (nameCategory.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nombre para la categoria ya en uso");
        }

        CategoryEntity categoryDb = categoryOptional.orElseThrow();
        categoryDb.setName(category.getName());
        categoryDb.setDescription(category.getDescription());
        categoryDb.setUpdatedAt(new Date().toString());

        return ResponseEntity.ok(categoryRepository.save(categoryDb));
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria eliminada!");
    }

    private Optional<CategoryEntity> findCategoryName(String name) {
        return categoryRepository.findByName(name);

    }

    private List<CategoryEntity> findCategoryNameDifferentId(String id, String name) {
        return categoryRepository.findByNameAndDifferentId(name, id);
    }

    public Optional<CategoryEntity> findCategoryONull(String id) {

        return categoryRepository.findById(id);
    }
}
