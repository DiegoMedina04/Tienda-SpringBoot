package store.demostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import store.demostore.interfaces.PromotionsServiceInterface;
import store.demostore.models.entities.PromotionsEntity;
import store.demostore.services.handleErrors.HandleErrorsService;
import store.demostore.utils.Constants;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping(Constants.BASE_URL + "/promotions")
public class PromotionsController {

    @Autowired
    private PromotionsServiceInterface promotionsServiceInterface;

    @Autowired
    private HandleErrorsService handleErrorsService;

    @GetMapping
    public List<PromotionsEntity> findAll() {
        return promotionsServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return promotionsServiceInterface.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PromotionsEntity promotion, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }

        return promotionsServiceInterface.save(promotion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable String id, @RequestBody PromotionsEntity promotion,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return promotionsServiceInterface.update(id, promotion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleErrorsService.vaidateErrors(bindingResult);
        }
        return promotionsServiceInterface.delete(id);
    }

}
