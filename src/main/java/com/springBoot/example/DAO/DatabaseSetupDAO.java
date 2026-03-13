package com.springBoot.example.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class DatabaseSetupDAO {

    @Autowired
    private Connection connection;

    public void createTables() throws SQLException {
        Statement statement = connection.createStatement();

        String doctorsTable = "CREATE TABLE doctors (" +
                "id SERIAL PRIMARY KEY," +
                "first_name VARCHAR(50)," +
                "last_name VARCHAR(50)," +
                "specialty VARCHAR(100)," +
                "phone_number VARCHAR(20)," +
                "email VARCHAR(100) UNIQUE," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";

        String patientsTable = "CREATE TABLE patients (" +
                "id SERIAL PRIMARY KEY," +
                "first_name VARCHAR(50)," +
                "last_name VARCHAR(50)," +
                "date_of_birth DATE," +
                "gender VARCHAR(20)," +
                "phone_number VARCHAR(20)," +
                "email VARCHAR(100) UNIQUE," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";

        String appointmentsTable = "CREATE TABLE appointments (" +
                "id SERIAL PRIMARY KEY," +
                "doctor_id INT," +
                "patient_id INT," +
                "appointment_date TIMESTAMP," +
                "status VARCHAR(20)," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE," +
                "FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE" +
                ")";

        String medicalRecordsTable = "CREATE TABLE medical_records (" +
                "id SERIAL PRIMARY KEY," +
                "patient_id INT," +
                "diagnosis TEXT," +
                "treatment TEXT," +
                "doctor_id INT," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE," +
                "FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE" +
                ")";

        String doctorPatientTable = "CREATE TABLE doctor_patient (" +
                "doctor_id INT," +
                "patient_id INT," +
                "PRIMARY KEY (doctor_id, patient_id)," +
                "FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE," +
                "FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE" +
                ")";

        statement.execute(doctorsTable);
        statement.execute(patientsTable);
        statement.execute(appointmentsTable);
        statement.execute(medicalRecordsTable);
        statement.execute(doctorPatientTable);
    }
}
