package com.github.sansarch.quick_cart.application.product;

import com.github.sansarch.quick_cart.domain.product.Product;
import com.github.sansarch.quick_cart.domain.product.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsUseCase {

    private final ProductRepository productRepository;

    public GetAllProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute() {
        return this.productRepository.findAll();
    }
}
