package com.project.helpzoo.funding.model.vo.order;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DELIVERY")
public class Delivery {

	
	
	
	@Id @GeneratedValue
	@Column(name = "delivery_id")
	private Long id;
	
	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Orders order;
	
	@Embedded
	private Address address;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	
}
