package com.starbux.ecommerce.api.utills;

import com.starbux.ecommerce.api.models.Product;
import com.starbux.ecommerce.api.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabaseUtill {
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            log.info("Preloading data to products table " + productRepository.save(new Product("Black Coffee", 4 ,"Drink")));
            log.info("Preloading data to products table " + productRepository.save(new Product("Latte", 5 ,"Drink")));
            log.info("Preloading data to products table " + productRepository.save(new Product("Mocha", 6 ,"Drink")));
            log.info("Preloading data to products table " + productRepository.save(new Product("Tea", 4 ,"Drink")));
            log.info("Preloading data to products table " + productRepository.save(new Product("Milk", 2 ,"Topping")));
            log.info("Preloading data to products table " + productRepository.save(new Product("Hazelnut syrup", 3 ,"Topping")));
            log.info("Preloading data to products table " + productRepository.save(new Product("Chocolate sauce", 5 ,"Topping")));
            log.info("Preloading data to products table " + productRepository.save(new Product("Lemon", 2 ,"Topping")));
        };
    }
}
