package store.demostore.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @ManyToOne
    private EmployeeEntity employe;

    @NotBlank
    @ManyToOne
    private CustomerEntity customer;

    private Long total;

    private String observations;

    @NotBlank
    private String code;

    private String date;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetailEntity> detail;

}