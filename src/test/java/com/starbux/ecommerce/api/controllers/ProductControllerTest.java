package com.starbux.ecommerce.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.dto.ProductType;
import com.starbux.ecommerce.api.entity.Product;
import com.starbux.ecommerce.api.services.ProductService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    public ProductControllerTest() {
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void when_fetchAllProducts_thenReturnJsonArray() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_fetchAllProducts_thenReturnJsonArray");
        List<Product> productList = Arrays.asList(new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name()));
        given(productService.fetchAllProducts()).willReturn(productList);
        mvc.perform(MockMvcRequestBuilders
                .get("/products")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void when_fetchProductById_thenReturnJson() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_fetchProductById_thenReturnJson");
        given(productService.fetchProduct(1)).willReturn(new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name()));
        mvc.perform(MockMvcRequestBuilders
                .get("/product/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("Black Coffee"));
    }

    @Test
    public void when_deleteByProductById_thenValidResponse() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_deleteProductById_thenValidResponse");
        mvc.perform(MockMvcRequestBuilders.delete("/product/{id}", 1))
                .andExpect(status().isAccepted());
    }

    @Test
    public void when_updateByProductById_thenValidResponse() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_updateByProductById_thenValidResponse");
        mvc.perform(MockMvcRequestBuilders
                .put("/product/{id}", 1)
                .content(asJsonString(new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name())))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void when_createProduct_thenValidResponse() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_createOrder_thenValidResponse");
        mvc.perform(MockMvcRequestBuilders
                .post("/product")
                .content(asJsonString(new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name())))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void when_fetchToppingReport_thenValidResponse() throws Exception {
        log.debug(this.getClass().getName() + " METHOD : when_fetchToppingReport_thenValidResponse");
        given(productService.fetchToppingReport()).willReturn("Lemon");
        mvc.perform(MockMvcRequestBuilders
                .get("/report/topping")
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