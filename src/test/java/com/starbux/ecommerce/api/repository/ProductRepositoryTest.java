package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.dto.ProductType;
import com.starbux.ecommerce.api.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFetchProduct_thenReturnProduct() {
        log.debug(this.getClass().getName()+ " METHOD: whenFetchProduct_thenReturnProduct");
        // given
        Product product = new Product(ProjectConstants.MOCK_PRODUCT_NAME_VALUE, ProjectConstants.MOCK_PRODUCT_AMOUNT_VALUE, ProductType.DRINK.name());
        entityManager.persist(product);
        entityManager.flush();

        // when
        List<Product> foundProduct = productRepository.findAll();

        // then
        assertThat(foundProduct.size()).isGreaterThan(0);
    }

}