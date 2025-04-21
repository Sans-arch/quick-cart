package com.github.sansarch.quick_cart.domain.product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(UUID id);
}
