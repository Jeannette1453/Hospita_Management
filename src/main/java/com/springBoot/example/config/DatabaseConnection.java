package com.springBoot.example.config;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/HospitalManagement";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
