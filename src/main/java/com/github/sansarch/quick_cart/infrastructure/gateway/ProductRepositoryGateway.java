package com.github.sansarch.quick_cart.infrastructure.gateway;

import com.github.sansarch.quick_cart.application.gateway.ProductGateway;
import com.github.sansarch.quick_cart.domain.product.entity.Product;
import com.github.sansarch.quick_cart.infrastructure.persistence.ProductJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductRepositoryGateway implements ProductGateway {
    private final ProductJpaRepository productJpaRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product save(Product product) {
        var persisted = productJpaRepository.save(productEntityMapper.toModel(product));
        return productEntityMapper.toDomainObject(persisted);
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream().map(productEntityMapper::toDomainObject).toList();
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productJpaRepository.findById(id).map(productEntityMapper::toDomainObject);
    }
}
