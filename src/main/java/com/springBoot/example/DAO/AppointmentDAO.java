package com.springBoot.example.DAO;

import com.springBoot.example.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AppointmentDAO {

    @Autowired
    private Connection connection;

    public void insertAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointments(doctor_id, patient_id, appointment_date, status) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, appointment.getDoctorId());
        preparedStatement.setInt(2, appointment.getPatientId());
        preparedStatement.setTimestamp(3, appointment.getAppointmentDate());
        preparedStatement.setString(4, appointment.getStatus());
        preparedStatement.executeUpdate();
    }
}