package com.realdolmen.candyshop.repository;

import java.util.List;

import javax.ejb.Remote;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.domain.Person;

@Remote
public interface CandyRepositoryRemote {

	double findAverageCandyPrice();

	List<Candy> findCandyByNameLike(String name);

	List<Candy> findUniqueCandyForPersonOrderHistory(Person p);

	List<Candy> findCandyByColor(CandyColor candyColor);

	List<Candy> findAllCandy();

}