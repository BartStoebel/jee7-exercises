package com.realdolmen.course.web;

import javax.inject.Inject;
import javax.inject.Named;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.repository.PersonRepository;

//Dit is een CDI bean

@Named("mySpecialController")
public class MySpecialController {
	
	@Inject
	private PersonRepository pr;
	
	public int calculatePurposeOfLife() {
		return 5 * 8 + 2;
	}
	
	public Person getPerson(long id) {
		//if (pr.findById(id))
		return pr.findById(id);
	}
}
