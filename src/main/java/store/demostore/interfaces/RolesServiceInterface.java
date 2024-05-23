package store.demostore.interfaces;

import java.util.List;
import java.util.Optional;

import store.demostore.models.entities.RolesEntity;

public interface RolesServiceInterface {
    List<RolesEntity> findAll();

    Optional<RolesEntity> findById(String id);

    RolesEntity save(RolesEntity rol);

    RolesEntity update(String id, RolesEntity rol);

    void delete(String id);
}
