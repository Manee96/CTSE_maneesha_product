package com.ctse.product.controller;


import com.ctse.product.model.Product;
import com.ctse.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;


    //endpoint for register
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return product;
    }

    //endpoint get all
    @GetMapping("/products")
    public List<Product> products() {
        return productService.products();
    }

    //endpoint for get single
    @GetMapping("/product")
    public Optional<Product> product(@RequestParam String id) {
        return productService.getSingleProduct(id);
    }

    // endpoint for update
    @PutMapping("products/{id}")
    public boolean editUser(@PathVariable String id, @RequestBody Product product) {
        return productService.editProduct(product, id);
    }

    // endpoint for delete
    @DeleteMapping("products/{id}")
    public boolean delete(@PathVariable String id) {
        return productService.deleteProduct(id);
    }


}
