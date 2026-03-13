package com.springBoot.example.DAO;

import com.springBoot.example.DoctorPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DoctorPatientDAO {

    @Autowired
    private Connection connection;

    public void insertDoctorPatient(DoctorPatient doctorPatient) throws SQLException {
        String query = "INSERT INTO doctor_patient(doctor_id, patient_id) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, doctorPatient.getDoctorId());
        preparedStatement.setInt(2, doctorPatient.getPatientId());
        preparedStatement.executeUpdate();
    }
}