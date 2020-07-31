package com.starbux.ecommerce.api.models;

import lombok.Data;

@Data
public class UserReport {
    private long user_id;
    private int totalOrders;
    private double totalAmount;

    public UserReport(long user_id, int totalOrders, double totalAmount) {
        this.user_id = user_id;
        this.totalOrders = totalOrders;
        this.totalAmount = totalAmount;
    }
}
