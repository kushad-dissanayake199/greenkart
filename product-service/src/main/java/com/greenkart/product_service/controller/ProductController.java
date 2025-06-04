package com.greenkart.product_service.controller;

import com.greenkart.product_service.model.Product;
import com.greenkart.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService service;

    @PostMapping
    public Mono<Product> create(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return service.deleteProduct(id);
    }

    @GetMapping
    public Flux<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @GetMapping("/search")
    public Flux<Product> search(@RequestParam String name) {
        return service.searchByName(name);
    }
}
