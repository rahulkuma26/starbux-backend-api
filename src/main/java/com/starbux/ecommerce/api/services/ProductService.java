package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.models.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This interface will represent ProductService defines CRUD methods on Product Repository
 */

@Validated
public interface ProductService {

    @NotNull List<Product> fetchAllProducts();

    Product fetchProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product createProduct(Product product);

    void deleteProduct(long id);

    void updateProduct(Product product, Long id);
}