package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService { 

    int insertProduct(Product product);

    int updateProduct(Product product);

    Product getProductById(Integer productId);

    int deleteProductById(Integer productId);

    List<Product> findProducts();

}