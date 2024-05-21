
package store.demostore.repositories;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.CategoryEntity;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, String> {

}