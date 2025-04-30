package com.github.sansarch.quick_cart.product.domain.entity;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Product {

    private final UUID id;
    private final String name;
    private final String description;
    private final BigDecimal price;

    private Product(UUID id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static Product create(String name, String description, BigDecimal price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        return new Product(UUID.randomUUID(), name, description, price);
    }

    public static Product with(UUID id, String name, String description, BigDecimal price) {
        return new Product(id, name, description, price);
    }
}
