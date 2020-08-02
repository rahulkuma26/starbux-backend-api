package com.starbux.ecommerce.api.constants;

import java.time.LocalDate;

/**
 * This class will represent all project constants
 */

public class ProjectConstants {

    public static final String QUERY_TO_FETCH_USER_REPORT = "SELECT IFNULL(o.user_id,0) AS UserId,IFNULL(COUNT(o.order_id),0) AS TotalOrder,IFNULL(sum(o.net_amount),0) AS TotalAmount FROM Orders o group by o.user_id";
    public static final String QUERY_TO_FETCH_TOPPING_REPORT = "SELECT PRODUCT_NAME FROM PRODUCTS where PRODUCT_TYPE ='Topping' and PRODUCT_ID IN (SELECT PRODUCTS_PRODUCT_ID FROM ORDERS_PRODUCTS GROUP BY PRODUCTS_PRODUCT_ID)";
    public static final String MOST_USED_TOPPING = "Mostly used topping is ";

    public static final String MOCK_PRODUCT_NAME_VALUE = "Black Coffee";
    public static final double MOCK_PRODUCT_AMOUNT_VALUE = 4;
    public static final Long MOCK_USER_ID_VALUE = Long.valueOf(123);
    public static final LocalDate MOCK_CREATE_DATA_VALUE = LocalDate.now();
    public static final double MOCK_TOTAL_AMOUNT_VALUE = 10;
    public static final double MOCK_DISCOUNT_AMOUNT_VALUE = 0;
    public static final double MOCK_NET_AMOUNT_VALUE = 10;
    public static final int MOCK_QUANTITY_VALUE = 1;
    public static final Long MOCK_PRODUCT_ID_VALUE = Long.valueOf(1);
    public static final Long MOCK_ORDER_ID_VALUE = Long.valueOf(1);
    public static final String MOCK_TOPPING_NAME_VALUE = "LEMON";
    public static final int MOCK_TOTAL_ORDER_VALUE = 1;


}
