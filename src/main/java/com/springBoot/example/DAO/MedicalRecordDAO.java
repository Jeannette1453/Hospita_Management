package com.springBoot.example.DAO;

import com.springBoot.example.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class MedicalRecordDAO {

    @Autowired
    private Connection connection;

    public void insertMedicalRecord(MedicalRecord medicalRecord) throws SQLException {
        String query = "INSERT INTO medical_records(patient_id, diagnosis, treatment, doctor_id) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, medicalRecord.getPatientId());
        preparedStatement.setString(2, medicalRecord.getDiagnosis());
        preparedStatement.setString(3, medicalRecord.getTreatment());
        preparedStatement.setInt(4, medicalRecord.getDoctorId());
        preparedStatement.executeUpdate();
    }
}