package com.github.sansarch.quick_cart.product.application.usecase;

import com.github.sansarch.quick_cart.product.domain.entity.Product;
import com.github.sansarch.quick_cart.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CreateProductUseCase {
    private final ProductRepository productRepository;

    public Product execute(String name, String description, BigDecimal price) {
        Product product = Product.create(name, description, price);
        return productRepository.save(product);
    }
}
