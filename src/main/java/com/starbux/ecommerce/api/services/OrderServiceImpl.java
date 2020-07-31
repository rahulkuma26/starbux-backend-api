package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.dto.OrderRequestDto;
import com.starbux.ecommerce.api.dto.OrderStatus;
import com.starbux.ecommerce.api.dto.UserReport;
import com.starbux.ecommerce.api.models.Order;
import com.starbux.ecommerce.api.models.Product;
import com.starbux.ecommerce.api.repository.OrderRepository;
import com.starbux.ecommerce.api.utills.OrderUtill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will represent OrderServiceImpl which implements OrderService and overrides all its method
 */
@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public OrderServiceImpl() {
    }

    @Override
    public Order createUpdateOrder(OrderRequestDto orderRequest) {
        Long orderId = orderRequest.getOrder_id();
        Long productId = orderRequest.getProduct_id();
        double totalAmount = 0;
        int quantity = 0;
        double discountAmount = 0;
        Order order = new Order();
        Product product = productService.fetchProduct(productId); // fetching product deatils from given product id
        List<Product> productList = new ArrayList<>();

        /*if orderId is not present in request and coming as 0 then we will create a new order and will
        auto generate the order id. Otherwise id orderId is present then we will update the existing order
         */

        if (orderId == 0) {
            log.info(this.getClass().getName() + " Method : createUpdateOrder" + " creating new order with product id: " + productId);
        } else {
            log.info(this.getClass().getName() + " Method : createUpdateOrder " + " updating order for order id: " + orderId + " with product id: " + productId);
            order.setOrder_id(orderId);
            productList = OrderUtill.fetchProductList(orderId, orderRepository); // fetchig product list from already exsiting order
        }

        productList.add(product); // adding new product to product list
        totalAmount = productList.stream()         // calculating total amount from all products in order
                .mapToDouble(amount -> amount.getProductAmount())
                .sum();
        quantity = productList.size();   //  quantity in order will be equal to total products
        discountAmount = OrderUtill.fetchDiscount(totalAmount, quantity, productList); // fetching discount on order
        log.info(this.getClass().getName() + "Method : createUpdateOrder " + " totalAmount: " + totalAmount + " quantity: " + quantity + " discountAmount: " + discountAmount);

        // setting up all required attributes in order
        order.setUserID(orderRequest.getUser_id());
        order.setOrderStatus(OrderStatus.PENDING.name());
        order.setProducts(productList);
        order.setCreateDateTime(LocalDate.now());
        order.setQuantity(quantity);
        order.setTotalAmount(totalAmount);
        order.setDiscountAmount(discountAmount);
        order.setOrderNetAmount(totalAmount - discountAmount);

        return orderRepository.save(order);
    }

    @Override
    public List<UserReport> fetchUserReport() {
        log.info(this.getClass().getName() + " Method : fetchUserReport" + " fetching user report ");
        return orderRepository.fetchUserReport();
    }

}