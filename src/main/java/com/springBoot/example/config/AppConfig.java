package com.springBoot.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@ComponentScan("com.springBoot.example")
public class AppConfig {

    @Bean
    public Connection getConnection() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        return databaseConnection.getConnection();
    }
}
