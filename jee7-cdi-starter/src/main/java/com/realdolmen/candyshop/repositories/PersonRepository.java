package com.realdolmen.candyshop.repositories;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.domain.Person;

@ApplicationScoped
public class PersonRepository {
	
	@Inject 
	private transient Logger logger;
	
	public void savePerson(){
		logger.info("Saving person");
	}
	public Person findPersonById(){
		logger.info("findPersonById person");
		return new Person();
	}

}
