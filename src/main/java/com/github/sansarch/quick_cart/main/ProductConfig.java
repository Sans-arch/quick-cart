package com.github.sansarch.quick_cart.main;

import com.github.sansarch.quick_cart.application.gateway.ProductGateway;
import com.github.sansarch.quick_cart.application.usecase.product.CreateProductUseCase;
import com.github.sansarch.quick_cart.application.usecase.product.GetAllProductsUseCase;
import com.github.sansarch.quick_cart.infrastructure.gateway.ProductEntityMapper;
import com.github.sansarch.quick_cart.infrastructure.gateway.ProductRepositoryGateway;
import com.github.sansarch.quick_cart.infrastructure.persistence.ProductJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCase(productGateway);
    }

    @Bean
    public GetAllProductsUseCase getAllProductsUseCase(ProductGateway productGateway) {
        return new GetAllProductsUseCase(productGateway);
    }

    @Bean
    public ProductGateway productGateway(ProductJpaRepository productJpaRepository, ProductEntityMapper productEntityMapper) {
        return new ProductRepositoryGateway(productJpaRepository, productEntityMapper);
    }

    @Bean
    public ProductEntityMapper productEntityMapper() {
        return new ProductEntityMapper();
    }
}
