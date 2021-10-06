package com.sinc.sepos.internal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

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

}
