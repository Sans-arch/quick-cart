package com.github.sansarch.quick_cart.presentation.dtos.v1;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDto(UUID id, String name, String description, BigDecimal price) {
}
