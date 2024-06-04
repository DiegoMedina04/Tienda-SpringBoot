package store.demostore.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    private EmployeeEntity employe;

    @OneToOne
    private CustomerEntity customer;

    private Long total;

    private String observations;

    private String code;

    private String date;

    @ManyToMany
    private List<SaleDetailEntity> detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmployeeEntity getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeeEntity employe) {
        this.employe = employe;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SaleDetailEntity> getDetail() {
        return detail;
    }

    public void setDetail(List<SaleDetailEntity> detail) {
        this.detail = detail;
    }
}