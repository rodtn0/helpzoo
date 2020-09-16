package com.project.helpzoo.funding.dto;

public class FundingOpenStoryView {

	
	
	private String fundingSummary;
	
	private String fundingStory;

	
	
	
	
	
	
	
	
	
	
	public FundingOpenStoryView() {
		
	}
	
	public String isSatisfied() {
		
		
		Boolean fundingSummaryIsEmpty = fundingSummary.trim().isEmpty();
		Boolean fundingStoryIsEmpty = fundingStory.trim().isEmpty();
		
		
	if	(fundingStoryIsEmpty&&fundingSummaryIsEmpty	) {
		return "작성 전";
	}
	
	else if (fundingStoryIsEmpty||fundingSummaryIsEmpty){
		return "작성 중";
	}else {
		return "작성 완료";
	}
	
	
	
		
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
