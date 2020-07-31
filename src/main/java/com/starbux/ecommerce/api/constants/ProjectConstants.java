package com.starbux.ecommerce.api.constants;

public class ProjectConstants {
    public static final String QUERY_TO_FETCH_USER_REPORT = "SELECT IFNULL(o.user_id,0) AS UserId,IFNULL(COUNT(o.order_id),0) AS TotalOrder,IFNULL(sum(o.net_amount),0) AS TotalAmount FROM Orders o group by o.user_id";
}
