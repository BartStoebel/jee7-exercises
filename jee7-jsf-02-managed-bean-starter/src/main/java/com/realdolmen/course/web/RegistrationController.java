package com.realdolmen.course.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import com.realdolmen.course.utils.DateUtils;

@Named
@RequestScoped
public class RegistrationController {

	private Person person;
	
	@Inject
	private PersonServiceBean ps;
	
	
	public void loadPerson() {
		this.person = ps.findById(1L);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
