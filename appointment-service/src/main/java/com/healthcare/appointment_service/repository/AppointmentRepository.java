package com.healthcare.appointment_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthcare.appointment_service.model.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByPatientId(String patientId);
}
