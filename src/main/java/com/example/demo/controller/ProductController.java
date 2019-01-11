package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/test")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/insert")
    public int insertProduct(){
        Product product = new Product();
        product.setProductName("test");
        product.setProductPrice(BigDecimal.valueOf(99.9));
        product.setProductTax(BigDecimal.valueOf(77.7));

        int i = productService.insertProduct(product);
        return i;
    }

    @RequestMapping("/update")
    public int updateProduct(){
        Product product = new Product();
        product.setProductId(5);
        product.setProductName(null);
        product.setProductPrice(BigDecimal.valueOf(88.9));
        product.setProductTax(BigDecimal.valueOf(77.7));
        int i = productService.updateProduct(product);
        return i;
    }

    @RequestMapping("/selectOne")
    public Product getProductById(){
        Product product = productService.getProductById(4);
        return product;
    }

    @RequestMapping("selectList")
    public List<Product> getProductList(){
        return productService.findProducts();
    }

    @RequestMapping("delete")
    public int deleteProductById(){
       return productService.deleteProductById(5);
    }
}
