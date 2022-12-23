package com.victor.services;

import com.victor.entities.Product;
import com.victor.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> listProducts() {
        return repository.findAll();
    }

    public Product findProductById(Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isEmpty()) {
            throw new IllegalStateException("Product not found");
        }

        return product.get();
    }

    public Product removeProduct(Long id) {
        Product product = findProductById(id);
        repository.delete(product);
        return product;
    }
}
