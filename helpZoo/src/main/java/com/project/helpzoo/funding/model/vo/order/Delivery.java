package com.project.helpzoo.funding.model.vo.order;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DELIVERY")
@SequenceGenerator(
		name = "DELIVERY_SEQ_GENERATOR",
		sequenceName = "DELIVERY_SEQ",
		initialValue = 1, allocationSize = 1)
public class Delivery {

	
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DELIVERY_SEQ_GENERATOR")
	@Column(name = "DELIVERY_ID")
	private Long id;
	
	@Embedded
	private Address address;
	
	
	
	public Delivery() {
		
	}
	
	
	@Column(name = "DELIVERY_STATUS")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", order=" +  ", address=" + address + ", status=" + status + "]";
	}

	public Delivery(Address address, String status) {
		super();

		this.address = address;
		this.status = status;
	}


	
	
	
	
	
	
	
}
