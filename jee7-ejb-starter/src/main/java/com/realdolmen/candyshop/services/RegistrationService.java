package com.realdolmen.candyshop.services;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;

import com.realdolmen.candyshop.domain.Address;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.util.DateUtils;

@Stateful
@Remote
@LocalBean
public class RegistrationService implements RegistrationServiceRemote {

	@Inject
	PersonServiceBean personService;
	
	private Person person;
	private Address address;
	
	/* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.RegistrationServiceRemote#addPerson(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
    public void addPerson(String firstName, String lastName, String birthDate) {
        this.person = new Person();
        this.person.setFirstName(firstName);
        this.person.setLastName(lastName);
        this.person.setBirthDate(DateUtils.createDate(birthDate));
    }
	/* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.RegistrationServiceRemote#addAddress(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
    public void addAddress(String street, String number, String city, String postalCode) {
        this.address = new Address(street, number, city, postalCode);
    }
	/* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.RegistrationServiceRemote#registerPerson()
	 */
	
	@Override
	@Remove
    public Person registerPerson() {
        this.person.setAddress(this.address);
        return personService.savePerson(person);
    }
	
}
