package com.project.helpzoo.funding.dto.fundingOpen;

import java.sql.Timestamp;

import com.project.helpzoo.funding.model.vo.funding.FundingAttachment;

public class FundingOpenInfoView {
	
	
	private String fundingTitle;
	
	private int fundingGoal;
	
	private Long category;
	
	private Timestamp fundingEndDay;
	
	private String fundingTag;

	private FundingAttachment IntroAttachment;
	
	
	
	
	
	
	public FundingAttachment getIntroAttachment() {
		return IntroAttachment;
	}



	public void setIntroAttachment(FundingAttachment introAttachment) {
		IntroAttachment = introAttachment;
	}



	public FundingOpenInfoView() {
		
	}
	
	
	
	public String getFundingTitle() {
		return fundingTitle;
	}

	public void setFundingTitle(String fundingTitle) {
		this.fundingTitle = fundingTitle;
	}

	public int getFundingGoal() {
		return fundingGoal;
	}

	public void setFundingGoal(int fundingGoal) {
		this.fundingGoal = fundingGoal;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Timestamp getFundingEndDay() {
		return fundingEndDay;
	}

	public void setFundingEndDay(Timestamp fundingEndDay) {
		this.fundingEndDay = fundingEndDay;
	}

	public String getFundingTag() {
		return fundingTag;
	}

	public void setFundingTag(String fundingTag) {
		this.fundingTag = fundingTag;
	}
	
	
	
	public String isSatisfied() {
		
		Boolean titleEmpty = fundingTitle.trim().isEmpty();
		Boolean fundingGoalIsEmpty = fundingGoal==0;
		Boolean fundingEndDayEmpty = fundingEndDay==null;
		Boolean tagIsEmpty = fundingTag.isEmpty();
		
		
		
		
		
	if	(titleEmpty&&fundingGoalIsEmpty&&fundingEndDayEmpty&&tagIsEmpty) {
		return "작성 전";
	}
	
	else if (!titleEmpty||fundingGoalIsEmpty||fundingEndDayEmpty||tagIsEmpty){
		return "작성 중";
	}else {
		return "작성 완료";
	}
	
	
	
		
	}
	
	
	

	public FundingOpenInfoView(String fundingTitle, int fundingGoal, Long category, Timestamp fundingEndDay,
			String fundingTag) {
		super();
		this.fundingTitle = fundingTitle;
		this.fundingGoal = fundingGoal;
		this.category = category;
		this.fundingEndDay = fundingEndDay;
		this.fundingTag = fundingTag;
	}

	@Override
	public String toString() {
		return "FundingOpenInfoView [fundingTitle=" + fundingTitle + ", fundingGoal=" + fundingGoal + ", category="
				+ category + ", fundingEndDay=" + fundingEndDay + ", fundingTag=" + fundingTag + "]";
	}
	
	
	
	
}
