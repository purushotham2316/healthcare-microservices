package com.healthcare.billing_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.billing_service.model.Billing;
import com.healthcare.billing_service.repository.BillingRepository;

@Service
public class BillingService {

	@Autowired
	private BillingRepository billingRepository;
	
	public List<Billing> getAllBills()
	{
		return billingRepository.findAll();
	}
	
	
	public List<Billing> getBillsByPatientId(String patientId) {
        return billingRepository.findByPatientId(patientId);
    }
	
	 public Billing createBill(Billing billing) {
	        billing.setStatus("Pending");
	        return billingRepository.save(billing);
	    }
	 
	 public Billing updateBill(String id, Billing billing) {
	        return billingRepository.findById(id).map(existingBill -> {
	            existingBill.setAmount(billing.getAmount());
	            existingBill.setStatus(billing.getStatus());
	            return billingRepository.save(existingBill);
	        }).orElse(null);
	    }
	 
	 public void deleteBill(String id) {
	        billingRepository.deleteById(id);
	    }
}
