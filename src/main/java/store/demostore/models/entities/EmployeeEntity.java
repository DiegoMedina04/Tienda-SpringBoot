package store.demostore.models.entities;

import java.util.List;

import jakarta.persistence.*;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import store.demostore.models.entities.auth.UserEntity;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @Column(unique = true)
    private String code;

    @NotBlank
    @OneToOne
    private UserEntity userId;

    @NotBlank
    private Long salary;

    private Boolean isActive;

    @ManyToMany
    @JoinTable(name = "employees_positions", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "position_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
            "employee_id", "position_id" }))
    private List<PositionEntity> position;

}
