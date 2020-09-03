package com.project.helpzoo.funding.model.vo;

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
	
	

}
