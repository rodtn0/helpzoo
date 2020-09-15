package com.project.helpzoo.funding.dto;

public class FundingOpenStoryView {

	
	
	private String fundingSummary;
	
	private String fundingStory;

	
	
	
	
	
	
	
	
	
	
	public FundingOpenStoryView() {
		
	}
	
	
	
	public FundingOpenStoryView(String fundingSummary, String fundingStory) {
		super();
		this.fundingSummary = fundingSummary;
		this.fundingStory = fundingStory;
	}

	public String getFundingSummary() {
		return fundingSummary;
	}

	public void setFundingSummary(String fundingSummary) {
		this.fundingSummary = fundingSummary;
	}

	public String getFundingStory() {
		return fundingStory;
	}

	public void setFundingStory(String fundingStory) {
		this.fundingStory = fundingStory;
	}

	@Override
	public String toString() {
		return "FundingOpenStoryView [fundingSummary=" + fundingSummary + ", fundingStory=" + fundingStory + "]";
	}
	
	
	
	
	
}
