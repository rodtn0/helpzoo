package com.project.helpzoo.funding.model.vo.funding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FUNDING_CATEGORY")
public class FundingCategory {
	
	@Id
	@Column(name="CATEGORY_ID")
	private long id;
	
	@Column(name="CATEGORY_NAME")
	private String category_name;

	
	
	
	public FundingCategory () {
		
	}
	
	
	
	
	
	
	
	
	public FundingCategory(long id) {
		super();
		this.id = id;
	}








	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory_name() {
		
		if(category_name == null) {
			category_name = "";
		}
		
		
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "FundingCategory [id=" + id + ", category_name=" + category_name + "]";
	}

	public FundingCategory(long id, String category_name) {
		super();
		this.id = id;
		this.category_name = category_name;
	}
	
	

}
