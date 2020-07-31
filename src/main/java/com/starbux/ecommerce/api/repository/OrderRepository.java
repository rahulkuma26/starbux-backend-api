package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This interface will represent OrderRepository which takes Order as Entity and order id as primary key
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT IFNULL(o.user_id,0) AS userID,IFNULL(COUNT(o.order_id),0) AS Total,IFNULL(sum(o.net_amount),0) AS totalOrders FROM Orders o group by o.user_id", nativeQuery = true)
    List<Object> findUserReport(); //  findUserReport method to fetch toatl orders and total amount per user
}
