package com.starbux.ecommerce.api.controllers;

import com.starbux.ecommerce.api.models.Product;
import com.starbux.ecommerce.api.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * This class will represent product controller to handle GET, POST , PUT and DELETE request.
 */

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")     // fetchAllProducts method to handle GET request
    public List<Product> fetchAllProducts() {
        log.info(this.getClass().getName() + "Method : fetchAllProducts :" + "fetching all products");
        return (List<Product>) productService.fetchAllProducts();
    }

    @GetMapping("/product/{id}")    // fetchProduct method to handle GET request and return product for requested ID
    public Product fetchProduct(@PathVariable long id) {
        log.info(this.getClass().getName() + "Method : fetchProduct :" + "fetching product for id:" + id);
        return productService.fetchProduct(id);
    }

    @DeleteMapping("/product/{id}")  // deleteProduct method to delete product for reuested id
    public void deleteProduct(@PathVariable long id) {
        log.info(this.getClass().getName() + "Method : deleteProduct :" + "deleting product for id:" + id);
        productService.deleteProduct(id);
    }

    @PostMapping("/product")    // createProduct method to create new product
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        log.info(this.getClass().getName() + "Method : createProduct :" + "creating new product with name:" + product.getProductName() + " type:" + product.getProductType() + " amount:" + product.getProductType());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productService.createProduct(product).getProduct_Id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/product/{id}")   // updateProduct method to update existing product
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable long id) {
        log.info(this.getClass().getName() + "Method : updateProduct :" + "updating product with id" + id + " name:" + product.getProductName() + " type:" + product.getProductType() + " amount:" + product.getProductType());
        productService.updateProduct(product, id);
        return ResponseEntity.noContent().build();
    }
}
