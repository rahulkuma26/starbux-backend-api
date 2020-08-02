package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.dto.OrderRequestDto;
import com.starbux.ecommerce.api.dto.OrderStatus;
import com.starbux.ecommerce.api.dto.ProductType;
import com.starbux.ecommerce.api.dto.UserReport;
import com.starbux.ecommerce.api.entity.Order;
import com.starbux.ecommerce.api.entity.Product;
import com.starbux.ecommerce.api.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private ProductService productService;

    @Test
    public void when_createUpdateOrder_thenOrderIsCreated() {
        log.debug(this.getClass().getName() + " METHOD: when_createUpdateOrder_thenOrderIsCreated");

        Product product = new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name());
        product.setProduct_Id(ProjectConstants.MOCK_PRODUCT_ID_VALUE);
        Order order = new Order(ProjectConstants.MOCK_USER_ID_VALUE, ProjectConstants.MOCK_CREATE_DATA_VALUE, OrderStatus.PENDING.name(), ProjectConstants.MOCK_TOTAL_AMOUNT_VALUE, ProjectConstants.MOCK_QUANTITY_VALUE, ProjectConstants.MOCK_DISCOUNT_AMOUNT_VALUE, ProjectConstants.MOCK_NET_AMOUNT_VALUE, Arrays.asList(product));
        order.setOrder_id(ProjectConstants.MOCK_ORDER_ID_VALUE);

        Mockito.when(productService.fetchProduct(ProjectConstants.MOCK_PRODUCT_ID_VALUE)).thenReturn(product);
        Mockito.when(orderRepository.save(ArgumentMatchers.any(Order.class))).thenReturn(order);

        OrderService orderService = new OrderServiceImpl(orderRepository, productService);
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setProduct_id(ProjectConstants.MOCK_PRODUCT_ID_VALUE);
        orderRequestDto.setUser_id(ProjectConstants.MOCK_USER_ID_VALUE);
        Order returnedOrder = orderService.createUpdateOrder(orderRequestDto);

        assertThat(returnedOrder.getOrder_id()).isEqualTo(ProjectConstants.MOCK_ORDER_ID_VALUE);
    }

    @Test
    public void when_fetchUserReport_thenUserReportShouldReturn() {
        log.debug(this.getClass().getName() + " METHOD: when_fetchUserReport_thenUserReportShouldReturn");
        Mockito.when(orderRepository.fetchUserReport()).thenReturn(Arrays.asList(new UserReport() {
            @Override
            public String getuserId() {
                return ProjectConstants.MOCK_USER_ID_VALUE.toString();
            }

            @Override
            public int getTotalOrder() {
                return ProjectConstants.MOCK_TOTAL_ORDER_VALUE;
            }

            @Override
            public double getTotalAmount() {
                return ProjectConstants.MOCK_TOTAL_AMOUNT_VALUE;
            }
        }));

        OrderService orderService = new OrderServiceImpl(orderRepository, productService);
        Assertions.assertThat(orderService.fetchUserReport().get(0).getuserId()).isEqualTo(ProjectConstants.MOCK_USER_ID_VALUE.toString());
    }

}