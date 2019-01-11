package com.example.demo.test;

import org.springframework.util.DigestUtils;

public class MD5Util {

    public static String createMD5(String no, String tel){
        return DigestUtils.md5DigestAsHex((ConstantUtil.api_key+no+tel+ConstantUtil.api_secret).getBytes());
    }

}
