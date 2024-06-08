package store.demostore.models.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDto {
    String id;
    String employe;
    String customer;
    Long total;
    String observations;
    String code;
    String date;
    List<SaleDetailDto> detail;

}
