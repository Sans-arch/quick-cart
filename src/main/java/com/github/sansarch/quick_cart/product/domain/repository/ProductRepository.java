package com.github.sansarch.quick_cart.product.domain.repository;

import com.github.sansarch.quick_cart.product.domain.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(UUID id);
}
