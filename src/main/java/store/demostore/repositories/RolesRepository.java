package store.demostore.repositories;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.RolesEntity;

public interface RolesRepository extends CrudRepository<RolesEntity, String> {

}
