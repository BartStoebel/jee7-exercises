package com.realdolmen.candyshop.domain;


import org.junit.Test;

import com.realdolmen.candyshop.AbstractPersistenceTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OrderPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void orderCanBePersisted() throws Exception {
        Order o = new Order();
        o.setDeliveryAddress(new Address("Kattenberg", "7", "Huizingen", "2574"));
        em.persist(o);
        assertNotNull(o.getId());
    }

    @Test
    public void orderCanBeLoaded() throws Exception {
        Order order = em.find(Order.class, 2000L);
        assertEquals("Manhattan 13 1078 Geel", order.getDeliveryAddress().toString());
    }

    @Test
    public void orderCanHavePerson() throws Exception {
        Person p = em.find(Person.class, 3000L);
        Order o = new Order();
        o.setPerson(p);
        em.persist(o);
        em.flush();
        em.clear();

        Order po = em.find(Order.class, o.getId());
        assertEquals("Tyler", po.getPerson().getFirstName());
    }

    @Test
    public void orderHasOrderLines() throws Exception {
        Order o = em.find(Order.class, 1000L);
        List<OrderLine> orderLines = o.getOrderLines();
        assertEquals(3, orderLines.size());
    }

    @Test
    public void orderLinesFromOrderHaveCandy() throws Exception {
        Order o = em.find(Order.class, 3000L);
        OrderLine ol = o.getOrderLines().get(0);
        assertEquals("Sweethearts", ol.getCandy().getName());
    }

    @Test
    public void orderCanAddOrderLine() throws Exception {
        Order o = new Order();
        OrderLine ol = new OrderLine();
        ol.setQuantity(500);
        em.persist(ol);
        o.addOrderLine(ol);
        em.persist(o);
        em.flush();
        em.clear();

        Order po = em.find(Order.class, o.getId());
        assertEquals(1, po.getOrderLines().size());
        assertEquals(500, po.getOrderLines().get(0).getQuantity());
    }

    @Test
    public void orderCanCalculateTotalPrice() throws Exception {
        Order o = em.find(Order.class, 1000L);
        assertEquals(447.18, o.calculateTotal(), 0.01);
    }

    @Test
    public void orderCanHaveManyTypesOfCandy() throws Exception {
        Order o = em.find(Order.class, 2000L);
        assertEquals(2, o.getOrderLines().size());

        Candy c1 = o.getOrderLines().get(0).getCandy();
        assertTrue(c1 instanceof GummyBears);
        assertEquals("spicy", ((GummyBears)c1).getFlavour());

        Candy c2 = o.getOrderLines().get(1).getCandy();
        assertTrue(c2 instanceof ChocolateBar);
        assertEquals(100, ((ChocolateBar)c2).getLength());
    }
}
