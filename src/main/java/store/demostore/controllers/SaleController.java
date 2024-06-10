package store.demostore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import store.demostore.models.dto.SaleDto;
import store.demostore.models.entities.SaleEntity;
import store.demostore.services.SaleService;
import store.demostore.services.handleErrors.HandleErrorsService;
import store.demostore.utils.Constants;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private HandleErrorsService habErrorsService;

    @GetMapping
    public List<SaleDto> findAll() {
        return saleService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SaleEntity sale, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return habErrorsService.vaidateErrors(bindingResult);

        }
        return saleService.save(sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return habErrorsService.vaidateErrors(bindingResult);

        }
        return saleService.remove(id);
    }

}
