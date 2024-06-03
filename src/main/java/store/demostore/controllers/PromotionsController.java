package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import store.demostore.interfaces.PromotionsServiceInterface;
import store.demostore.models.entities.PromotionsEntity;
import store.demostore.utils.Constants;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.BASE_URL + "/promotions")
public class PromotionsController {

    @Autowired
    private PromotionsServiceInterface promotionsServiceInterface;

    @GetMapping
    public List<PromotionsEntity> findAll() {
        return promotionsServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return promotionsServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PromotionsEntity promotion) {

        return promotionsServiceInterface.save(promotion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody PromotionsEntity promotion) {
        return promotionsServiceInterface.update(id, promotion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return promotionsServiceInterface.delete(id);
    }

}
