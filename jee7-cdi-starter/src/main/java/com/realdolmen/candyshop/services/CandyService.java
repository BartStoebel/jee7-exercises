package com.realdolmen.candyshop.services;

import javax.inject.Inject;

import com.realdolmen.candyshop.repositories.CandyRepository;

public class CandyService {

	@Inject
	private CandyRepository candyRepository;
	
	@Inject 
	private PersonService personService;
	
	
	public void findAllCandy() {
		// TODO Auto-generated method stub
		
	}

	public Object getCandyRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPersonService() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
