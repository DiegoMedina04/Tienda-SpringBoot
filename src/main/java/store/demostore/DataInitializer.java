package store.demostore;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import store.demostore.models.entities.CategoryEntity;
import store.demostore.models.entities.ProductEntity;
import store.demostore.repositories.CategoryRepository;
import store.demostore.repositories.ProductRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataInitializer(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        CategoryEntity category1 = new CategoryEntity();
        category1.setName("Electrodomésticos");
        category1.setDescription("Todo lo relacionado con tecnología");
        category1.setIsActive(true);
        CategoryEntity category1Save = categoryRepository.save(category1);
        System.out.println("Guardo la primera----------------------------------------------------------------------");

        CategoryEntity category2 = new CategoryEntity();
        category2.setName("Ropa y Accesorios");
        category2.setDescription("Moda para todas las edades y estilos");
        category2.setIsActive(true);
        CategoryEntity category2Save = categoryRepository.save(category2);
        System.out.println("Guardo la segunda----------------------------------------------------------------------");

        ProductEntity product1 = new ProductEntity();
        product1.setCode("PRD001");
        product1.setName("Xiaomi 13");
        product1.setDescription("Smartphone de alta tecnología con cámara de última generación");
        product1.setPrice(5000L);
        product1.setStock(100L);
        product1.setDateExpiry("2025-12-31");
        product1.setCategoryId(category1Save);
        productRepository.save(product1);
        System.out.println(
                "Guardo el primer producto----------------------------------------------------------------------");

        ProductEntity product2 = new ProductEntity();
        product2.setCode("PRD002");
        product2.setName("Camiseta Deportiva");
        product2.setDescription("Camiseta ligera y transpirable para actividades deportivas");
        product2.setPrice(30L);
        product2.setStock(200L);
        product2.setDateExpiry("2024-12-31");
        product2.setCategoryId(category2Save);
        productRepository.save(product2);
        System.out.println(
                "Guardo el segundo producto----------------------------------------------------------------------");

    }
}