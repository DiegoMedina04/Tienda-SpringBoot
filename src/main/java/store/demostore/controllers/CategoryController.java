package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import store.demostore.interfaces.CategoryServiceInterface;
import store.demostore.models.entities.CategoryEntity;
import store.demostore.services.handleErrors.HandleErrorsService;
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

    @Autowired
    private HandleErrorsService serviceHandleErrors;

    @GetMapping
    public List<CategoryEntity> findAll() {
        return categoryServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return serviceHandleErrors.vaidateErrors(bindingResult);
        }
        return categoryServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CategoryEntity category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return serviceHandleErrors.vaidateErrors(bindingResult);
        }
        return categoryServiceInterface.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Valid @PathVariable String id, BindingResult bindingResult,
            @RequestBody CategoryEntity category) {
        if (bindingResult.hasErrors()) {
            return serviceHandleErrors.vaidateErrors(bindingResult);
        }
        return categoryServiceInterface.update(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return serviceHandleErrors.vaidateErrors(bindingResult);
        }
        return categoryServiceInterface.delete(id);
    }

}
