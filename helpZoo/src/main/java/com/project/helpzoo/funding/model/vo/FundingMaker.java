package com.project.helpzoo.funding.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FUNDING_MAKER")
public class FundingMaker {
	
	@Id
	@Column(name="FUNDING_MAKER_ID")
	private long id;
	
	@Column(name="FUNDING_MAKER_NAME")
	private String name;
	
	
	
	
	
	
	
	
	

}
