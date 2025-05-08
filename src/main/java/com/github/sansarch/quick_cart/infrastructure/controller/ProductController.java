package com.github.sansarch.quick_cart.infrastructure.controller;

import com.github.sansarch.quick_cart.application.usecase.CreateProductUseCase;
import com.github.sansarch.quick_cart.application.usecase.GetAllProductsUseCase;
import com.github.sansarch.quick_cart.domain.product.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;

    @Operation(summary = "Create a new product", description = "Creates a new product with the given details.")
    @ApiResponse(responseCode = "200", description = "Product created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class)))
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(
            @Parameter(description = "Product details", required = true) @Valid @RequestBody ProductRequestDto dto) {
        Product savedProduct = createProductUseCase.execute(dto.name(), dto.description(), dto.price());
        var responseDto = new ProductResponseDto(savedProduct.getId().getValue(), savedProduct.getName(),
                savedProduct.getDescription(), savedProduct.getPrice());
        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Get all products", description = "Retrieves a list of all products.")
    @ApiResponse(responseCode = "200", description = "List of products retrieved successfully", content = @Content(
            mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class)))
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        var products = getAllProductsUseCase.execute();
        var productDtos = products.stream()
                .map(p -> new ProductResponseDto(p.getId().getValue(), p.getName(), p.getDescription(), p.getPrice()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }
}
