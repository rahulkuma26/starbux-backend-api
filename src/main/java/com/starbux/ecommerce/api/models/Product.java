package com.starbux.ecommerce.api.models;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "Product name is required.")
    @Column(name = "product_name")
    private String productName; //  Name of the product

    @NotNull(message = "Product amount is required.")
    @Column(name = "product_amount")
    private double productAmount; // Amount of the product

    @NotNull(message = "Product type is required.")
    @Column(name = "product_type")
    private String productType; // Type of the product - it can be Drink or Topping as of know

    public Product() {
        super();
    }

    public Product(@NotNull(message = "Product name is required.") String productName, @NotNull(message = "Product amount is required.") double productAmount, @NotNull(message = "Product type is required.") String productType) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.productType = productType;
    }

}
