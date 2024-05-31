package store.demostore.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.RolesEntity;

public interface RolesServiceInterface {
    List<RolesEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(RolesEntity rol);

    ResponseEntity<?> update(String id, RolesEntity rol);

    ResponseEntity<?> delete(String id);
}
