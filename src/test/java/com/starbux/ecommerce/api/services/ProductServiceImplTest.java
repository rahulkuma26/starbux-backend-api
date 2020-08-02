package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.dto.ProductType;
import com.starbux.ecommerce.api.entity.Product;
import com.starbux.ecommerce.api.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void when_fetchAllProducts_thenProductShouldBeFound() {
        log.debug(this.getClass().getName() + " METHOD: when_fetchAllProducts_thenProductShouldBeFound");
        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name())));
        ProductService productService = new ProductServiceImpl(productRepository);
        List<Product> productList = productService.fetchAllProducts();
        assertThat(productList.size()).isGreaterThan(0);
    }

    @Test
    public void when_fetchProduct_thenProductShouldBeFound() {
        log.debug(this.getClass().getName() + " METHOD: when_fetchProduct_thenProductShouldBeFound");
        Mockito.when(productRepository.findById(ProjectConstants.MOCK_PRODUCT_ID_VALUE)).thenReturn(java.util.Optional.of(new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name())));
        ProductService productService = new ProductServiceImpl(productRepository);
        Product product = productService.fetchProduct(ProjectConstants.MOCK_PRODUCT_ID_VALUE);
        assertThat(product.getProductName()).isEqualTo(ProjectConstants.MOCK_PRODUCT_NAME_VALUE);
    }

    @Test
    public void when_createProduct_thenProductShouldBeCreated() {
        log.debug(this.getClass().getName() + " METHOD: when_createProduct_thenProductShouldBeCreated");
        Product product = new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name());
        Mockito.when(productRepository.save(product)).thenReturn(product);
        ProductService productService = new ProductServiceImpl(productRepository);
        Product returnedProduct = productService.createProduct(product);
        assertThat(returnedProduct.getProductName()).isEqualTo(product.getProductName());
    }

    @Test
    public void when_fetchToppingReport_thenToppingShouldReturn() {
        log.debug(this.getClass().getName() + " METHOD: when_fetchToppingReport_thenToppingShouldReturn");
        Mockito.when(productRepository.fetchToppingReport()).thenReturn(ProjectConstants.MOCK_TOPPING_NAME_VALUE);
        ProductService productService = new ProductServiceImpl(productRepository);
        assertThat(productService.fetchToppingReport()).isEqualTo(ProjectConstants.MOCK_TOPPING_NAME_VALUE);
    }
}