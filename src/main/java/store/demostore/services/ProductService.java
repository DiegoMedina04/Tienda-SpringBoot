package store.demostore.services;

import java.util.List;
import java.util.Optional;

import store.demostore.interfaces.ProductServiceInterface;
import store.demostore.models.entities.ProductEntity;

public class ProductService implements ProductServiceInterface {

    @Override
    public List<ProductEntity> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ProductEntity update(String id, ProductEntity product) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
