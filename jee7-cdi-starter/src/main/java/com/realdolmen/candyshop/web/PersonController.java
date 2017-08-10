package com.realdolmen.candyshop.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.PersonService;

@RequestScoped
public class PersonController {
	@Inject
	private PersonService personService;
	
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void findPersonById(int i) {
		// TODO Auto-generated method stub
		
	}

	public PersonService getPersonService() {
		return personService;
	}
	
	
	
}
