package store.demostore.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.ProductServiceInterface;
import store.demostore.interfaces.PromotionsServiceInterface;
import store.demostore.models.entities.PromotionsEntity;
import store.demostore.repositories.PromotionsRepository;

@Service
public class PromotionsService implements PromotionsServiceInterface {

    @Autowired
    private PromotionsRepository promotionsRepository;

    @Autowired
    private ProductServiceInterface productServiceInterface;

    @Override
    public List<PromotionsEntity> findAll() {
        return (List<PromotionsEntity>) promotionsRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        Optional<?> promotionFind = promotionsRepository.findById(id);
        if (promotionFind.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promocion no encontrada");
        }
        return ResponseEntity.ok(promotionFind.orElseThrow());
    }

    @Override
    public ResponseEntity<?> save(PromotionsEntity promotion) {

        try {
            ResponseEntity<?> validationResponse = validatePromotion(promotion);
            if (validationResponse != null) {
                return validationResponse;
            }
            return ResponseEntity.ok(promotionsRepository.save(promotion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> update(String id, PromotionsEntity promotion) {
        Optional<PromotionsEntity> promotionOptional = promotionsRepository.findById(id);
        if (!promotionOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promocion no encontrada");
        }

        PromotionsEntity promotionToUpdate = promotionOptional.orElseThrow();

        ResponseEntity<?> validationResponse = validatePromotion(promotion);
        if (validationResponse != null) {
            return validationResponse;
        }
        promotionToUpdate.setCode(promotion.getCode());
        promotionToUpdate.setDescription(promotion.getDescription());
        promotionToUpdate.setDiscountRate(promotion.getDiscountRate());
        promotionToUpdate.setFinalDate(promotion.getFinalDate());
        promotionToUpdate.setInitialDate(promotion.getInitialDate());
        promotionToUpdate.setName(promotion.getName());
        promotionToUpdate.setProducts(promotion.getProducts());

        return ResponseEntity.ok(promotionsRepository.save(promotionToUpdate));
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        Optional<PromotionsEntity> promotionFind = promotionsRepository.findById(id);
        if (promotionFind.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promocion no encontrada");

        }
        promotionsRepository.deleteById(id);
        return ResponseEntity.ok("Promocion eliminada");
    }

    private ResponseEntity<?> validatePromotion(PromotionsEntity promotion) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDate date1 = LocalDate.parse(promotion.getInitialDate().toString(), FORMATTER);
        LocalDate date2 = LocalDate.parse(promotion.getFinalDate().toString(), FORMATTER);

        if (!date1.isBefore(date2) || date1.isEqual(date2)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ingrese una fecha valida");
        }

        boolean productNotFound = promotion.getProducts().stream().anyMatch(
                product -> productServiceInterface.findById(product.getId()).getStatusCode() == HttpStatus.NOT_FOUND);
        if (productNotFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos no encontrados");
        }

        return null;
    }

}
