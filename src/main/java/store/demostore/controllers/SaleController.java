package store.demostore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.demostore.models.entities.CategoryEntity;
import store.demostore.models.entities.SaleEntity;
import store.demostore.services.SaleService;
import store.demostore.utils.Constants;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;



    @GetMapping
    public List<SaleEntity> findAll() {
        return saleService.findAll();
    }

     /*

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return saleService.findById(id);
    }

     */

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SaleEntity sale) {
        return saleService.save(sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return saleService.remove(id);
    }

}
