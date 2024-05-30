
package store.demostore.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.CategoryEntity;
import java.util.List;
import java.util.Optional;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, String> {

    Optional<CategoryEntity> findByName(String name);

    @Query("SELECT c FROM CategoryEntity c WHERE c.name =?1 AND c.id !=?2")
    List<CategoryEntity> findByNameAndDifferentId(Object name, String id);

}