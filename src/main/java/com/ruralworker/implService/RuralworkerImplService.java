package com.ruralworker.implService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruralworker.dao.RuralworkerDao;
import com.ruralworker.model.RuralworkerDetails;
import com.ruralworker.service.RuralworkerService;

@Service
public class RuralworkerImplService implements RuralworkerService {
	
	@Autowired
	private RuralworkerDao ruralworkerDao;

	@Override
	public RuralworkerDetails registerRuralWorker(RuralworkerDetails ruralworkerDetails) {
		return ruralworkerDao.save(ruralworkerDetails);
		
	}

	@Override
	public List<RuralworkerDetails> getAllRuralworkerDetails() {
		return ruralworkerDao.findAll();
		
	}

	@Override
	public RuralworkerDetails getByRuralworkerRegisterNumber(int registerNumber) {
		return ruralworkerDao.findById(registerNumber).orElse(null);
		
	}

	@Override
	public RuralworkerDetails updateRuralworkerDetails(RuralworkerDetails ruralworkerDetails) {
		RuralworkerDetails exitRuralworkerDetails = ruralworkerDao.findById(ruralworkerDetails.getRegisterNumber()).orElse(null);
		exitRuralworkerDetails.setFirstName(ruralworkerDetails.getFirstName());
		exitRuralworkerDetails.setLastName(ruralworkerDetails.getLastName());
		exitRuralworkerDetails.setMobileNumber(ruralworkerDetails.getMobileNumber());
		exitRuralworkerDetails.setWorkName(ruralworkerDetails.getWorkName());
		exitRuralworkerDetails.setVillage(ruralworkerDetails.getVillage());
		exitRuralworkerDetails.setCity(ruralworkerDetails.getCity());
		exitRuralworkerDetails.setDistrict(ruralworkerDetails.getDistrict());
		exitRuralworkerDetails.setState(ruralworkerDetails.getState());
		exitRuralworkerDetails.setStatus(ruralworkerDetails.getStatus());
		return ruralworkerDao.save(exitRuralworkerDetails);
		
	}
	
	@Override
	public RuralworkerDetails varifiedRuralworkerDetails(RuralworkerDetails ruralworkerDetails) {
		RuralworkerDetails exitRuralworkerDetails = ruralworkerDao.findById(ruralworkerDetails.getRegisterNumber()).orElse(null);
		exitRuralworkerDetails.setStatus(ruralworkerDetails.getStatus());
		return ruralworkerDao.save(exitRuralworkerDetails);
		
	}

	@Override
	public void deleteRuralworkerDetails(int registerNumber) {
		ruralworkerDao.deleteById(registerNumber);
		
	}

	@Override
	public List<RuralworkerDetails> getUnVarifiedList() {
		return ruralworkerDao.findUnVarifiedList();
	}

	public List<RuralworkerDetails> getVarifiedList() {
		return ruralworkerDao.findVarifiedList();
	}

}
