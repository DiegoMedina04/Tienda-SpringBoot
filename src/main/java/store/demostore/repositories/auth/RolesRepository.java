package store.demostore.repositories.auth;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.auth.RolesEntity;

public interface RolesRepository extends CrudRepository<RolesEntity, String> {

}
