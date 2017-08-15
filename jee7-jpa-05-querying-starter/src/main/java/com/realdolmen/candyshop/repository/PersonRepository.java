package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

public class PersonRepository {
    EntityManager em;


    public Person findPersonById(long id) {
        // TODO: implement this method
    	Query query = em.createQuery("Select p from Person p where p.id = :pid");
    	query.setParameter("pid", id);
    	Person person = (Person) query.getSingleResult();
        return person;
    }

    public List<Person> findAllPeople() {
        // TODO: implement this method
    	TypedQuery<Person> query = em.createQuery("Select p from Person p order by p.lastName, p.firstName", Person.class);
    	List <Person> persons = query.getResultList();
        return persons;
    }

    public void savePerson(Person p) {
        // TODO: implement this method
    	em.persist(p);
    }

    public void deletePersonById(long id) {
        // TODO: implement this method
    	Person person = findPersonById(id);
    	em.remove(person);
    }

    public void updatePerson(Person p) {
    	p = em.merge(p);
    }

    public long countAllPeople() {
        // TODO: implement this method
    	return findAllPeople().size();
    }

}
