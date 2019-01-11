package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

@Transactional
@Component("productService")
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    @Resource
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public int insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    public Product getProductById(Integer  productId) {
        return productMapper.getProductById(productId);
    }

    public List<Product> findProducts() {
        return productMapper.findProducts();
    }

    public int deleteProductById(Integer productId) {
        return productMapper.deleteProductById(productId);
    }

}