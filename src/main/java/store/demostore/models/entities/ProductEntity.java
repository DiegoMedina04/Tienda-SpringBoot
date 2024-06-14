package store.demostore.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @Column(unique = true)
    private String code;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Long price;

    @NotNull
    private Long stock;

    @NotBlank
    private String dateExpiry;

    private String imageUrl;

    @NotNull
    private CategoryEntity categoryId;

}
