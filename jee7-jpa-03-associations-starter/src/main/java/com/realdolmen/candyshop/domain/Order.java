package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// TODO: make an entity using table "candy_order"
@Entity
@Table(name = "candy_order")
public class Order {
    // TODO: add id (primary key, generated) and deliveryAddress (embedded)
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private Address deliveryAddress;
	
    // TODO: Add a many to one association to Person. Make sure the bidirectional side is updated as well!
	@ManyToOne
	private Person person;
	
	// TODO: add a one to many association to OrderLine. Do not use a join-table (e.g. FK column "order_id" in "order_line")
	@OneToMany
	@JoinColumn(name = "order_id")
	private List <OrderLine> orderLines = new ArrayList<>();
	
	public Order() {
	}
	
    public double calculateTotal() {
        // TODO: implement this method
    	double total = 0;
    	for (OrderLine orderLine : orderLines){
    		total = total + orderLine.calculateSubTotal();
    	}
        return total;
    }

	public void setDeliveryAddress(Address address) {
		this.deliveryAddress = address;
		
	}

	public Long getId() {
		return id;
	}

	public Address getDeliveryAddress() {
		// TODO Auto-generated method stub
		return deliveryAddress;
	}

	public void setPerson(Person p) {
		this.person = p;
		person.addOrderToHistory(this);	
	}

	public Person getPerson() {
		// TODO Auto-generated method stub
		return person;
	}

	public List<OrderLine> getOrderLines() {
		// TODO Auto-generated method stub
		return orderLines;
	}
	public void addOrderLine(OrderLine orderLine){
		orderLines.add(orderLine);
	}
}
