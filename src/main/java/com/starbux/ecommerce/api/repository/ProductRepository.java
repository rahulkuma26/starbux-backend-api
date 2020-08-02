package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * This interface will represent ProductRepository which takes Product as Entity and product id as primary key
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    //  fetchToppingReport method to fetch mostly used topping
    @Query(value = ProjectConstants.QUERY_TO_FETCH_TOPPING_REPORT, nativeQuery = true)
    String fetchToppingReport();
}
