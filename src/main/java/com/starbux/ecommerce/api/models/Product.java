package com.starbux.ecommerce.api.models;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * This class will represent our product entity and its attributes
 */

@Data
@Entity
@Table(name = "products") // the table in the database that will contain our product data
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_Id;  // Each product will be given an auto-generated unique identifier when stored

    @Column(name = "product_name", nullable = false)
    private String productName; //  Name of the product

    @Column(name = "product_amount", nullable = false)
    private int productAmount; // Amount of the product

    @Column(name = "product_type", nullable = false)
    private String productType; // Type of the product - it can be Drink or Topping as of know

    public Product() {
        super();
    }

    public Product(String productName, int productAmount, String productType) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.productType = productType;
    }

}
