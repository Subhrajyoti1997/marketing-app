package com.marketing.service;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {
	public void saveOneLead(Lead lead);

	public List<Lead> getAllLead();

	public void deleteLead(long id);

	public Lead getLeadById(long id);

}
