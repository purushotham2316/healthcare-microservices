package com.healthcare.medical_records_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.medical_records_service.model.MedicalRecord;
import com.healthcare.medical_records_service.repository.MedicalRecordRepository;


@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository repository;
	
		public List<MedicalRecord> getAllMedicalRecords() {
			List<MedicalRecord> records = repository.findAll();
			System.out.println(records);
	        return records;
	    }
		
		
	public List<MedicalRecord> getRecordsByPatientId(String patientId)
	{
		return repository.findByPatientId(patientId);
	}
	
	public MedicalRecord saveRecord(MedicalRecord record)
	{
		return repository.save(record);
	}
	
	public void deleteRecord(String id)
	{
		repository.deleteById(id);
	}
	
	
	
}
