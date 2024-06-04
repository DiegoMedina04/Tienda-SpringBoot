package store.demostore.repositories;


import org.springframework.data.repository.CrudRepository;
import store.demostore.models.entities.SaleDetailEntity;

public interface SaleDetailRepository extends CrudRepository<SaleDetailEntity, String> {
}
