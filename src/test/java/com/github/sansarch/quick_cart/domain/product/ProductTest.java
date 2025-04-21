package com.github.sansarch.quick_cart.domain.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldCreateProductSuccessfully() {
        String name = "Shirt";
        String description = "A nice shirt";
        BigDecimal price = BigDecimal.valueOf(49.90);

        Product product = Product.create(name, description, price);

        assertNotNull(product.getId());
        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
        assertEquals(price, product.getPrice());
    }

    @Test
    void shouldThrowExceptionIfNameIsNull() {
        String description = "A nice shirt";
        BigDecimal price = BigDecimal.valueOf(49.90);

        assertThrows(IllegalArgumentException.class, () -> {
            Product.create(null, description, price);
        });
    }

    @Test
    void shouldThrowExceptionIfPriceIsNegative() {
        String name = "Shirt";
        String description = "A nice shirt";
        BigDecimal price = BigDecimal.valueOf(-49.90);

        assertThrows(IllegalArgumentException.class, () -> {
            Product.create(name, description, price);
        });
    }
}