package com.starbux.ecommerce.api.exception;

public class ProductNotAllowedException extends RuntimeException {
    public ProductNotAllowedException(Long id) {
        super("Product id  " + id + " is not allowed for this Order as this has been added earlier. Please select a different Product ");
    }
}
