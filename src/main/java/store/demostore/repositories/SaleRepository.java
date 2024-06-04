package store.demostore.repositories;

import org.springframework.data.repository.CrudRepository;
import store.demostore.models.entities.SaleEntity;

public interface SaleRepository extends CrudRepository<SaleEntity, String> {
}
