package com.realdolmen.candyshop.services;

import javax.ejb.Remove;

import com.realdolmen.candyshop.domain.Person;

public interface RegistrationServiceRemote {

	void addPerson(String firstName, String lastName, String birthDate);

	void addAddress(String street, String number, String city, String postalCode);

	@Remove
	Person registerPerson();

}