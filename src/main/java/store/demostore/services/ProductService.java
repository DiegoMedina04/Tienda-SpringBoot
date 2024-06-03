package store.demostore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.CategoryServiceInterface;
import store.demostore.interfaces.ProductServiceInterface;
import store.demostore.models.entities.CategoryEntity;
import store.demostore.models.entities.ProductEntity;
import store.demostore.repositories.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryServiceInterface categoryServiceInterface;

    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().body("Producto no encontrado");
        }
        return ResponseEntity.ok().body(product);
    }

    @Override
    public ResponseEntity<?> save(ProductEntity product) {
        ProductEntity newProduct = productRepository.save(product);
        return ResponseEntity.ok().body(newProduct);
    }

    @Override
    public ResponseEntity<?> update(String id, ProductEntity product) {
        ProductEntity productToUpdate = productRepository.findById(id).orElse(null);
        if (productToUpdate == null) {
            return ResponseEntity.badRequest().body("Producto no encontrado");
        }

        Optional<CategoryEntity> findCategory = categoryServiceInterface
                .findCategoryONull(product.getCategoryId().getId());
        if (findCategory.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
        }

        productToUpdate.setCode(product.getCode());
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setImageUrl(product.getImageUrl());
        productToUpdate.setDateExpiry(product.getDateExpiry());
        productToUpdate.setCategoryId(product.getCategoryId());

        ProductEntity updatedProduct = productRepository.save(productToUpdate);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().body("Product not found");
        }

        productRepository.delete(product);
        return ResponseEntity.ok().body("Product deleted");
    }

}
