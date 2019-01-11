package com.example.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {

    public void load(String url, String param) {

        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            // 创建URL对象
            URL restURL = new URL(url);
            // 打开链接
            HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();

            // 设置请求方式
            conn.setRequestMethod("POST");
            // 设置是否从conn读入读出
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // 关闭缓存
            conn.setUseCaches(false);
            // 设置通用请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "UTF-8");


            out = new PrintWriter(conn.getOutputStream());

            out.print(param);

            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String readLine;

            while ((readLine = in.readLine()) != null){
                result.append(readLine);
            }

            String message = String.valueOf(result);
            String code = message.substring(message.indexOf(":")+1,message.indexOf(","));
            System.out.println(code);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
                if (in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
            String url = "http://47.101.38.113/box_shop_api.php";
            String param =  "F_type="+ ConstantUtil.F_type
                    + "&api_key="+ConstantUtil.api_key
                    + "&api_secret="+ConstantUtil.api_secret
                    + "&no=12399138274222"
                    + "&tel=17685915196"
                    + "&key="+MD5Util.createMD5("12399138274222","17685915196");
            new HttpTest().load(url, param);
    }
}
