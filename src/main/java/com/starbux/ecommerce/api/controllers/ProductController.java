package com.starbux.ecommerce.api.controllers;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.entity.Product;
import com.starbux.ecommerce.api.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class will represent product controller to handle GET, POST , PUT and DELETE request.
 */

@Slf4j
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


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
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id) {
        log.info(this.getClass().getName() + "Method : deleteProduct :" + "deleting product for id:" + id);
        productService.deleteProduct(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/product")    // createProduct method to create new product
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        log.info(this.getClass().getName() + "Method : createProduct :" + "creating new product with name:" + product.getProductName() + " type:" + product.getProductType() + " amount:" + product.getProductType());
        return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")   // updateProduct method to update existing product
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id) {
        log.info(this.getClass().getName() + "Method : updateProduct :" + "updating product with id" + id + " name:" + product.getProductName() + " type:" + product.getProductType() + " amount:" + product.getProductType());
        return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @GetMapping("/report/topping")     // fetchToppingReport method to fetch topping report
    public ResponseEntity<String> fetchToppingReport() {
        log.info(this.getClass().getName() + "Method : fetchToppingReport :" + "fetching topping report");
        return new ResponseEntity<String>(ProjectConstants.MOST_USED_TOPPING.concat(productService.fetchToppingReport()), HttpStatus.OK);
    }
}
