package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryIntegrationTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void whenFindByID_thenReturnProduct() {
    /*    // given
        Product product=new Product("Black Coffee", 4 ,"Drink");
        entityManager.persist(product);
        entityManager.flush();

        // when
        Product foundProduct = prdu.findById(1);

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());*/
    }

}

