package com.realdolmen.candyshop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AbstractPersistenceTest {
    private static EntityManagerFactory emf;

    protected EntityManager em;

    @BeforeClass
    public static void initializeEntityManagerFactory() {
    	//Create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CandyShop");
    }

    @Before
    public void initializeEntityManagerWithTransaction() {
        em = emf.createEntityManager();

        // TODO: begin a transaction
        em.getTransaction().begin();
    }

    @After
    public void rollbackTransactionAndCloseEntityManager() {
        // TODO: rollback the transaction
    	em.getTransaction().rollback();
        // TODO: close the entity manager
    	em.close();
    }

    @AfterClass
    public static void destroyEntityManagerFactory() {
        // TODO; close the EntityManagerFactory
    	emf.close();
    }
}
