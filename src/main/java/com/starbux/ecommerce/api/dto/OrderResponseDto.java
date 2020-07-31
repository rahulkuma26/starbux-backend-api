package com.starbux.ecommerce.api.dto;

import lombok.Data;

/**
 * This class will represent OrderResponseDto.
 * when a user want to create , update and finalize its order then in the response
 * order_id, total product quantity , toatal cart amount , discount on cart and net order amount will be provided and that is mapped to OrderRequestDto.
 */

@Data
public class OrderResponseDto {
    private long orderId;
    private double toatlProductQuantity;
    private double totalAmount;
    private double discountAmount;
    private double netAmount;

    public OrderResponseDto() {
    }

    public OrderResponseDto(long orderId, double toatlProductQuantity, double totalAmount, double discountAmount, double netAmount) {
        this.orderId = orderId;
        this.toatlProductQuantity = toatlProductQuantity;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.netAmount = netAmount;
    }
}
