package store.demostore.repositories.auth;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.auth.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
