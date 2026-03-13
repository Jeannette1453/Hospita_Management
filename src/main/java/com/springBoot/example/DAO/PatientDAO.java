package com.springBoot.example.DAO;

import com.springBoot.example.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PatientDAO {

    @Autowired
    private Connection connection;

    public void insertPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients(first_name, last_name, date_of_birth, gender, phone_number, email) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, patient.getFirstName());
        preparedStatement.setString(2, patient.getLastName());
        preparedStatement.setDate(3, patient.getDateOfBirth());
        preparedStatement.setString(4, patient.getGender());
        preparedStatement.setString(5, patient.getPhoneNumber());
        preparedStatement.setString(6, patient.getEmail());
        preparedStatement.executeUpdate();
    }
}