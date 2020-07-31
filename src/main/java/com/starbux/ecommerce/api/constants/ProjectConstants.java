package com.starbux.ecommerce.api.constants;

/**
 * This class will represent all project constants
 */

public class ProjectConstants {

    public static final String QUERY_TO_FETCH_USER_REPORT = "SELECT IFNULL(o.user_id,0) AS UserId,IFNULL(COUNT(o.order_id),0) AS TotalOrder,IFNULL(sum(o.net_amount),0) AS TotalAmount FROM Orders o group by o.user_id";
    public static final String QUERY_TO_FETCH_TOPPING_REPORT = "SELECT PRODUCT_NAME FROM PRODUCTS where PRODUCT_TYPE ='Topping' and PRODUCT_ID IN (SELECT PRODUCTS_PRODUCT_ID FROM ORDERS_PRODUCTS GROUP BY PRODUCTS_PRODUCT_ID)";
    public static final String MOST_USED_TOPPING = "Mostly used topping is ";
}
