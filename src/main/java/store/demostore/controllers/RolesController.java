package store.demostore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.demostore.interfaces.RolesServiceInterface;

import store.demostore.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_URL + "/roles")
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

}
