package com.example.ProductFilterECommerceSystemApplication.controller;

import com.example.ProductFilterECommerceSystemApplication.entity.Product;
import com.example.ProductFilterECommerceSystemApplication.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.save(product);
    }

    @PostMapping("/bulk")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveAll(products);
    }

    @GetMapping
    public Page<Product> filterProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) BigDecimal priceMin,
            @RequestParam(required = false) BigDecimal priceMax,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.search(name, category, priceMin, priceMax, inStock, page, size);
    }
}

