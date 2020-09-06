package com.project.helpzoo.funding.model.vo.funding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INDI_OR_COPARATION")

public class IndiOrCoparation {

	
	
	@Id
	@Column(name="INDI_OR_COPARATION_ID")
	private long id;
	
	@Column(name="BUSINESS_TYPE")
	private String businessType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "IndiOrCoparation [id=" + id + ", businessType=" + businessType + "]";
	}

	public IndiOrCoparation(long id, String businessType) {
		super();
		this.id = id;
		this.businessType = businessType;
	}

	public IndiOrCoparation() {
		super();
	}
	
	
	
	
}
