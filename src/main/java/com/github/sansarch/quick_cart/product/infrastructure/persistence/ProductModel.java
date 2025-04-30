package com.github.sansarch.quick_cart.product.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductModel {

    @Id
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;
}
