package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.ProductEntity;

public interface ProductServiceInterface {
    List<ProductEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(ProductEntity product);

    ResponseEntity<?> update(String id, ProductEntity product);

    ResponseEntity<?> delete(String id);

}
