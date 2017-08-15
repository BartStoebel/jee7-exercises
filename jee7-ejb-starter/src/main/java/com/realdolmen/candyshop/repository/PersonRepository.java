package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

// TODO Make this a Stateless Session Bean
@Stateless
@LocalBean
public class PersonRepository implements PersonRepositoryRemote {
    // TODO Retrieve the EntityManager
	@PersistenceContext
    EntityManager em;

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.PersonRepositoryRemote#findPersonById(long)
	 */
    @Override
	public Person findPersonById(long id) {
        return em.find(Person.class, id);
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.PersonRepositoryRemote#findAllPeople()
	 */
    @Override
	public List<Person> findAllPeople() {
        return em.createNamedQuery("find all people", Person.class).getResultList();
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.PersonRepositoryRemote#savePerson(com.realdolmen.candyshop.domain.Person)
	 */
    @Override
	public void savePerson(Person p) {
        em.persist(p);
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.PersonRepositoryRemote#deletePersonById(long)
	 */
    @Override
	public void deletePersonById(long id) {
        em.remove(em.getReference(Person.class, id));
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.PersonRepositoryRemote#updatePerson(com.realdolmen.candyshop.domain.Person)
	 */
    @Override
	public void updatePerson(Person p) {
        em.merge(p);
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.PersonRepositoryRemote#countAllPeople()
	 */
    @Override
	public long countAllPeople() {
        return em.createQuery("select count(p) from Person p", Long.class).getSingleResult();
    }

}
