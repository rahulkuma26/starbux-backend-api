package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFetchProduct_thenReturnProduct() {
       // given
        Product product=new Product("Black Coffee", 4 ,"Drink");
        entityManager.persist(product);
        entityManager.flush();

        // when
        List<Product> foundProduct =  productRepository.findAll();

        // then
        assertThat(foundProduct.size()).isGreaterThan(0);
    }
}
