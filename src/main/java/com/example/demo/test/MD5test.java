package com.example.demo.test;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5test {
    public static void main(String[] args){
        String api_key = "v420b63d9df61c24g11db6a2fe662e6c";
        String api_secret = "2420b63d9ef61c24g11db6a2fe662e6d";
        String no = "";
        String tel = "";

        String md5 = DigestUtils.md5Hex(api_key+no+tel+api_secret);
        System.out.println(md5);
    }


}
