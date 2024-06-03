package store.demostore.models.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import store.demostore.models.entities.auth.UserEntity;

@Entity
@Table(name = "empleados")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // @Column(unique = true)
    private String code;

    @OneToOne
    private UserEntity userId;

    private Long salary;

    private Boolean isActive;

    @ManyToMany
    @JoinTable(name = "employees_positions", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "position_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
            "employee_id", "position_id" }))
    private List<PositionEntity> position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public List<PositionEntity> getPosition() {
        return position;
    }

    public void setPosition(List<PositionEntity> position) {
        this.position = position;
    }

}
