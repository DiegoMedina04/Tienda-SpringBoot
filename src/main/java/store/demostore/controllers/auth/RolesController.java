package store.demostore.controllers.auth;

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

import store.demostore.interfaces.auth.RolesServiceInterface;
import store.demostore.models.entities.auth.RolesEntity;
import store.demostore.utils.Constants;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.BASE_URL + "/rol")
public class RolesController {

    @Autowired
    private RolesServiceInterface roleInterface;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(roleInterface.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(roleInterface.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RolesEntity rol) {
        return roleInterface.save(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody RolesEntity role) {
        return roleInterface.update(id, role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return roleInterface.delete(id);
    }

}
