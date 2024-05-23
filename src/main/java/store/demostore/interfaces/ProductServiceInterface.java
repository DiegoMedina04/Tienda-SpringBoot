package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.ProductEntity;

public interface ProductServiceInterface {
    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(String id);

    ProductEntity save(ProductEntity product);

    ProductEntity update(String id, ProductEntity product);

    void delete(String id);

}
