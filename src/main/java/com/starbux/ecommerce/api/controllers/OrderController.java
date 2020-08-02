package com.starbux.ecommerce.api.controllers;

import com.starbux.ecommerce.api.dto.OrderRequestDto;
import com.starbux.ecommerce.api.dto.OrderResponseDto;
import com.starbux.ecommerce.api.dto.UserReport;
import com.starbux.ecommerce.api.entity.Order;
import com.starbux.ecommerce.api.services.OrderService;
import com.starbux.ecommerce.api.utills.OrderUtill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class will represent order controller to handle create and update order post request.
 * when a user want to create , update and finalize its order then in the request parameters
 * order_id, user_id and product_id will be provided and that is mapped to OrderRequestDto.  in case of update.
 * Response will contain order id , total product count , total amount , discount amount
 * and net order amount
 */

@Slf4j
@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")  // create and update method to handle create , update and finalize order request
    public ResponseEntity<OrderResponseDto> createUpdateOrder(@RequestBody OrderRequestDto orderRequest) {
        Order order = orderService.createUpdateOrder(orderRequest);
        log.info(this.getClass().getName() + " Method : createUpdateOrder :" + " successfully created order with order id: " + order.getOrder_id());
        return new ResponseEntity<OrderResponseDto>(OrderUtill.conevrtEntitytoDto(order), HttpStatus.CREATED);
    }

    @GetMapping("/report/user")  // fetchUserReport method to get User reports
    public ResponseEntity<List<UserReport>> fetchUserReport() {
        log.info(this.getClass().getName() + " Method : fetchUserReport");
        return new ResponseEntity<List<UserReport>>(orderService.fetchUserReport(), HttpStatus.OK);
    }

}
