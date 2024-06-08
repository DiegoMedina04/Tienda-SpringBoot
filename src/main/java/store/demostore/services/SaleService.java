package store.demostore.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.ProductServiceInterface;
import store.demostore.models.dto.SaleDetailDto;
import store.demostore.models.dto.SaleDto;
import store.demostore.models.entities.ProductEntity;
import store.demostore.models.entities.SaleDetailEntity;
import store.demostore.models.entities.SaleEntity;
import store.demostore.repositories.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductServiceInterface productServiceInterface;

    public List<SaleDto> findAll() {
        List<SaleEntity> sales = (List<SaleEntity>) saleRepository.findAll();
        return sales.stream().map(this::mapperSaleToDto).collect(Collectors.toList());
    }

    public ResponseEntity<?> save(SaleEntity sale) {

        ResponseEntity<?> responseValidate = validateProducts(sale.getDetail());
        if (responseValidate != null) {
            return responseValidate;
        }

        sale.setTotal(calculateTotal(sale));

        for (SaleDetailEntity detail : sale.getDetail()) {
            detail.setSale(sale);
        }

        SaleEntity response = saleRepository.save(sale);

        return ResponseEntity.ok(response);
    }

    private ResponseEntity<?> validateProducts(List<SaleDetailEntity> saleDetails) {

        for (SaleDetailEntity detail : saleDetails) {

            ResponseEntity<?> response = productServiceInterface.findById(detail.getProduct().getId());
            if (response.getStatusCode() != HttpStatus.BAD_REQUEST) {
                detail.setProduct((ProductEntity) response.getBody());
                continue;
            }
            return response;
        }
        return null;
    }

    private long calculateTotal(SaleEntity sale) {
        return sale.getDetail().stream()
                .mapToLong(detail -> detail.getQuantity() * detail.getProduct().getPrice())
                .sum();
    }

    private SaleDto mapperSaleToDto(SaleEntity sale) {

        SaleDto saleDto = new SaleDto();
        saleDto.setId(sale.getId());
        saleDto.setEmploye(sale.getEmploye().getUserId().getName());
        saleDto.setCustomer(sale.getCustomer().getUserId().getName());
        saleDto.setTotal(sale.getTotal());
        saleDto.setObservations(sale.getObservations());
        saleDto.setCode(sale.getCode());
        saleDto.setDate(sale.getDate());

        List<SaleDetailDto> detailDto = sale.getDetail().stream().map(detail -> {
            SaleDetailDto saleDetailDto = new SaleDetailDto();
            saleDetailDto.setId(detail.getId());
            saleDetailDto.setProduct(detail.getProduct().getName());
            saleDetailDto.setSale(detail.getSale().getId());
            saleDetailDto.setQuantity(detail.getQuantity());
            return saleDetailDto;
        }).collect(Collectors.toList());

        saleDto.setDetail(detailDto);

        return saleDto;

    }

    public ResponseEntity<?> remove(String uuid) {
        saleRepository.deleteById(uuid);
        return ResponseEntity.ok("Eliminado!");

    }

}
