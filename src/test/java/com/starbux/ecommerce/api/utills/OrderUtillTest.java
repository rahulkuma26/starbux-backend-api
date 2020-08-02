package com.starbux.ecommerce.api.utills;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.dto.OrderStatus;
import com.starbux.ecommerce.api.dto.ProductType;
import com.starbux.ecommerce.api.entity.Order;
import com.starbux.ecommerce.api.entity.Product;
import com.starbux.ecommerce.api.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
public class OrderUtillTest {

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void test_conevrtEntitytoDto() {
        log.info(this.getClass().getName() + " Method : test_conevrtEntitytoDto");
        Order order = new Order(ProjectConstants.MOCK_USER_ID_VALUE, ProjectConstants.MOCK_CREATE_DATA_VALUE, OrderStatus.PENDING.name(), ProjectConstants.MOCK_TOTAL_AMOUNT_VALUE, ProjectConstants.MOCK_QUANTITY_VALUE, ProjectConstants.MOCK_DISCOUNT_AMOUNT_VALUE, ProjectConstants.MOCK_NET_AMOUNT_VALUE, null);
        order.setOrder_id(ProjectConstants.MOCK_ORDER_ID_VALUE);
        assertThat(OrderUtill.conevrtEntitytoDto(order).getOrderId()).isEqualTo(ProjectConstants.MOCK_ORDER_ID_VALUE);
    }

    @Test
    public void test_fetchDiscount() {
        log.info(this.getClass().getName() + " Method : test_fetchDiscount");
        assertThat(OrderUtill.fetchDiscount(ProjectConstants.MOCK_TOTAL_AMOUNT_VALUE, ProjectConstants.MOCK_QUANTITY_VALUE, null)).isEqualTo(ProjectConstants.MOCK_DISCOUNT_AMOUNT_VALUE);
    }

    @Test
    public void test_fetchProductList() {
        log.info(this.getClass().getName() + " Method : test_fetchProductList");

        Product product = new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name());
        product.setProduct_Id(ProjectConstants.MOCK_PRODUCT_ID_VALUE);
        Order order = new Order(ProjectConstants.MOCK_USER_ID_VALUE, ProjectConstants.MOCK_CREATE_DATA_VALUE, OrderStatus.PENDING.name(), ProjectConstants.MOCK_TOTAL_AMOUNT_VALUE, ProjectConstants.MOCK_QUANTITY_VALUE, ProjectConstants.MOCK_DISCOUNT_AMOUNT_VALUE, ProjectConstants.MOCK_NET_AMOUNT_VALUE, Arrays.asList(product));
        order.setOrder_id(ProjectConstants.MOCK_ORDER_ID_VALUE);

        Mockito.when(orderRepository.findById(ProjectConstants.MOCK_ORDER_ID_VALUE)).thenReturn(java.util.Optional.of(order));
        assertThat(OrderUtill.fetchProductList(ProjectConstants.MOCK_ORDER_ID_VALUE, orderRepository).get(0).getProduct_Id()).isEqualTo(ProjectConstants.MOCK_PRODUCT_ID_VALUE);
    }


}