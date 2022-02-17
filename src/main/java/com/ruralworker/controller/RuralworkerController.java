package com.ruralworker.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruralworker.implService.RuralworkerImplService;
import com.ruralworker.model.RuralworkerDetails;

@RestController
public class RuralworkerController {
	
	@Autowired
	private RuralworkerImplService ruralworkerImplService;
	
	@PostMapping("/registerruralworker")
	public RuralworkerDetails registerRuralWorker(@RequestBody RuralworkerDetails ruralworkerDetails) {
		return ruralworkerImplService.registerRuralWorker(ruralworkerDetails);
		
	}
	
	@GetMapping("/getruralworkerdetails")
	public List<RuralworkerDetails> getRuralworkerDetails(){
		return ruralworkerImplService.getAllRuralworkerDetails();
		
	}
	
	@GetMapping("/getruralworkerdetails/unvarified")
	public List<RuralworkerDetails> getUnvarifiedRuralworkerDetails(){
		return ruralworkerImplService.getUnVarifiedList();
		
	}
	
	@PatchMapping("/updateruralworkerdetails/varified/{registernumber}")
	public RuralworkerDetails varifiedRuralworkerDetails(@RequestBody RuralworkerDetails ruralworkerDetails) {
		return ruralworkerImplService.varifiedRuralworkerDetails(ruralworkerDetails);
		
	}
	
	@GetMapping("/getruralworkerdetails/varified")
	public List<RuralworkerDetails> getVarifiedRuralworkerDetails(){
		return ruralworkerImplService.getVarifiedList();
		
	}
	
	@GetMapping("/getbyruralworkerregisternumber/{registerNumber}")
	public RuralworkerDetails getByRuralworkerRegisterNumber(@PathVariable("registerNumber") int registerNumber) {
		return ruralworkerImplService.getByRuralworkerRegisterNumber(registerNumber);
		
	}
	
	@PutMapping("/updateruralworkerdetails/{registernumber}")
	public RuralworkerDetails updateRuralworkerDetails(@RequestBody RuralworkerDetails ruralworkerDetails) {
		return ruralworkerImplService.updateRuralworkerDetails(ruralworkerDetails);
		
	}
	
	@DeleteMapping("/deleteruralworkerdetails/{registerNumber}")
	public String deleteRuralworkerDetails(@PathVariable ("registerNumber") int registerNumber) {
		ruralworkerImplService.deleteRuralworkerDetails(registerNumber);
		return "Deleted: " + registerNumber;
		
	}

}
