package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface will represent ProductRepository which takes Product as Entity and product id as primary key
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
