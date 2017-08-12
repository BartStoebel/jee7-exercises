package com.realdolmen.candyshop.domain;

import javax.persistence.*;

// TODO: make entity with table "oder_line"
@Entity
@Table(name = "order_line")
public class OrderLine {
    // TODO: add id (pk, generated) and quantity (int) properties
	@Id 
	@GeneratedValue
	private Long id;
	
	private int quantity;
    // TODO: add a many to one association to candy
	@ManyToOne
	private Candy candy;

    public OrderLine() {
	}

	public double calculateSubTotal() {
        // TODO: implement this method
        return quantity * candy.getPrice();
    }

	public Candy getCandy() {
		// TODO Auto-generated method stub
		return candy;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCandy(Candy candy) {
		this.candy = candy;
	}

	public Long getId() {
		return id;
	}


	
}
