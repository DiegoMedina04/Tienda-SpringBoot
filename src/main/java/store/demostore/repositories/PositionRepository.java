package store.demostore.repositories;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.PositionEntity;

public interface PositionRepository extends CrudRepository<PositionEntity, String> {

}
