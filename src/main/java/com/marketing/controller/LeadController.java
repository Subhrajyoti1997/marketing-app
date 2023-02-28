package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.service.LeadService;
import com.marketing.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	@Autowired
	private EmailService emailService;

	//http:localhost:8080/create
	@RequestMapping("/create")
	//handler method call jsp page and load it in browser
	// below method is Handler method 
	public String viewCreateLeadForm() {
		return "LeadCreate";//here return keyword calling jsp page
	}
	//first way to read from data and save in database
	
	//http:localhost:8080/saveLead
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead")Lead lead,ModelMap model) { 
	//@ModelAttribute("lead") is not mandatory 
	//model = equivalent to request.setAttribute(in servlet) 
		//ModelMap also use as Model only 
	  emailService.sendEmail(lead.getEmail(),"welcome email","test");
		model.addAttribute("msg","record is saved");
		leadService.saveOneLead(lead);
	
		return "LeadCreate";

	}
	
	//second way to read from data
	
	//http:localhost:8080/saveLead
	
//	@RequestMapping("/saveLead")
//	public String saveLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") long mobile) {
//		Lead lead=new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadService.saveOneLead(lead);
//		return "LeadCreate";
//	}
	
	//third way
// @RequestMapping("/saveLead")
//	public String saveLead(LeadData leadData) {
//		Lead lead=new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		leadService.saveOneLead(lead);
//		return "LeadCreate";
//	}
	
	//http:localhost:8080/listAll
	@RequestMapping("/listAll")
	public String listLeads(Model model) {
		List<Lead> leads = leadService.getAllLead();
		model.addAttribute("leads",leads);
		//System.out.println(leads);
		
		return "list_leads";	
		}
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id")long id,Model model) {
		leadService.deleteLead(id);
		//only firstline of this method delete but
		//after delete redirect to list_lesds page so write below 3 lines
		List<Lead> leads = leadService.getAllLead();
		model.addAttribute("leads",leads);
		return "list_leads";
		
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id")long id,Model model) {
		Lead lead = leadService.getLeadById(id);
		model.addAttribute("lead",lead);
		return "update_leads";
	}
	//http:localhost:8080/saveLead
		@RequestMapping("/updateLead")
		public String updateLead(@ModelAttribute("lead")Lead lead,ModelMap model) { 
			
			leadService.saveOneLead(lead);
			List<Lead> leads = leadService.getAllLead();
			model.addAttribute("leads",leads);
			return "list_leads";

			//Happyyyyy
			

		}
}
