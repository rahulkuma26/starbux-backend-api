package com.starbux.ecommerce.api.dto;

import lombok.Data;

/**
 * This class will represent OrderRequestDto.
 * when a user want to create , update and finalize its order then in the request parameters
 * order_id, user_id and product_id will be provided and that is mapped to OrderRequestDto.
 */

@Data
public class OrderRequestDto {
    private long order_id;
    private long user_id;
    private long product_id;

    public OrderRequestDto() {
    }

    public OrderRequestDto(long order_id, long user_id, long product_id) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.product_id = product_id;
    }
}
