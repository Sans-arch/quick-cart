package com.github.sansarch.quick_cart.presentation.mappers.v1;

import com.github.sansarch.quick_cart.domain.product.Product;
import com.github.sansarch.quick_cart.presentation.dtos.v1.ProductRequestDto;
import com.github.sansarch.quick_cart.presentation.dtos.v1.ProductResponseDto;

public class ProductMapper {

    public static Product toDomain(ProductRequestDto dto) {
        return Product.create(dto.name(), dto.description(), dto.price());
    }

    public static ProductResponseDto toResponse(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
