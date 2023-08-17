package com.example.examenfinal.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBAseConfig {
    @Value("${postgres}");
    private String username;
    @Value("${RAKOTONIAINA13}");
    private String password;
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgrsql://localhost/user_spring",
                username,
                password
        );
    }
}
