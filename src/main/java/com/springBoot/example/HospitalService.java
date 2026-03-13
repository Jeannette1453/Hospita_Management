package com.springBoot.example;

import com.springBoot.example.DAO.AppointmentDAO;
import com.springBoot.example.DAO.DatabaseSetupDAO;
import com.springBoot.example.DAO.DoctorDAO;
import com.springBoot.example.DAO.DoctorPatientDAO;
import com.springBoot.example.DAO.MedicalRecordDAO;
import com.springBoot.example.DAO.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class HospitalService {

    @Autowired
    private DatabaseSetupDAO databaseSetupDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private AppointmentDAO appointmentDAO;

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @Autowired
    private DoctorPatientDAO doctorPatientDAO;

    public void createTables() throws SQLException {
        databaseSetupDAO.createTables();
    }

    public void saveDoctor(Doctor doctor) throws SQLException {
        doctorDAO.insertDoctor(doctor);
    }

    public void savePatient(Patient patient) throws SQLException {
        patientDAO.insertPatient(patient);
    }

    public void saveAppointment(Appointment appointment) throws SQLException {
        appointmentDAO.insertAppointment(appointment);
    }

    public void saveMedicalRecord(MedicalRecord medicalRecord) throws SQLException {
        medicalRecordDAO.insertMedicalRecord(medicalRecord);
    }

    public void saveDoctorPatient(DoctorPatient doctorPatient) throws SQLException {
        doctorPatientDAO.insertDoctorPatient(doctorPatient);
    }
}