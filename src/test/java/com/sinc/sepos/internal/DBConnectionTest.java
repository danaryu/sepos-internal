package com.sinc.sepos.internal;

import com.sinc.sepos.internal.mapper.ReportMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
public class DBConnectionTest {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    /*
        @Autowired
        StoreService storeService;
    */
    @Autowired
    ReportMapper reportMapper;

    @Test
    public void DB_커넥션_Test() throws ClassNotFoundException {

        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            System.out.println("con = " + con + " DB Connection 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 한글출력() throws UnsupportedEncodingException {
        //String word = "한글이 잘 출력되면 좋겠다 ㅜㅜ.";
        String word = reportMapper.getStoreNm();

        System.out.println("word = " + word);

        System.out.println("utf-8 -> euc-kr : " + new String(word.getBytes("utf-8"), "euc-kr"));
        System.out.println("utf-8 -> ksc5601 : " + new String(word.getBytes("utf-8"), "ksc5601"));
        System.out.println("utf-8 -> x-windows-949 : " + new String(word.getBytes("utf-8"), "x-windows-949"));
        System.out.println("utf-8 -> iso-8859-1 : " + new String(word.getBytes("utf-8"), "iso-8859-1"));

        System.out.println("iso-8859-1 -> euc-kr        : " + new String(word.getBytes("iso-8859-1"), "euc-kr"));
        System.out.println("iso-8859-1 -> ksc5601       : " + new String(word.getBytes("iso-8859-1"), "ksc5601"));
        System.out.println("iso-8859-1 -> x-windows-949 : " + new String(word.getBytes("iso-8859-1"), "x-windows-949"));
        System.out.println("iso-8859-1 -> utf-8         : " + new String(word.getBytes("iso-8859-1"), "utf-8"));

        System.out.println("euc-kr -> utf-8         : " + new String(word.getBytes("euc-kr"), "utf-8"));
        System.out.println("euc-kr -> ksc5601       : " + new String(word.getBytes("euc-kr"), "ksc5601"));
        System.out.println("euc-kr -> x-windows-949 : " + new String(word.getBytes("euc-kr"), "x-windows-949"));
        System.out.println("euc-kr -> iso-8859-1    : " + new String(word.getBytes("euc-kr"), "iso-8859-1"));

        System.out.println("ksc5601 -> euc-kr        : " + new String(word.getBytes("ksc5601"), "euc-kr"));
        System.out.println("ksc5601 -> utf-8         : " + new String(word.getBytes("ksc5601"), "utf-8"));
        System.out.println("ksc5601 -> x-windows-949 : " + new String(word.getBytes("ksc5601"), "x-windows-949"));
        System.out.println("ksc5601 -> iso-8859-1    : " + new String(word.getBytes("ksc5601"), "iso-8859-1"));

        System.out.println("x-windows-949 -> euc-kr     : " + new String(word.getBytes("x-windows-949"), "euc-kr"));
        System.out.println("x-windows-949 -> utf-8      : " + new String(word.getBytes("x-windows-949"), "utf-8"));
        System.out.println("x-windows-949 -> ksc5601    : " + new String(word.getBytes("x-windows-949"), "ksc5601"));
        System.out.println("x-windows-949 -> iso-8859-1 : " + new String(word.getBytes("x-windows-949"), "iso-8859-1"));

    }


}
