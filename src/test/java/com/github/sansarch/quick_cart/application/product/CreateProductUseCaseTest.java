package com.github.sansarch.quick_cart.application.product;

import com.github.sansarch.quick_cart.application.usecase.product.CreateProductUseCase;
import com.github.sansarch.quick_cart.domain.product.entity.Product;
import com.github.sansarch.quick_cart.infrastructure.gateway.ProductRepositoryGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

    private ProductRepositoryGateway productRepositoryGateway;
    private CreateProductUseCase createProductUseCase;

    @BeforeEach
    void setUp() {
        productRepositoryGateway = mock(ProductRepositoryGateway.class);
        createProductUseCase = new CreateProductUseCase(productRepositoryGateway);
    }

    @Test
    void shouldCreateProductSuccessfully() {
        String name = "Product Name";
        String description = "Product Description";
        BigDecimal price = BigDecimal.valueOf(19.99);

        Product product = new Product(name, description, price);
        when(productRepositoryGateway.save(any(Product.class))).thenReturn(product);

        Product createdProduct = createProductUseCase.execute(name, description, price);

        assertNotNull(createdProduct.getId());
        assertEquals(name, createdProduct.getName());
        assertEquals(description, createdProduct.getDescription());
        assertEquals(price, createdProduct.getPrice());
        verify(productRepositoryGateway).save(any(Product.class));
    }

    @Test
    void shouldThrowExceptionIfProductNameIsInvalid() {
        String name = null;
        String description = "Product Description";
        BigDecimal price = BigDecimal.valueOf(19.99);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> createProductUseCase.execute(name, description, price));

        assertEquals("Name cannot be null", exception.getMessage());
    }
}