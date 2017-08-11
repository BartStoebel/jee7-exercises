package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.DateUtils;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    // TODO: make non nullable and restrict to 200 characters
    @Column(nullable = false, length = 200)
    private String firstName;

    // TODO: make non nullable and restrict to 200 characters
    @Column(nullable = false, length = 200)
    private String lastName;

    // TODO: add property birthdate (store only date portion) make it non nullable
    @Column (nullable = false)
    @Temporal (TemporalType.DATE)
    private Date birthDate;
    // TODO: add property age (not stored in database, but calculated from birthdate
    @Transient
    private long age;
    // TODO: add embedded mapping to address
    @Embedded
    private Address address;

    // TODO: add element collection (table name "candy_preferences", columns ("candy_color" and "person_id")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "candy_preferences")
    @Column(name = "candy_color")
    @Enumerated(EnumType.STRING)
    private List<CandyColor> candyPreferences = new ArrayList<>();
    
    
    
    public Person() {
		
	}

	@PostLoad
    public void initializeAge() {
        this.age = DateUtils.yearsFrom(birthDate);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public Date getBirthDate() {
		// TODO Auto-generated method stub
		return birthDate;
	}

	public long getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	public List<CandyColor> getCandyPreferences() {
		// TODO Auto-generated method stub
		return candyPreferences;
	}

	public Address getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
    
}
