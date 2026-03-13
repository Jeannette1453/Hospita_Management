package com.springBoot.example.DAO;

import com.springBoot.example.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DoctorDAO {

    @Autowired
    private Connection connection;

    public void insertDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctors(first_name, last_name, specialty, phone_number, email) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, doctor.getFirstName());
        preparedStatement.setString(2, doctor.getLastName());
        preparedStatement.setString(3, doctor.getSpecialty());
        preparedStatement.setString(4, doctor.getPhoneNumber());
        preparedStatement.setString(5, doctor.getEmail());
        preparedStatement.executeUpdate();
    }
}