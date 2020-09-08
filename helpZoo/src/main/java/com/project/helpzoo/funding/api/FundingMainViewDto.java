package com.project.helpzoo.funding.api;

import java.sql.Date;

public class FundingMainViewDto {
	
	private String fundingTitle;
	
	private String category;
	
	private String fundingMaker;
	
	private int totalOrderAmount;
	
	private int reachAmount;
	
	private Date fundingEndDate;

	public String getFundingTitle() {
		return fundingTitle;
	}

	public void setFundingTitle(String fundingTitle) {
		this.fundingTitle = fundingTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFundingMaker() {
		return fundingMaker;
	}

	public void setFundingMaker(String fundingMaker) {
		this.fundingMaker = fundingMaker;
	}

	public int getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(int totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public int getReachAmount() {
		return reachAmount;
	}

	public void setReachAmount(int reachAmount) {
		this.reachAmount = reachAmount;
	}

	public Date getFundingEndDate() {
		return fundingEndDate;
	}

	public void setFundingEndDate(Date fundingEndDate) {
		this.fundingEndDate = fundingEndDate;
	}

	@Override
	public String toString() {
		return "FundingMainViewDto [fundingTitle=" + fundingTitle + ", category=" + category + ", fundingMaker="
				+ fundingMaker + ", totalOrderAmount=" + totalOrderAmount + ", reachAmount=" + reachAmount
				+ ", fundingEndDate=" + fundingEndDate + "]";
	}
	

	
	
	
}

