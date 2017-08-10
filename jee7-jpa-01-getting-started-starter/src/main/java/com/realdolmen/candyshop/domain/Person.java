package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.util.Date;

// TODO: Make person a JPA entity
public class Person {
	@Id @GeneratedValue
	private Long id;
	private String lastName;
    private String firstName;
    
    public Person(){
    	
    }    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
    
}
