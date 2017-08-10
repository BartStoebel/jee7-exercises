package com.realdolmen.candyshop.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.repositories.CandyRepository;

@ApplicationScoped
public class CandyService {

	@Inject
	private CandyRepository candyRepository;
	
	@Inject 
	private PersonService personService;
	
	
	public void findAllCandy() {
		// TODO Auto-generated method stub
		
	}

	public CandyRepository getCandyRepository() {
		return this.candyRepository;
	}

	public PersonService getPersonService() {
		// TODO Auto-generated method stub
		return this.personService;
	}
	
	
}
