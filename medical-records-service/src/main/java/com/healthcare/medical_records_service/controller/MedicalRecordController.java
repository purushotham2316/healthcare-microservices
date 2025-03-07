package com.healthcare.medical_records_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.medical_records_service.model.MedicalRecord;
import com.healthcare.medical_records_service.service.MedicalRecordService;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {
	
	@Autowired
	private MedicalRecordService service;
	
	@GetMapping("/fetchallrecords")
	public List<MedicalRecord> getAllUsers() {
    List<MedicalRecord> records = service.getAllMedicalRecords();
        System.out.println(records);
        return records;
    }
	
	@GetMapping("/patient/{patientId}")
	public List<MedicalRecord> getRecordByPatientId(@PathVariable("patientId") String patientId)
	{
		return service.getRecordsByPatientId(patientId);
	}
	
	@PostMapping("/save")
	public MedicalRecord saveRecord(@RequestBody MedicalRecord record)
	{
		return service.saveRecord(record);
	}

	 @DeleteMapping("/delete/{id}")
	    public String deleteRecord(@PathVariable("id") String id) {
	        service.deleteRecord(id);
	        return "Medical record deleted successfully.";
	    }
}
