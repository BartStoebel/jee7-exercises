package com.realdolmen.candyshop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// TODO: make a sublcass entity of candy, add discriminators
@Entity
@DiscriminatorValue("m&m")
public class MnM extends Candy {
    // TODO: add property nuts (boolean)
	private boolean nuts;

	public boolean isNuts() {
		return nuts;
	}

	public void setNuts(boolean nuts) {
		this.nuts = nuts;
	}

	public MnM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
