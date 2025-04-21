package com.github.sansarch.quick_cart.infrastructure.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductModel, UUID> {
}
