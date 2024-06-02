package store.demostore.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.PromotionsEntity;

public interface PromotionsServiceInterface {
    List<PromotionsEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(PromotionsEntity promotion);

    ResponseEntity<?> update(String id, PromotionsEntity promotion);

    ResponseEntity<?> delete(String id);

}
