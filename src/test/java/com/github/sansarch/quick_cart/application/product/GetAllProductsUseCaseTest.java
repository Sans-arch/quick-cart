package com.github.sansarch.quick_cart.application.product;

import com.github.sansarch.quick_cart.domain.product.Product;
import com.github.sansarch.quick_cart.domain.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetAllProductsUseCaseTest {

    private ProductRepository productRepository;
    private GetAllProductsUseCase getAllProductsUseCase;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        getAllProductsUseCase = new GetAllProductsUseCase(productRepository);
    }

    @Test
    void shouldReturnAllProducts() {
        Product product1 = Product.create("Product 1", "Description 1", BigDecimal.valueOf(10.0));
        Product product2 = Product.create("Product 2", "Description 2", BigDecimal.valueOf(20.0));
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = getAllProductsUseCase.execute();

        assertEquals(2, products.size());
        assertEquals("Product 1", products.get(0).getName());
        assertEquals("Product 2", products.get(1).getName());
        verify(productRepository).findAll();
    }
}