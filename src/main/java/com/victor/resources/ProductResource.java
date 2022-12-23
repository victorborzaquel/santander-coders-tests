package com.victor.resources;

import com.victor.models.Product;
import com.victor.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(productService.listProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @DeleteMapping
    public ResponseEntity<Product> removeProduct(Long id) {
        return ResponseEntity.ok(productService.removeProduct(id));
    }
}
