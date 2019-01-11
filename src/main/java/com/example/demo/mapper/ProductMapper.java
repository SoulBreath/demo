package com.example.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;

import com.example.demo.entity.Product;

public interface ProductMapper { 

    @Insert("insert into product values (null, #{productName}, #{productPrice}, #{productTax})")
    public int insertProduct(Product product);

    @Update("update product set product_name=#{productName}, product_price=#{productPrice}, product_tax=#{productTax} where product_id=#{productId}")
    public int updateProduct(Product product);

    @Delete("delete from product where product_id=#{productId}")
    public int deleteProductById(Integer productId);

    @Select("select * from product where product_id=#{productId}")
    public Product getProductById(Integer productId);

    @Select("select * from product")
    public List<Product> findProducts();

}