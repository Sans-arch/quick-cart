package com.github.sansarch.quick_cart.product.infrastructure.presentation.handler.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> errors;
}
