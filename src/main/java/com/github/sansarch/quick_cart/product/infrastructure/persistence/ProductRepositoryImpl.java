package com.github.sansarch.quick_cart.product.infrastructure.persistence;

import com.github.sansarch.quick_cart.product.domain.entity.Product;
import com.github.sansarch.quick_cart.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductModel model = toModel(product);
        productJpaRepository.save(model);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream().map(this::toEntity).toList();
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productJpaRepository.findById(id).map(this::toEntity);
    }

    private ProductModel toModel(Product product) {
        ProductModel model = new ProductModel();
        model.setId(product.getId());
        model.setName(product.getName());
        model.setDescription(product.getDescription());
        model.setPrice(product.getPrice());
        return model;
    }

    private Product toEntity(ProductModel model) {
        return Product.with(model.getId(), model.getName(), model.getDescription(), model.getPrice());
    }
}
