package com.starbux.ecommerce.api.exception;

/**
 * This class will represent OrderNotFoundException.
 * when a requested order is not found then we will handle that exception and inform user about it
 */

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("The Order with id " + id + " is not present in our dataset ");
    }
}
