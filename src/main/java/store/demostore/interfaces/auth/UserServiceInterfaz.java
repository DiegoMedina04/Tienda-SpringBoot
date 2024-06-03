package store.demostore.interfaces.auth;

import java.util.List;

import org.springframework.http.ResponseEntity;

import store.demostore.models.entities.auth.UserEntity;

public interface UserServiceInterfaz {
    List<UserEntity> findAll();

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> save(UserEntity rol);

    ResponseEntity<?> update(String id, UserEntity rol);

    ResponseEntity<?> delete(String id);
}
