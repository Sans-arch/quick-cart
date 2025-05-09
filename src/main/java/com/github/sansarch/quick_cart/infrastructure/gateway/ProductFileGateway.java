package com.github.sansarch.quick_cart.infrastructure.gateway;

import com.github.sansarch.quick_cart.application.gateway.ProductGateway;
import com.github.sansarch.quick_cart.domain.product.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductFileGateway implements ProductGateway {
    // This is a placeholder implementation. In a real application, this would handle file operations.
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.empty();
    }
}
