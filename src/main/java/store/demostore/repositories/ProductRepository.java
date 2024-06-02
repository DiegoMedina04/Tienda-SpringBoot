package store.demostore.repositories;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}
