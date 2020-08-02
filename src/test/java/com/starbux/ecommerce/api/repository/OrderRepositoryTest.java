package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.dto.OrderStatus;
import com.starbux.ecommerce.api.dto.ProductType;
import com.starbux.ecommerce.api.entity.Order;
import com.starbux.ecommerce.api.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void whenFetchProduct_thenReturnProduct() {
        log.debug(this.getClass().getName() + " METHOD: whenFetchProduct_thenReturnProduct");
        // given
        Product product = new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name());
        Order order = new Order(ProjectConstants.MOCK_USER_ID_VALUE, ProjectConstants.MOCK_CREATE_DATA_VALUE, OrderStatus.PENDING.name(), ProjectConstants.MOCK_TOTAL_AMOUNT_VALUE, ProjectConstants.MOCK_QUANTITY_VALUE, ProjectConstants.MOCK_DISCOUNT_AMOUNT_VALUE, ProjectConstants.MOCK_NET_AMOUNT_VALUE, Arrays.asList(product));
        entityManager.persist(product);
        entityManager.persist(order);
        entityManager.flush();

        // when
        List<Order> orderFound = orderRepository.findAll();

        // then
        assertThat(orderFound.size()).isGreaterThan(0);
    }
}