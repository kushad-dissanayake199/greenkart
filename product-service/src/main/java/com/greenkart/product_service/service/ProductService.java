package com.greenkart.product_service.service;

import com.greenkart.product_service.model.Product;
import com.greenkart.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Mono<Product> addProduct(Product product) {
        return repository.save(product);
    }

    public Mono<Product> updateProduct(Long id, Product updated) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setName(updated.getName());
                    existing.setDescription(updated.getDescription());
                    existing.setPrice(updated.getPrice());
                    existing.setQuantity(updated.getQuantity());
                    return repository.save(existing);
                });
    }

    public Mono<Void> deleteProduct(Long id) {
        return repository.deleteById(id);
    }

    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    public Mono<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public Flux<Product> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
