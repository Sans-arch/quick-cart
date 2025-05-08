package com.github.sansarch.quick_cart.infrastructure.controller;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDto(
        @Schema(description = "Product ID", example = "123e4567-e89b-12d3-a456-426614174000") UUID id,

        @Schema(description = "Product name", example = "Gamer Mouse") String name,

        @Schema(description = "Product description", example = "High precision mouse with optical sensor, 7200 DPI")
        String description,

        @Schema(description = "Product price", example = "149.90") BigDecimal price) {
}
