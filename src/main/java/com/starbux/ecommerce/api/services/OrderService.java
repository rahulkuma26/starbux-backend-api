package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.dto.OrderRequestDto;
import com.starbux.ecommerce.api.models.Order;

/**
 * This interface will represent OrderService which defines craete , update and finalize order method
 */
public interface OrderService {
    Order createUpdateOrder(OrderRequestDto orderRequest);
}
