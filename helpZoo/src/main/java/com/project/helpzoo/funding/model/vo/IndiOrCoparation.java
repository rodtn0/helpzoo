package com.project.helpzoo.funding.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INDI_OR_COPARTAION")

public class IndiOrCoparation {

	
	
	@Id
	@Column(name="INDI_OR_COPARTAION_ID")
	private long id;
	
	@Column(name="BUSINESS_TYPE")
	private String businessType;
	
	
	
	
}
