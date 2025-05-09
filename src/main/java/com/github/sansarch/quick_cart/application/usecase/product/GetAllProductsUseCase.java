package com.github.sansarch.quick_cart.application.usecase.product;

import com.github.sansarch.quick_cart.application.gateway.ProductGateway;
import com.github.sansarch.quick_cart.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllProductsUseCase {
    private final ProductGateway productGateway;

    public List<Product> execute() {
        return this.productGateway.findAll();
    }
}
