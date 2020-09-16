package com.project.helpzoo.funding.dto;

import java.sql.Timestamp;

public class FundingOpenRewardView {
	
	private int price;

	private String title;
	
	private String content;
	
	private String option;
	
	private int deleveryPrice;
	
	private int rewardAmount;
	
	private Timestamp deliveryDay;

	
	
	
	
	
	
	
	
	
	public FundingOpenRewardView () {
		
	}
	
	
	
	
	
	public FundingOpenRewardView(int price, String title, String content, String option, int deleveryPrice,
			int rewardAmount, Timestamp deliveryDay) {
		super();
		this.price = price;
		this.title = title;
		this.content = content;
		this.option = option;
		this.deleveryPrice = deleveryPrice;
		this.rewardAmount = rewardAmount;
		this.deliveryDay = deliveryDay;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getDeleveryPrice() {
		return deleveryPrice;
	}

	public void setDeleveryPrice(int deleveryPrice) {
		this.deleveryPrice = deleveryPrice;
	}

	public int getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(int rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public Timestamp getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(Timestamp deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	@Override
	public String toString() {
		return "FundingOpenRewardView [price=" + price + ", title=" + title + ", content=" + content + ", option="
				+ option + ", deleveryPrice=" + deleveryPrice + ", rewardAmount=" + rewardAmount + ", deliveryDay="
				+ deliveryDay + "]";
	}
	
	
	
	
	
	
}
