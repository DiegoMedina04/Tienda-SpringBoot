package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.demostore.interfaces.PositionServiceInterface;
import store.demostore.models.entities.PositionEntity;
import store.demostore.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_URL + "/position")
public class PositionController {

    @Autowired
    private PositionServiceInterface positionServiceInterface;

    @GetMapping
    public List<PositionEntity> getAllPositions() {
        return positionServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPositionById(@PathVariable String id) {
        return positionServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createPosition(@RequestBody PositionEntity position) {
        return positionServiceInterface.save(position);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePosition(@PathVariable String id, @RequestBody PositionEntity position) {
        return positionServiceInterface.update(id, position);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable String id) {
        return positionServiceInterface.delete(id);
    }
}
