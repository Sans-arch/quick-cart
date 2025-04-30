package com.github.sansarch.quick_cart.product.domain.entity.vo;

import java.util.UUID;

public class ProductId {
    private final UUID id;

    private ProductId(UUID id) {
        this.id = id;
    }

    public UUID getValue() {
        return id;
    }

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }

    public static ProductId from(UUID id) {
        return new ProductId(id);
    }
}
