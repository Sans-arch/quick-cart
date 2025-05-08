package com.github.sansarch.quick_cart.infrastructure.gateway;

import com.github.sansarch.quick_cart.application.gateway.ProductGateway;
import com.github.sansarch.quick_cart.domain.product.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class ProductRepositoryGatewayTest {

    @Container
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:16-alpine")
    );

    @Autowired
    private ProductGateway productRepositoryGateway;

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

        Product product = new Product(name, description, price);
        productRepositoryGateway.save(product);

        Product retrievedProduct = productRepositoryGateway.findById(product.getId().getValue()).orElseThrow();

        assertNotNull(retrievedProduct);
        assertEquals(name, retrievedProduct.getName());
        assertEquals(description, retrievedProduct.getDescription());
        assertEquals(price, retrievedProduct.getPrice());
    }
}