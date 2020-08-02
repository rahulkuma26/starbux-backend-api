package com.starbux.ecommerce.api.it;

import com.starbux.ecommerce.api.StarbuxEcommerceApplication;
import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.entity.Product;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarbuxEcommerceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIT {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveProduct() {
        log.debug(this.getClass().getName()+" METHOD:testRetrieveProduct");

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Product> response = restTemplate.exchange(
                createURLWithPort("/product/1"),
                HttpMethod.GET, entity, Product.class);

        assertEquals(ProjectConstants.MOCK_PRODUCT_ID_VALUE, response.getBody().getProduct_Id());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
