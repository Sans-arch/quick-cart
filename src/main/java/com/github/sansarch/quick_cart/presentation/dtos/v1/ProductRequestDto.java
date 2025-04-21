package com.github.sansarch.quick_cart.presentation.dtos.v1;

import java.math.BigDecimal;

public record ProductRequestDto(String name, String description, BigDecimal price) {
}
