package com.springBoot.example;

import com.springBoot.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HospitalService hospitalService = context.getBean(HospitalService.class);

        hospitalService.createTables();

        hospitalService.saveDoctor(new Doctor("Alice", "Uwineza", "Cardiology", "0782222222", "alice@hospital.com"));
        hospitalService.savePatient(new Patient("Brune", "Mutoni", Date.valueOf("2000-05-10"), "Female", "0791111111", "brune@gmail.com"));
        hospitalService.saveDoctorPatient(new DoctorPatient(1, 1));
        hospitalService.saveAppointment(new Appointment(1, 1, Timestamp.valueOf("2026-03-01 09:00:00"), "Scheduled"));
        hospitalService.saveMedicalRecord(new MedicalRecord(1, "Malaria", "Antimalarial drugs", 1));

        context.close();
    }
}