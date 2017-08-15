package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.domain.Person;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

// TODO Make this a Stateless Session Bean
@Stateless
@LocalBean
public class CandyRepository implements CandyRepositoryRemote {
    // TODO Retrieve the EntityManager
	@PersistenceContext
    EntityManager em;

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.CandyRepositoryRemote#findAverageCandyPrice()
	 */
    @Override
	public double findAverageCandyPrice() {
        return em.createQuery("select avg(c.price) from Candy c", Double.class).getSingleResult();
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.CandyRepositoryRemote#findCandyByNameLike(java.lang.String)
	 */
    @Override
	public List<Candy> findCandyByNameLike(String name) {
        TypedQuery<Candy> query = em.createNamedQuery(Candy.FIND_BY_NAME_LIKE, Candy.class);
        query.setParameter("myName", '%' + name + '%');
        return query.getResultList();
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.CandyRepositoryRemote#findUniqueCandyForPersonOrderHistory(com.realdolmen.candyshop.domain.Person)
	 */
    @Override
	public List<Candy> findUniqueCandyForPersonOrderHistory(Person p) {
        return em.createQuery("select distinct c from Order o join o.orderLines ol join ol.candy c where o.person = :myPerson order by c.name", Candy.class)
                .setParameter("myPerson", p)
                .getResultList();
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.CandyRepositoryRemote#findCandyByColor(com.realdolmen.candyshop.domain.CandyColor)
	 */
    @Override
	public List<Candy> findCandyByColor(CandyColor candyColor) {
        return em.createQuery("select c from Candy c where c.color = :color", Candy.class).setParameter("color", candyColor).getResultList();
    }

    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.repository.CandyRepositoryRemote#findAllCandy()
	 */
    @Override
	public List<Candy> findAllCandy() {
        return em.createQuery("select c from Candy c", Candy.class).getResultList();
    }
}
