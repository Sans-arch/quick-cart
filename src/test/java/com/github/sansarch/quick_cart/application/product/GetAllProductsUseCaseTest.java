package com.github.sansarch.quick_cart.application.product;

import com.github.sansarch.quick_cart.application.gateway.ProductGateway;
import com.github.sansarch.quick_cart.application.usecase.product.GetAllProductsUseCase;
import com.github.sansarch.quick_cart.domain.product.entity.Product;
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

    private ProductGateway productGateway;
    private GetAllProductsUseCase getAllProductsUseCase;

    @BeforeEach
    void setUp() {
        productGateway = mock(ProductGateway.class);
        getAllProductsUseCase = new GetAllProductsUseCase(productGateway);
    }

    @Test
    void shouldReturnAllProducts() {
        Product product1 = new Product("Product 1", "Description 1", BigDecimal.valueOf(10.0));
        Product product2 = new Product("Product 2", "Description 2", BigDecimal.valueOf(20.0));
        when(productGateway.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = getAllProductsUseCase.execute();

        assertEquals(2, products.size());
        assertEquals("Product 1", products.get(0).getName());
        assertEquals("Product 2", products.get(1).getName());
        verify(productGateway).findAll();
    }
}