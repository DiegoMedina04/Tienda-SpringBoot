package store.demostore.controllers.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.demostore.interfaces.auth.UserServiceInterfaz;
import store.demostore.models.entities.auth.UserEntity;
import store.demostore.utils.Constants;

@RestController
// @CrossOrigin(origins = "*")
@CrossOrigin(origins = "*") 
@RequestMapping(Constants.BASE_URL + "/user")
public class UserController {

    @Autowired
    private UserServiceInterfaz userServiceInterfaz;

    @GetMapping
    public List<UserEntity> findAll() {
        return userServiceInterfaz.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return userServiceInterfaz.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserEntity user) {
        return userServiceInterfaz.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserEntity user) {
        return userServiceInterfaz.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return userServiceInterfaz.delete(id);
    }
}
