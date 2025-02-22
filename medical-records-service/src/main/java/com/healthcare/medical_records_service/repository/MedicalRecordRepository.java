package com.healthcare.medical_records_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.medical_records_service.model.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String>{
	List<MedicalRecord> findByPatientId(String patientId);
}
