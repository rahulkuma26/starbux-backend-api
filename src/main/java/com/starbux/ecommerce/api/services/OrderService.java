package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.dto.OrderRequestDto;
import com.starbux.ecommerce.api.dto.UserReport;
import com.starbux.ecommerce.api.models.Order;

import java.util.List;

/**
 * This interface will represent OrderService which defines craete , update and finalize order method
 */
public interface OrderService {
    Order createUpdateOrder(OrderRequestDto orderRequest);

    List<UserReport> fetchUserReport();
}
