package com.healthcare.billing_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthcare.billing_service.model.Billing;

public interface BillingRepository extends MongoRepository<Billing, String>{
	List<Billing> findByPatientId(String patientId);
}
