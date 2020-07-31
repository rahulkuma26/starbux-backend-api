package com.starbux.ecommerce.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class will represent OrderNotFoundAdvice.
 * when a requested order is not found then we will handle that exception and inform user about it
 */

@ControllerAdvice
public class OrderNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pOrderNotFoundHandler(OrderNotFoundException exception) {
        return exception.getMessage();
    }
}
