package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import store.demostore.interfaces.PositionServiceInterface;
import store.demostore.models.entities.PositionEntity;
import store.demostore.services.handleErrors.HandleErrorsService;
import store.demostore.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_URL + "/position")
public class PositionController {

    @Autowired
    private PositionServiceInterface positionServiceInterface;

    @Autowired
    private HandleErrorsService handleErrorsService;

    @GetMapping
    public List<PositionEntity> getAllPositions() {
        return positionServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPositionById(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return positionServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createPosition(@Valid @RequestBody PositionEntity position, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return positionServiceInterface.save(position);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePosition(@Valid @PathVariable String id, @RequestBody PositionEntity position,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return positionServiceInterface.update(id, position);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePosition(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return positionServiceInterface.delete(id);
    }
}
