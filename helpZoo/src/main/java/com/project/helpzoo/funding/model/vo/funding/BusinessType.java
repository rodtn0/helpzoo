package com.project.helpzoo.funding.model.vo.funding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BUSINESS_TYPE")

public class BusinessType {

	
	
	@Id
	@Column(name="BUSINESS_TYPE_ID")
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
		
		
		if(businessType == null) {
			businessType = "";
		}
		
		
		return businessType;
	}

	public void setBusinessType(String businessType) {
		
	
		
		
		this.businessType = businessType;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public String toString() {
		return "IndiOrCoparation [id=" + id + ", businessType=" + businessType + "]";
	}

	public BusinessType(long id, String businessType) {
		super();
		this.id = id;
		this.businessType = businessType;
	}

	public BusinessType() {
		super();
	}
	
	
	
	
}
