package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CandyRepository {
    EntityManager em;

    public double findAverageCandyPrice() {
        // TODO: implement this method
    	Query query = em.createQuery("Select AVG (c.price) from Candy c");
    	double avg = (double) query.getSingleResult();
        return avg;
    }

    public List<Candy> findCandyByNameLike(String name) {
        // TODO: implement this method
    	Query query = em.createQuery("Select c from Candy c where c.name LIKE :candyName", Candy.class );
    	query.setParameter("candyName", name);
    	//List<Candy> candies = ;
        return query.getResultList();
    }

    public List<Candy> findUniqueCandyForPersonOrderHistory(Person p) {
        // TODO: implement this method
    	/** eerst even bekijken welke sql we nodig hebben
    	 select ol.candy
    	 from Person p
    	join p.orderHistory o
    	join o.orderlines ol
    	where p.name = 
    	 */
    	TypedQuery<Candy> query = em.createQuery("select distinct ol.candy from Person p join p.orderHistory o "
    			+ "join o.orderLines ol where p.id = :pid order by ol.candy.name", Candy.class);
    	query.setParameter("pid", p.getId());
        return query.getResultList();
    }
}
