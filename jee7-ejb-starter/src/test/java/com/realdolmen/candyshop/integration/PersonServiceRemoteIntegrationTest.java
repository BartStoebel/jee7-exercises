package com.realdolmen.candyshop.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.PersonServiceBean;
import com.realdolmen.candyshop.services.PersonServiceRemote;
import com.realdolmen.candyshop.util.DateUtils;

public class PersonServiceRemoteIntegrationTest extends AbstractRemoteIntegrationTest {

	private static PersonServiceRemote personService;
	
	@BeforeClass
	public static void init() throws NamingException {
		personService = lookup("jee7-ejb-starter/PersonServiceBean!com.realdolmen.candyshop.services.PersonServiceRemote");		
	}
	@Test
	public void shouldFindAllPeople() throws Exception {
		List<Person> persons = personService.findAllPeople();
		assertTrue(persons.size() >= 5);
	}
	@Test
	public void shouldSavePerson() {
		Person person = new Person();
		person.setFirstName("theo");
		person.setLastName("Bekkerstest");
		person.setBirthDate(DateUtils.createDate("1970-01-01"));
		assertEquals(null, person.getId());
		person = personService.savePerson(person);
		assertNotNull(person.getId());
		
	}
	
}
