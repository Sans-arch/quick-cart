package com.github.sansarch.quick_cart.application.product;

import com.github.sansarch.quick_cart.domain.product.Product;
import com.github.sansarch.quick_cart.domain.product.ProductRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(String name, String description, BigDecimal price) {
        Product product = Product.create(name, description, price);
        return productRepository.save(product);
    }
}
