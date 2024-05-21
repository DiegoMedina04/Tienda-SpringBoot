package store.demostore.repositories;

import org.springframework.data.repository.CrudRepository;

import store.demostore.models.entities.PromotionsEntity;

public interface PromotionsRepository extends CrudRepository<PromotionsEntity, String> {

}
