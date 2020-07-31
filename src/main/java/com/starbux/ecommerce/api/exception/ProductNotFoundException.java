package com.starbux.ecommerce.api.exception;

/**
 * This class will represent ProductNotFoundException.
 * when a requested product is not found then we will handle that exception and inform user about it
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("The Product with id " + id + " is not present in our dataset ");
    }
}