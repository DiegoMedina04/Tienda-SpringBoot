package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.PromotionsEntity;

public interface PromotionsServiceInterface {
    List<PromotionsEntity> findAll();

    Optional<PromotionsEntity> findById(String id);

    PromotionsEntity save(PromotionsEntity promotion);

    PromotionsEntity update(String id, PromotionsEntity promotion);

    void delete(String id);

}
