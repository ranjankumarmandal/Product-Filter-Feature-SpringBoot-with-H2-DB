package com.example.ProductFilterECommerceSystemApplication.spec;

import com.example.ProductFilterECommerceSystemApplication.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification {

    public static Specification<Product> nameContains(String name) {
        return (root, query, cb) -> name == null ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> categoryEquals(String category) {
        return (root, query, cb) -> category == null ? null : cb.equal(root.get("category"), category);
    }

    public static Specification<Product> priceGreaterThanOrEqual(BigDecimal priceMin) {
        return (root, query, cb) -> priceMin == null ? null : cb.greaterThanOrEqualTo(root.get("price"), priceMin);
    }

    public static Specification<Product> priceLessThanOrEqual(BigDecimal priceMax) {
        return (root, query, cb) -> priceMax == null ? null : cb.lessThanOrEqualTo(root.get("price"), priceMax);
    }

    public static Specification<Product> inStock(Boolean inStock) {
        return (root, query, cb) -> inStock == null ? null : cb.equal(root.get("inStock"), inStock);
    }
}

