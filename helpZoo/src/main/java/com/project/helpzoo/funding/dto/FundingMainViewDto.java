package com.project.helpzoo.funding.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class FundingMainViewDto {
	
	private long fundingNo;
	
	private String fundingTitle;
	
	private String category;
	
	private String fundingSummary;
	
	private String fundingMaker;
	
	private int totalOrderAmount;
	
	private int reachAmount;
	
	private Timestamp fundingEndDate;

	private int achievementRate;
	
	
	
	
	
	
	
	
	
	


	public FundingMainViewDto(long fundingNo, String fundingTitle, String category, String fundingSummary,
			String fundingMaker, int totalOrderAmount, int reachAmount, Timestamp fundingEndDate, int achievementRate) {
		super();
		this.fundingNo = fundingNo;
		this.fundingTitle = fundingTitle;
		this.category = category;
		this.fundingSummary = fundingSummary;
		this.fundingMaker = fundingMaker;
		this.totalOrderAmount = totalOrderAmount;
		this.reachAmount = reachAmount;
		this.fundingEndDate = fundingEndDate;
		this.achievementRate = achievementRate;
	}



	public long getFundingNo() {
		return fundingNo;
	}



	public void setFundingNo(long fundingNo) {
		this.fundingNo = fundingNo;
	}



	public String getFundingSummary() {
		return fundingSummary;
	}



	public void setFundingSummary(String fundingSummary) {
		this.fundingSummary = fundingSummary;
	}



	public FundingMainViewDto(String fundingTitle, String category, String fundingMaker, int totalOrderAmount,
			int reachAmount, Timestamp fundingEndDate) {
		super();
		this.fundingTitle = fundingTitle;
		this.category = category;
		this.fundingMaker = fundingMaker;
		this.totalOrderAmount = totalOrderAmount;
		this.reachAmount = reachAmount;
		this.fundingEndDate = fundingEndDate;
	}

	
	
	public FundingMainViewDto(String fundingTitle, String category, String fundingSummary, String fundingMaker,
			int totalOrderAmount, int reachAmount, Timestamp fundingEndDate) {
		super();
		this.fundingTitle = fundingTitle;
		this.category = category;
		this.fundingSummary =fundingSummary;
		this.fundingMaker = fundingMaker;
		this.totalOrderAmount = totalOrderAmount;
		this.reachAmount = reachAmount;
		this.fundingEndDate = fundingEndDate;
	}



	
	
	public String getFundingStory() {
		return fundingSummary;
	}



	public void setFundingStory(String fundingSummary) {
		this.fundingSummary = fundingSummary;
	}



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

	public Timestamp getFundingEndDate() {
		return fundingEndDate;
	}

	public void setFundingEndDate(Timestamp fundingEndDate) {
		this.fundingEndDate = fundingEndDate;
	}

	
	
	
	



	@Override
	public String toString() {
		return "FundingMainViewDto [fundingTitle=" + fundingTitle + ", category=" + category + ", fundingSummary="
				+ fundingSummary + ", fundingMaker=" + fundingMaker + ", totalOrderAmount=" + totalOrderAmount
				+ ", reachAmount=" + reachAmount + ", fundingEndDate=" + fundingEndDate + ", achievementRate="
				+ achievementRate + "]";
	}



	public int getAchievementRate() {
		return achievementRate;
	}



	public void setAchievementRate(int achievementRate) {
		this.achievementRate = achievementRate;
	}



	public FundingMainViewDto(String fundingTitle, String category, String fundingSummary, String fundingMaker,
			int totalOrderAmount, int reachAmount, Timestamp fundingEndDate, int achievementRate) {
		super();
		this.fundingTitle = fundingTitle;
		this.category = category;
		this.fundingSummary = fundingSummary;
		this.fundingMaker = fundingMaker;
		this.totalOrderAmount = totalOrderAmount;
		this.reachAmount = reachAmount;
		this.fundingEndDate = fundingEndDate;
		this.achievementRate = achievementRate;
	}
	

	
	
	
}

