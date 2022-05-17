package com.ctse.product.service;
import com.ctse.product.model.Product;
import com.ctse.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInt {

    @Autowired
    private ProductRepository productService;

    @Autowired
    private MongoTemplate mongoTemplate;



    @Override
    public void createProduct(Product product) {

        try {
            productService.save(product);
        } catch (Exception e) {
            throw new RuntimeException("error getting the save product " + e);
        }

    }

    @Override
    public List<Product> products() {
        try {
            return productService.findAll();
        } catch (Exception e) {
            throw new RuntimeException("error getting list of product " + e);
        }
    }

    @Override
    public Optional<Product> getSingleProduct(String id) {
        try {
            Optional<Product> product = productService.findById(id);
            return product;
        } catch (Exception e) {
            throw new RuntimeException("error getting find a single product " + e);
        }

    }

    @Override
    public boolean editProduct(Product product, String id) {
        try {
            Optional<Product> product1 = productService.findById(id);
            if (product1.isEmpty()) {
                return false;
            } else {
                Product product2 = product1.get();
                product2.setName(product.getName());
                product2.setCategory(product.getCategory());
                product2.setDescription(product.getDescription());
                product2.setPrice(product.getPrice());
                product2.setIsDeliveryAvailable(product.getIsDeliveryAvailable());
                product2.setQuantity(product.getQuantity());

                ;

                productService.save(product2);
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("error getting update product " + e);
        }
    }

    @Override
    public boolean deleteProduct(String id) { try {
        if (id == null) {
            return false;
        } else {
            productService.deleteById(id);
            return true;
        }
    } catch (Exception e) {
        throw new RuntimeException("error getting delete product " + e);
    }
    }
}

