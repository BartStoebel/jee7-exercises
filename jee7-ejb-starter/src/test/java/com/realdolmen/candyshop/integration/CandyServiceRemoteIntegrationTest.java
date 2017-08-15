package com.realdolmen.candyshop.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.services.CandyServiceRemote;

public class CandyServiceRemoteIntegrationTest extends AbstractRemoteIntegrationTest {

		private static CandyServiceRemote candyService;
		
		@BeforeClass
		public static void init() throws NamingException {
			candyService = lookup("jee7-ejb-starter/CandyServiceBean!com.realdolmen.candyshop.services.CandyServiceRemote");
		}
		
		@Test
		public void shouldFindAllCandy() {
			List<Candy> candies = candyService.findAllCandy();
			assertEquals(6, candies.size());
		}
		
		@Test 
		public void shouldFindCandyByColor() {
			List<Candy> candies = candyService.findCandyByColor(CandyColor.BLUE);
			assertEquals(1, candies.size());
		}
}
