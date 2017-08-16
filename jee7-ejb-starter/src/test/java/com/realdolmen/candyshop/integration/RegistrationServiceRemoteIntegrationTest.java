package com.realdolmen.candyshop.integration;

import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.RegistrationServiceRemote;

public class RegistrationServiceRemoteIntegrationTest extends AbstractRemoteIntegrationTest {

	private static RegistrationServiceRemote registrationService;
	
	@BeforeClass
	public static void init() throws NamingException {
		registrationService = lookup("jee7-ejb-starter/RegistrationService!com.realdolmen.candyshop.services.RegistrationServiceRemote");
	}
	@Test
	public void savePassengerWithAddress(){
		registrationService.addPerson("Theo", "Tester", "1970-01-01");
        registrationService.addAddress("Registrationstreet", "123", "MySQL", "9876");
        Person person = registrationService.registerPerson();
        assertNotNull(person.getId());
	}
	
}
