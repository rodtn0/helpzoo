package com.project.helpzoo.funding.model.vo.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.project.helpzoo.funding.exception.NotEnoughStockException;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;


@Entity
@Table(name ="reward")
@SequenceGenerator(
		name = "REWARD_SEQ_GENERATOR",
		sequenceName = "REWARD_SEQ",
		initialValue = 1, allocationSize = 1)
public class Reward {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "FUNDING_PROJECT_SEQ_GENERATOR")
	@Column(name="REWARD_ID")
	private Long id;
	
	@Column(name="FUNDING_REWARD_SEQ")
	private Long rewardSeq;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FUNDING_ID")
	private FundingProject fundingProject;
	
	
	
	@Column(name="REWARD_CONTENT")
	private String content;
	
	@Column(name="REWARD_TITLE")
	private String title;
	
	@Column(name="REWARD_PRICE")
	private int price;
	
	@Column(name="REWARD_AMOUNT")
	private int amount;

	
	
	public void addStock(int amount) {
		this.amount += amount;
	}
	
	
	
	
	public void removeStock(int count) {
		
		int restAmount = this.amount - count;
		if(restAmount < 0) {
			throw new NotEnoughStockException("재고가 부족합니다.");
			
		}
		this.amount = restAmount;
		
		
	}
	
	
	
	
	
	
	
	
	
}
