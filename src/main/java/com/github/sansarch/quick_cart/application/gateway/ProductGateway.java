package com.github.sansarch.quick_cart.application.gateway;

import com.github.sansarch.quick_cart.domain.product.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductGateway {

    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(UUID id);
}
