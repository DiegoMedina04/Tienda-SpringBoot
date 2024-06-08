package store.demostore.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDetailDto {

    String id;
    String product;
    String sale;
    int quantity;
}
