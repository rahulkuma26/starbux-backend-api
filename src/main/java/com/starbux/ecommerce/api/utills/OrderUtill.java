package com.starbux.ecommerce.api.utills;

import com.starbux.ecommerce.api.dto.OrderResponseDto;
import com.starbux.ecommerce.api.exception.OrderNotFoundException;
import com.starbux.ecommerce.api.models.Order;
import com.starbux.ecommerce.api.models.Product;
import com.starbux.ecommerce.api.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * This class will represent OrderUtill
 */
@Slf4j
public class OrderUtill {

    public static OrderResponseDto conevrtEntitytoDto(Order order) {
        log.info("OrderUtill : Method : conevrtEntitytoDto");
        OrderResponseDto orderResponseObject = new OrderResponseDto();
        orderResponseObject.setDiscountAmount(order.getDiscountAmount());
        orderResponseObject.setNetAmount(order.getOrderNetAmount());
        orderResponseObject.setOrderId(order.getOrder_id());
        orderResponseObject.setToatlProductQuantity(order.getQuantity());
        orderResponseObject.setTotalAmount(order.getTotalAmount());
        return orderResponseObject;
    }

    public static double fetchDiscount(double totalAmount, int quantity, List<Product> productList) {
        double discount = 0;
        if (totalAmount > 12) {
            // discount one exist as cart toatl >12
            discount = (totalAmount * .25);
            log.info("OrderUtill : Method : fetchDiscount" + "total amount is greater then 12 so discount:" + discount);
        }
        if (quantity > 3) {
            // discount two exist as quantity > 3
            log.info("OrderUtill : Method : fetchDiscount" + "checking other discounts");
            Optional<Product> lowestProduct = productList.stream().min(Comparator.comparing(Product::getProductAmount));
            if (discount == 0) {
                // only discount two exist so returing its value
                log.info("OrderUtill : Method : fetchDiscount" + "quantity is more then 3. Lowest Price Product is free so discount:" + lowestProduct.get().getProductAmount());
                return lowestProduct.get().getProductAmount();
            } else if (discount > lowestProduct.get().getProductAmount()) {
                // discount one is greater then discount two so returing discount two
                log.info("OrderUtill : Method : fetchDiscount" + "quantity is more then 3. Lowest Price Product is free so discount:" + lowestProduct.get().getProductAmount());
                return lowestProduct.get().getProductAmount();
            }
        }
        return discount;
    }

    public static List<Product> fetchProductList(Long orderId, OrderRepository orderRepository) {
        log.info("OrderUtill : Method : fetchProductList" + "fetching product list for given order id" + orderId);
        Optional<Order> order = orderRepository.findById(orderId);
        if (!order.isPresent())
            throw new OrderNotFoundException(orderId);
        return order.get().getProducts();
    }
}
