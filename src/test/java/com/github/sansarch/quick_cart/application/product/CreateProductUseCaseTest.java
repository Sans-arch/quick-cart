package com.github.sansarch.quick_cart.application.product;

import com.github.sansarch.quick_cart.domain.product.Product;
import com.github.sansarch.quick_cart.domain.product.ProductRepository;
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

    private ProductRepository productRepository;
    private CreateProductUseCase createProductUseCase;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        createProductUseCase = new CreateProductUseCase(productRepository);
    }

    @Test
    void shouldCreateProductSuccessfully() {
        String name = "Product Name";
        String description = "Product Description";
        BigDecimal price = BigDecimal.valueOf(19.99);

        Product product = Product.create(name, description, price);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = createProductUseCase.execute(name, description, price);

        assertNotNull(createdProduct.getId());
        assertEquals(name, createdProduct.getName());
        assertEquals(description, createdProduct.getDescription());
        assertEquals(price, createdProduct.getPrice());
        verify(productRepository).save(any(Product.class));
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