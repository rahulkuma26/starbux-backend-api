package com.starbux.ecommerce.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * This class will represent our order and its attributes
 */

@Data
@Entity
@Table(name = "orders") // the table in the database that will contain our order data
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_id;  // Each order will be given an auto-generated unique identifier when stored

    @Column(name = "user_id", nullable = false)
    private long userID; //  userId

    @Column(name = "cre_dtime", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createDateTime;  // order creation date

    @Column(name = "order_status", nullable = false)
    private String orderStatus;     // order status - it can be PENDIND , PAID as of now

    @Column(name = "total_amount", nullable = false)
    private double totalAmount; // Total Amount of the order

    @Column(name = "quantity", nullable = false)
    private int quantity;  // Total number of product in a order

    @Column(name = "discount_amount")
    private double discountAmount; // discount Amount on the order

    @Column(name = "net_amount", nullable = false)
    private double orderNetAmount; // final net Amount of the order

    @OneToMany
    private List<Product> products;   // mapping products to order for one to many mapping

    public Order() {
    }

    public Order(long userID, LocalDate createDateTime, String orderStatus, double totalAmount, int quantity, double discountAmount, double orderNetAmount, List<Product> products) {
        this.userID = userID;
        this.createDateTime = createDateTime;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
        this.discountAmount = discountAmount;
        this.orderNetAmount = orderNetAmount;
        this.products = products;
    }
}
