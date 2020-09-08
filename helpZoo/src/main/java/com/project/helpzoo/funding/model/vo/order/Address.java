package com.project.helpzoo.funding.model.vo.order;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String city;
	private String street;
	private String zipcode;
	
	protected Address() {
		
	}

	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
	
	
	
}
