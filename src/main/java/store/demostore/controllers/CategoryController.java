package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.demostore.interfaces.CategoryServiceInterface;
import store.demostore.models.entities.CategoryEntity;
import store.demostore.utils.Constants;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(Constants.BASE_URL + "/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryServiceInterface categoryServiceInterface;

    @GetMapping
    public List<CategoryEntity> findAll() {
        return categoryServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return categoryServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryEntity category) {
        return categoryServiceInterface.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CategoryEntity category) {
        return categoryServiceInterface.update(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return categoryServiceInterface.delete(id);
    }
}
