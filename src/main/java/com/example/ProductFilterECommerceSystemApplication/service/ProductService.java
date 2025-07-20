package com.example.ProductFilterECommerceSystemApplication.service;

import com.example.ProductFilterECommerceSystemApplication.entity.Product;
import com.example.ProductFilterECommerceSystemApplication.repository.ProductRepository;
import com.example.ProductFilterECommerceSystemApplication.spec.ProductSpecification;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public List<Product> saveAll(List<Product> products) {
        return repo.saveAll(products);
    }

    public Page<Product> search(String name, String category, BigDecimal priceMin,
                                BigDecimal priceMax, Boolean inStock, int page, int size) {

        Specification<Product> spec = Specification.where(ProductSpecification.nameContains(name))
                .and(ProductSpecification.categoryEquals(category))
                .and(ProductSpecification.priceGreaterThanOrEqual(priceMin))
                .and(ProductSpecification.priceLessThanOrEqual(priceMax))
                .and(ProductSpecification.inStock(inStock));

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return repo.findAll(spec, pageable);
    }
}

