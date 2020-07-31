package com.starbux.ecommerce.api.dto;

/**
 * This interface will represent UserReport and its methods can be used to map the output of user report query
 */

public interface UserReport {
    String getuserId();

    int getTotalOrder();

    double getTotalAmount();
}
