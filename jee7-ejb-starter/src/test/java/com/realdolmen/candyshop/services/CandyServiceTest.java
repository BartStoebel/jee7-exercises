package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.AbstractWeldContainerTest;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.repository.CandyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CandyServiceTest {
    @InjectMocks
    private CandyServiceBean candyService = new CandyServiceBean();

    @Mock
    private CandyRepository repository;

    @Mock
    private PersonServiceBean personService;

    @Test
    public void candyServiceHasCandyRepository() throws Exception {
        assertNotNull(candyService);
        assertNotNull(candyService.getCandyRepository());
        candyService.findAllCandy();
        verify(repository).findAllCandy();
    }

    @Test
    public void candyServiceHasPersonService() throws Exception {
        assertNotNull(candyService);
        assertNotNull(candyService.getPersonService());
    }

    @Test
    public void shouldReturnAllCandyByColor() {
        candyService.findCandyByColor(CandyColor.BLUE);
        verify(repository).findCandyByColor(any(CandyColor.class));
    }
}
