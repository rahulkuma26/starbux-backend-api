package com.starbux.ecommerce.api.utills;

import com.starbux.ecommerce.api.models.Product;
import com.starbux.ecommerce.api.services.OrderService;
import com.starbux.ecommerce.api.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabaseUtill {
    @Bean
    CommandLineRunner initDatabase(ProductService productService, OrderService orderService) {
        return args -> {
            log.info("Preloading data to products table " + productService.createProduct(new Product("Black Coffee", 4, "Drink")));
            log.info("Preloading data to products table " + productService.createProduct(new Product("Latte", 5, "Drink")));
            log.info("Preloading data to products table " + productService.createProduct(new Product("Mocha", 6, "Drink")));
            log.info("Preloading data to products table " + productService.createProduct(new Product("Tea", 4, "Drink")));
            log.info("Preloading data to products table " + productService.createProduct(new Product("Milk", 2, "Topping")));
            log.info("Preloading data to products table " + productService.createProduct(new Product("Hazelnut syrup", 3, "Topping")));
            log.info("Preloading data to products table " + productService.createProduct(new Product("Chocolate sauce", 5, "Topping")));
            log.info("Preloading data to products table " + productService.createProduct(new Product("Lemon", 2, "Topping")));

        };
    }
}
