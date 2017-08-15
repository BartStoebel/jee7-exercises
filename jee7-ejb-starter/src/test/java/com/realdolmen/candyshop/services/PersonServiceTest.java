package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.AbstractWeldContainerTest;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @InjectMocks
    private PersonServiceBean personService = new PersonServiceBean();

    @Mock
    private PersonRepository repository;

    @Test
    public void personServiceHasPersonRepository() throws Exception {
        assertNotNull(personService);
        assertNotNull(personService.getPersonRepository());
        personService.findPersonById(1507);
        verify(repository).findPersonById(anyLong());
    }

    @Test
    public void shouldSaveAPerson() throws Exception {
        personService.savePerson(new Person());
        verify(repository).savePerson(any(Person.class));
    }
}
