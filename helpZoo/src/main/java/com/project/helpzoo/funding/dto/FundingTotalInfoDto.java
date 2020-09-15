package com.project.helpzoo.funding.dto;

import java.util.List;

public class FundingTotalInfoDto {
	
	
	private FundingOpenInfoView fundingOpenInfoView;
	
	private FundingOpenMakerInfoView fundingOpenMakerInfoView;
	
	private FundingOpenRequireView fundingOpenRequireView;
	
	private List<FundingOpenRewardView> fundingOpenRewardView;
	
	private FundingOpenStoryView fundingOpenStoryView;

	
	
	
	
	
	
	
	
	
	public FundingTotalInfoDto () {
		
	}
	
	
	
	
	
	public FundingTotalInfoDto(FundingOpenInfoView fundingOpenInfoView,
			FundingOpenMakerInfoView fundingOpenMakerInfoView, FundingOpenRequireView fundingOpenRequireView,
			List<FundingOpenRewardView> fundingOpenRewardView, FundingOpenStoryView fundingOpenStoryView) {
		super();
		this.fundingOpenInfoView = fundingOpenInfoView;
		this.fundingOpenMakerInfoView = fundingOpenMakerInfoView;
		this.fundingOpenRequireView = fundingOpenRequireView;
		this.fundingOpenRewardView = fundingOpenRewardView;
		this.fundingOpenStoryView = fundingOpenStoryView;
	}





	public FundingOpenInfoView getFundingOpenInfoView() {
		return fundingOpenInfoView;
	}

	public void setFundingOpenInfoView(FundingOpenInfoView fundingOpenInfoView) {
		this.fundingOpenInfoView = fundingOpenInfoView;
	}

	public FundingOpenMakerInfoView getFundingOpenMakerInfoView() {
		return fundingOpenMakerInfoView;
	}

	public void setFundingOpenMakerInfoView(FundingOpenMakerInfoView fundingOpenMakerInfoView) {
		this.fundingOpenMakerInfoView = fundingOpenMakerInfoView;
	}

	public FundingOpenRequireView getFundingOpenRequireView() {
		return fundingOpenRequireView;
	}

	public void setFundingOpenRequireView(FundingOpenRequireView fundingOpenRequireView) {
		this.fundingOpenRequireView = fundingOpenRequireView;
	}

	public List<FundingOpenRewardView> getFundingOpenRewardView() {
		return fundingOpenRewardView;
	}

	public void setFundingOpenRewardView(List<FundingOpenRewardView> fundingOpenRewardView) {
		this.fundingOpenRewardView = fundingOpenRewardView;
	}

	public FundingOpenStoryView getFundingOpenStoryView() {
		return fundingOpenStoryView;
	}

	public void setFundingOpenStoryView(FundingOpenStoryView fundingOpenStoryView) {
		this.fundingOpenStoryView = fundingOpenStoryView;
	}

	@Override
	public String toString() {
		return "FundingTotalInfoDto [fundingOpenInfoView=" + fundingOpenInfoView + ", fundingOpenMakerInfoView="
				+ fundingOpenMakerInfoView + ", fundingOpenRequireView=" + fundingOpenRequireView
				+ ", fundingOpenRewardView=" + fundingOpenRewardView + ", fundingOpenStoryView=" + fundingOpenStoryView
				+ "]";
	}
	
	
	
	
	
	
	
	
}
