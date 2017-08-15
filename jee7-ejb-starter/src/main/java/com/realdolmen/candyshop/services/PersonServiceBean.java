package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.repository.PersonRepository;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


// TODO Make this component a Stateless Session Bean and make its methods accessible remotely
@Stateless
@LocalBean
public class PersonServiceBean implements PersonServiceRemote {
    @Inject
    PersonRepository personRepository;

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.PersonServiceRemote#savePerson(com.realdolmen.candyshop.domain.Person)
	 */
    @Override
	public Person savePerson(Person person) {
        personRepository.savePerson(person);
        return person;
    }

    PersonRepository getPersonRepository() {
        return personRepository;
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.PersonServiceRemote#findPersonById(long)
	 */
    @Override
	public Person findPersonById(long id) {
        return personRepository.findPersonById(id);
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.PersonServiceRemote#findAllPeople()
	 */
    @Override
	public List<Person> findAllPeople() {
        return personRepository.findAllPeople();
    }
}
