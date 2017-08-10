package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.AbstractWeldContainerTest;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.util.PersonController;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PersonControllerTest extends AbstractWeldContainerTest {
    @Test
    public void personControllerHasPersonService() throws Exception {
        PersonController personController = container.instance().select(PersonController.class).get();
        assertNotNull(personController);
        personController.savePerson(new Person());
        personController.findPersonById(1507);
        assertNotNull(personController.getPersonService());
    }
}
