package com.starbux.ecommerce.api;

import com.starbux.ecommerce.api.controllers.OrderController;
import com.starbux.ecommerce.api.controllers.ProductController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class StarbuxEcommerceApplicationTests {
/*
    @Autowired
    private ProductController productController;

    @Autowired
    private OrderController orderController;

    @Test
    void contextLoads_productController() {
        log.info(this.getClass().getName() + " METHOD: contextLoads_productController");
        assertThat(productController).isNotNull();
    }

    @Test
    void contextLoads_orderController() {
        log.info(this.getClass().getName() + " METHOD: contextLoads_orderController");
        assertThat(orderController).isNotNull();
    }*/
}
