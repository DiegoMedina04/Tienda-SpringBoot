package store.demostore.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.PositionEntity;

public interface PositionServiceInterface {
    List<PositionEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(PositionEntity position);

    ResponseEntity<?> update(String id, PositionEntity position);

    ResponseEntity<?> delete(String id);

}
