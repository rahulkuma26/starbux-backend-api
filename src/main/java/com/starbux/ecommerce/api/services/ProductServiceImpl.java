package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.exception.ProductNotFoundException;
import com.starbux.ecommerce.api.models.Product;
import com.starbux.ecommerce.api.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * This class will represent ProductServiceImpl which implements ProductService and overrides all its method
 */
@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl() {
    }

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> fetchAllProducts() {
        log.info(this.getClass().getName() + "Method : fetchAllProducts :" + " fetching all products");
        return productRepository.findAll();
    }

    @Override
    public Product fetchProduct(long id) {
        log.info(this.getClass().getName() + "Method : fetchProduct :" + " fetching product with id: " + id);
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent())   // validating if requested product is availbale otherwise throwing exception
            throw new ProductNotFoundException(id);
        return product.get();
    }

    @Override
    public Product createProduct(Product product) {
        log.info(this.getClass().getName() + "Method : createProduct :" + " creating new product with name: " + product.getProductName() + " type:" + product.getProductType() + " amount:" + product.getProductType());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        log.info(this.getClass().getName() + "Method : deleteProduct : " + " deleting product with id: " + id);
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product, Long id) {
        log.info(this.getClass().getName() + "Method : updateProduct : " + " updateProduct product with id: " + id);
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())  // validating if requested product is availbale otherwise throwing exception
            throw new ProductNotFoundException(id);
        product.setProduct_Id(id);  // setting product id for which update has been requestd
        productRepository.save(product);
    }

    @Override
    public String fetchToppingReport() {
        log.info(this.getClass().getName() + "Method : fetchToppingReport  ");
        return productRepository.fetchToppingReport();
    }
}
