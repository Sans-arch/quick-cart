package com.github.sansarch.quick_cart.infrastructure.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank(message = "Name is required")
        @Schema(description = "Name of the product", example = "Gamer Mouse")
        String name,

        @Schema(description = "Description of the product", example = "High precision mouse with optical sensor, 7200 DPI")
        String description,

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        @Schema(description = "Price of the product", example = "149.90")
        BigDecimal price) {
}
