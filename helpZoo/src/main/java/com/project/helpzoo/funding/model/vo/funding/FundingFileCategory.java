package com.project.helpzoo.funding.model.vo.funding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FUNDING_FILE_CATEGORY")
@SequenceGenerator(
		name = "FD_FILE_CATEGORY_SEQ_GENERATOR",
		sequenceName = "FD_FILE_CATEGORY_SEQ",
		initialValue = 1, allocationSize = 1)
public class FundingFileCategory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "FD_FILE_CATEGORY_SEQ_GENERATOR")

	@Column(name="FUNDING_FILE_CATEGORY_ID")
	private Long id;
	
	@Column(name="FUNDING_TABLE_TYPE")
	private String type;
	
	
	
}
