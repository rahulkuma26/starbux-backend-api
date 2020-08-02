package com.starbux.ecommerce.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starbux.ecommerce.api.dto.OrderRequestDto;
import com.starbux.ecommerce.api.dto.UserReport;
import com.starbux.ecommerce.api.entity.Order;
import com.starbux.ecommerce.api.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    public OrderControllerTest() {
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void when_createOrder_thenValidResponse() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_createOrder_thenValidResponse");
        Order order = new Order();
        order.setOrder_id(1);
        given(orderService.createUpdateOrder(new OrderRequestDto(1, 123, 1))).willReturn(order);
        mvc.perform(MockMvcRequestBuilders
                .post("/order")
                .content(asJsonString(new OrderRequestDto(1, 123, 1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void when_fetchUserReport_thenValidResponse() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_fetchUserReport_thenValidResponse");
        UserReport userReport = new UserReport() {
            @Override
            public String getuserId() {
                return "123";
            }

            @Override
            public int getTotalOrder() {
                return 3;
            }

            @Override
            public double getTotalAmount() {
                return 10;
            }
        };
        given(orderService.fetchUserReport()).willReturn(Arrays.asList(userReport));
        mvc.perform(MockMvcRequestBuilders
                .get("/report/user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}