package com.github.sansarch.quick_cart.product.application.usecase;

import com.github.sansarch.quick_cart.product.domain.entity.Product;
import com.github.sansarch.quick_cart.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllProductsUseCase {
    private final ProductRepository productRepository;

    public List<Product> execute() {
        return this.productRepository.findAll();
    }
}
