package com.project.helpzoo.funding.dto.viewDetail;

import java.sql.Timestamp;

public class FundingDetailRewardView {

	
	private int price;

	private String title;
	
	private int deleveryPrice;
	
	private int rewardAmount;
	
	private int rewardOriginAmount;
	
	private Timestamp deliveryDay;

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

	public int getRewardOriginAmount() {
		return rewardOriginAmount;
	}

	public void setRewardOriginAmount(int rewardOriginAmount) {
		this.rewardOriginAmount = rewardOriginAmount;
	}

	public Timestamp getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(Timestamp deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public FundingDetailRewardView(int price, String title, int deleveryPrice, int rewardAmount, int rewardOriginAmount,
			Timestamp deliveryDay) {
		super();
		this.price = price;
		this.title = title;
		this.deleveryPrice = deleveryPrice;
		this.rewardAmount = rewardAmount;
		this.rewardOriginAmount = rewardOriginAmount;
		this.deliveryDay = deliveryDay;
	}

	@Override
	public String toString() {
		return "FundingDetailRewardView [price=" + price + ", title=" + title + ", deleveryPrice=" + deleveryPrice
				+ ", rewardAmount=" + rewardAmount + ", rewardOriginAmount=" + rewardOriginAmount + ", deliveryDay="
				+ deliveryDay + "]";
	}

	
	
	
	
	
	
	
	
	
}
