package com.github.sansarch.quick_cart.infrastructure.repository.product;

import com.github.sansarch.quick_cart.domain.product.Product;
import com.github.sansarch.quick_cart.domain.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Testcontainers
class ProductRepositoryImplIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:16-alpine")
    );

    @Autowired
    private ProductRepository productRepository;

    @DynamicPropertySource
    static void configurePostgresProperties(org.springframework.test.context.DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @Test
    void shouldSaveAndRetrieveProductFromDatabase() {
        String name = "Product from DB";
        String description = "Product saved in DB";
        BigDecimal price = BigDecimal.valueOf(300.25);

        Product product = Product.create(name, description, price);
        productRepository.save(product);

        Product retrievedProduct = productRepository.findById(product.getId()).orElseThrow();

        assertNotNull(retrievedProduct);
        assertEquals(name, retrievedProduct.getName());
        assertEquals(description, retrievedProduct.getDescription());
        assertEquals(price, retrievedProduct.getPrice());
    }
}