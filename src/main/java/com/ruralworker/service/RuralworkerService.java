package com.ruralworker.service;

import java.util.List;

import com.ruralworker.model.RuralworkerDetails;

public interface RuralworkerService {
	
	public RuralworkerDetails registerRuralWorker(RuralworkerDetails ruralworkerDetails);
	
	public List<RuralworkerDetails> getAllRuralworkerDetails();
	
	public RuralworkerDetails getByRuralworkerRegisterNumber(int registerNumber);
	
	public RuralworkerDetails updateRuralworkerDetails(RuralworkerDetails ruralworkerDetails);
	
	public RuralworkerDetails varifiedRuralworkerDetails(RuralworkerDetails ruralworkerDetails);
	
	public void deleteRuralworkerDetails(int registerNumber);
	
	public List<RuralworkerDetails> getUnVarifiedList();
	
	public List<RuralworkerDetails> getVarifiedList();
	
}
