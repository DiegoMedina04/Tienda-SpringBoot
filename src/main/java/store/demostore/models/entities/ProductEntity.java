package store.demostore.models.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private Long price;

    @NotBlank
    private Long stock;

    @NotBlank
    private String dateExpiry;

    private String imageUrl;

    @NotBlank
    private CategoryEntity categoryId;

}
