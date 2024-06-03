
package store.demostore.repositories;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.CustomerEntity;
import store.demostore.models.entities.auth.UserEntity;

import java.util.Optional;

/**
 * CompanyRepository
 */
/**
 * CompanyRepository
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findByUserId(UserEntity userId);

}