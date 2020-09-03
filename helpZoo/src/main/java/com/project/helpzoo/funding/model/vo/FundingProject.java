package com.project.helpzoo.funding.model.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@SequenceGenerator(
		name = "FUNDING_PROJECT_SEQ_GENERATOR",
		sequenceName = "FUNDING_PROJECT_SEQ",
		initialValue = 1, allocationSize = 1)


@Entity
@Table(name="FUNDING_PROJECT")
public class FundingProject {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "FUNDING_PROJECT_SEQ_GENERATOR")
	@Column(name="FUNDING_ID")
	private long id;
	
	@Column(name="FUNDING_TITLE")
	private String title;
	
	@Column(name="FUNDING_PLAN")
	private String plan;
	
	@Column(name="FUNDING_GOAL")
	private int goalAmount;
	
	@Column(name="MANAGER_NAME")
	private String managerName;
	
	@Column(name="MANAGER_EMAIL")
	private String managerEmail;
	
	@Column(name="FUNDING_END_DAY")
	private Date endDay;
	
	@Column(name="FUNDING_SEARCH_TAG")
	private String tag;
	
	@Column(name="FUNDING_SUMMARY")
	private String summary;
	
	@Column(name="FUNDING_STORY")
	private String stroy;
	
	@Column(name="FUNDING_START_DAY")
	private String startDay;
	
	@Column(name="FUNDING_STATUS")
	private String status;
	
	@Column(name="MEMBER_NO")
	private int memberNo;
	
	
	@ManyToOne 
	@JoinColumn(name = "FUNDING_ID", insertable = false, updatable = false)
	private FundingCategory category;
	
	
	@ManyToOne 
	@JoinColumn(name = "FUNDING_ID", insertable = false, updatable = false)
	private IndiOrCoparation indiOrCoparation;
	
	
	
	@OneToOne
	@JoinColumn(name="FUNDING_MAKER_ID")
	private FundingMaker fundingMaker;
	
	
	
	
	
	
	
	
	
	
	
	
	

}
