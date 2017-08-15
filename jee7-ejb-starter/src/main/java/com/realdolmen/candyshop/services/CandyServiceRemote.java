package com.realdolmen.candyshop.services;

import java.util.List;

import javax.ejb.Remote;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.repository.CandyRepositoryRemote;

@Remote
public interface CandyServiceRemote {

	CandyRepositoryRemote getCandyRepository();

	List<Candy> findAllCandy();

	List<Candy> findCandyByColor(CandyColor candyColor);

}