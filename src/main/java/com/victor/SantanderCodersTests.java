package com.victor;

import com.victor.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SantanderCodersTests implements CommandLineRunner {
    private final ProductRepository productRepository;

    public SantanderCodersTests(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(com.victor.SantanderCodersTests.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        productRepository
    }
}
