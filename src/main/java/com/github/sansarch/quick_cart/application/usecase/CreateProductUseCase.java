package com.github.sansarch.quick_cart.application.usecase;

import com.github.sansarch.quick_cart.application.gateway.ProductGateway;
import com.github.sansarch.quick_cart.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreateProductUseCase {
    private final ProductGateway productGateway;

    public Product execute(String name, String description, BigDecimal price) {
        Product product = new Product(name, description, price);
        return productGateway.save(product);
    }
}
