package com.realdolmen.candyshop.repository;

import java.util.List;

import javax.ejb.Remote;

import com.realdolmen.candyshop.domain.Person;

@Remote
public interface PersonRepositoryRemote {

	Person findPersonById(long id);

	List<Person> findAllPeople();

	void savePerson(Person p);

	void deletePersonById(long id);

	void updatePerson(Person p);

	long countAllPeople();

}