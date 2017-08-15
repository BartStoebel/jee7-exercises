package com.realdolmen.candyshop.services;

import java.util.List;

import javax.ejb.Remote;

import com.realdolmen.candyshop.domain.Person;

@Remote
public interface PersonServiceRemote {

	Person savePerson(Person person);

	Person findPersonById(long id);

	List<Person> findAllPeople();

}