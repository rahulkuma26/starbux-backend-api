package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.models.Product;
import com.starbux.ecommerce.api.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ProductServiceImplIntegrationTest {
    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        Product product=new Product("Black Coffee", 4 ,"Drink");
        List<Product> productList =new ArrayList();
        productList.add(product);
        Mockito.when(productRepository.findAll()).thenReturn(productList);
    }
    @Test
    public void whenFetchProduct_thenProductShouldBeFound() {
        List<Product> productList = productService.fetchAllProducts();
        assertThat(productList.size()).isGreaterThan(0);
    }
}
