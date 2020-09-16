package com.project.helpzoo.funding.model.vo.funding;

import java.sql.Timestamp;

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
	private int rewardSeq;
	
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

	
	@Column(name = "REWARD_OPTION")
	private String option;
	
	
	@Column(name = "DELIVERY_PRICE")
	private int deliveryPrice;
	
	@Column(name = "DELIVERY_STARTDAY")
	private Timestamp deliveryDay;
	
	
	
	
	
	
	
	
	
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

	
	
	
	
	
	
	
	
	
	
	
	
	



	public String getOption() {
		return option;
	}




	public void setOption(String option) {
		this.option = option;
	}




	public int getDeliveryPrice() {
		return deliveryPrice;
	}




	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}




	public Timestamp getDeliveryDay() {
		return deliveryDay;
	}




	public void setDeliveryDay(Timestamp deliveryDay) {
		this.deliveryDay = deliveryDay;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public int getRewardSeq() {
		return rewardSeq;
	}




	public void setRewardSeq(int rewardSeq) {
		this.rewardSeq = rewardSeq;
	}




	public FundingProject getFundingProject() {
		return fundingProject;
	}




	public void setFundingProject(FundingProject fundingProject) {
		this.fundingProject = fundingProject;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}




	@Override
	public String toString() {
		return "Reward [id=" + id + ", rewardSeq=" + rewardSeq + ", fundingProject=" + fundingProject + ", content="
				+ content + ", title=" + title + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
	
	
}