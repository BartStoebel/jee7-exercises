package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.repository.CandyRepository;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

// TODO Make this component a Stateless Session Bean and make its methods accessible remotely

@Stateless
@LocalBean
public class CandyServiceBean implements CandyServiceRemote{
    @Inject
    CandyRepository candyRepository;

    @Inject
    PersonServiceBean personServiceBean;


    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.CandyService#getCandyRepository()
	 */
    @Override
	public CandyRepository getCandyRepository() {
        return candyRepository;
    }

    PersonServiceBean getPersonService() {
        return personServiceBean;
    }


    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.CandyService#findAllCandy()
	 */
    @Override
	public List<Candy> findAllCandy() {
        return candyRepository.findAllCandy();
    }


    /* (non-Javadoc)
	 * @see com.realdolmen.candyshop.services.CandyService#findCandyByColor(com.realdolmen.candyshop.domain.CandyColor)
	 */
    @Override
	public List<Candy> findCandyByColor(CandyColor candyColor) {
        return candyRepository.findCandyByColor(candyColor);
    }
}
