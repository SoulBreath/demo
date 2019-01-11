package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Product implements Serializable { 
    private static final long serialVersionUID = 1L;

    // 产品ID
    private Integer productId;

    // 产品名称
    private String productName;

    // 产品价格(不含税)
    private BigDecimal productPrice;

    // 产品增值税
    private BigDecimal productTax;

}