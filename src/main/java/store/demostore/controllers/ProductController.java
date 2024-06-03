package store.demostore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import store.demostore.interfaces.ProductServiceInterface;
import store.demostore.models.entities.ProductEntity;
import store.demostore.utils.Constants;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/product")
public class ProductController {

    @Autowired
    private ProductServiceInterface productServiceInterface;

    @GetMapping
    private List<ProductEntity> findAll() {
        return productServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable String id) {
        return productServiceInterface.findById(id);
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody ProductEntity product) {
        return productServiceInterface.save(product);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable String id, @RequestBody ProductEntity product) {
        return productServiceInterface.update(id, product);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> remove(@PathVariable String id) {
        return productServiceInterface.delete(id);
    }
}
