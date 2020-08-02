package com.starbux.ecommerce.api.repository;

import com.starbux.ecommerce.api.constants.ProjectConstants;
import com.starbux.ecommerce.api.dto.UserReport;
import com.starbux.ecommerce.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This interface will represent OrderRepository which takes Order as Entity and order id as primary key
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    //  findUserReport method to fetch total orders and total amount per user
    @Query(value = ProjectConstants.QUERY_TO_FETCH_USER_REPORT, nativeQuery = true)
    List<UserReport> fetchUserReport();
}
