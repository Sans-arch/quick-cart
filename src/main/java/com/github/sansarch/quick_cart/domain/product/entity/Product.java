package com.github.sansarch.quick_cart.domain.product.entity;


import java.math.BigDecimal;

public final class Product {
    private final ProductId id;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public Product(String name, String description, BigDecimal price) {
        this.id = ProductId.generate();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(ProductId id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
