package store.demostore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import store.demostore.interfaces.ProductServiceInterface;
import store.demostore.models.entities.ProductEntity;
import store.demostore.services.handleErrors.HandleErrorsService;
import store.demostore.utils.Constants;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/product")
public class ProductController {

    @Autowired
    private ProductServiceInterface productServiceInterface;

    @Autowired
    private HandleErrorsService handleErrorsService;

    @GetMapping
    private List<ProductEntity> findAll() {
        return productServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return productServiceInterface.findById(id);
    }

    @PostMapping
    private ResponseEntity<?> save(@Valid @RequestBody ProductEntity product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return productServiceInterface.save(product);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@Valid @PathVariable String id, @RequestBody ProductEntity product,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return productServiceInterface.update(id, product);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> remove(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return productServiceInterface.delete(id);
    }
}
