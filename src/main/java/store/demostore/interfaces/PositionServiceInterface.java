package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.PositionEntity;

public interface PositionServiceInterface {
    List<PositionEntity> findAll();

    Optional<PositionEntity> findById(String id);

    PositionEntity save(PositionEntity position);

    PositionEntity update(String id, PositionEntity position);

    void delete(String id);

}
