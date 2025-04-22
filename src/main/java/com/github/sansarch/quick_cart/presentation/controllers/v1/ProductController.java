package com.github.sansarch.quick_cart.presentation.controllers.v1;

import com.github.sansarch.quick_cart.application.product.CreateProductUseCase;
import com.github.sansarch.quick_cart.application.product.GetAllProductsUseCase;
import com.github.sansarch.quick_cart.presentation.dtos.v1.ProductRequestDto;
import com.github.sansarch.quick_cart.presentation.dtos.v1.ProductResponseDto;
import com.github.sansarch.quick_cart.presentation.mappers.v1.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto dto) {
        var saved = createProductUseCase.execute(dto.name(), dto.description(), dto.price());
        return ResponseEntity.ok(ProductMapper.toResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        var products = getAllProductsUseCase.execute();
        var productDtos = products.stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }
}
