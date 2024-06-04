package store.demostore.services;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import store.demostore.interfaces.ProductServiceInterface;
import store.demostore.models.entities.ProductEntity;
import store.demostore.models.entities.SaleDetailEntity;
import store.demostore.models.entities.SaleEntity;
import store.demostore.repositories.SaleDetailRepository;
import store.demostore.repositories.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductServiceInterface productServiceInterface;

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    public List<SaleEntity> findAll() {
        return (List<SaleEntity>) saleRepository.findAll();
    }

    public ResponseEntity<?> save(SaleEntity sale) {
        try {
            validateProducts(sale.getDetail());
            sale.setTotal(calculateTotal(sale));
            SaleEntity response = saleRepository.save(sale);

            // List<SaleDetailEntity> detailsSave = mapper(response);
            // saleDetailRepository.save(detailsSave);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    private ResponseEntity<?> validateProducts(List<SaleDetailEntity> saleDetails) {

        for(SaleDetailEntity detail : saleDetails){
            ResponseEntity<?> response = productServiceInterface.findById(detail.getProduct().getId());
            if(response.getStatusCode() != HttpStatus.BAD_REQUEST){
                detail.setProduct((ProductEntity) response.getBody());
            }
            return ResponseEntity.notFound().build();
        }
        return  null;

       /*    List<Boolean> findProducts=  saleDetails.stream().map(product -> {
             ResponseEntity<?> response = productServiceInterface.findById(product.getProduct().getId());
            if(response.getStatusCode() != HttpStatus.BAD_REQUEST){
                product.setProduct((ProductEntity) response.getBody());
                return null;
            }
            return false;
         }).collect(Collectors.toList());;

        */

    }

    private long calculateTotal(SaleEntity sale) {
        long total = 0;

        for (int i = 0; i < sale.getDetail().size(); i++) {
            SaleDetailEntity detail = sale.getDetail().get(i);
            long priceProduct = detail.getProduct().getPrice();
            int quantityProduct = detail.getQuantity();

            total += priceProduct * quantityProduct;
        }
        return total;
    }

    private List<SaleDetailEntity> mapper(SaleEntity sale) {

        for (int i = 0; i < sale.getDetail().size(); i++) {
            sale.getDetail().get(i).setSale(sale);
        }
        return sale.getDetail();
    }

    public ResponseEntity<?> remove(String uuid) {
        saleRepository.deleteById(uuid);
        return ResponseEntity.ok("Eliminado!");

    }

}
