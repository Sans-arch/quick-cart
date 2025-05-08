package com.github.sansarch.quick_cart.infrastructure.gateway;

import com.github.sansarch.quick_cart.domain.product.entity.Product;
import com.github.sansarch.quick_cart.domain.product.entity.ProductId;
import com.github.sansarch.quick_cart.infrastructure.persistence.ProductModel;

public class ProductEntityMapper {

    public ProductModel toModel(Product product) {
        return new ProductModel(product.getId().getValue(), product.getName(),
                product.getDescription(), product.getPrice());
    }

    public Product toDomainObject(ProductModel model) {
        return new Product(ProductId.from(model.getId()), model.getName(), model.getDescription(), model.getPrice());
    }
}
