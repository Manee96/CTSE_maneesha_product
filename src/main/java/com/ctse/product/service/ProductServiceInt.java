package com.ctse.product.service;


import com.ctse.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInt {

    void createProduct(Product product);

    public List<Product> products();

    public Optional<Product> getSingleProduct(String id);

    public boolean editProduct(Product product, String id);

    public boolean deleteProduct(String id);

}
