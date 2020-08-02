package com.starbux.ecommerce.api.it;

import com.starbux.ecommerce.api.StarbuxEcommerceApplication;
import com.starbux.ecommerce.api.dto.OrderRequestDto;
import com.starbux.ecommerce.api.dto.OrderResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarbuxEcommerceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerIT {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testCreateOrder() {
        log.debug(this.getClass().getName() + " METHOD:testCreateOrder");


        HttpEntity<OrderRequestDto> entity = new HttpEntity<OrderRequestDto>(new OrderRequestDto(0, 123, 1), headers);
        ResponseEntity<OrderResponseDto> response = restTemplate.exchange(
                createURLWithPort("/order"),
                HttpMethod.POST, entity, OrderResponseDto.class);
        assertTrue(response.getBody().getOrderId() > 0);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
