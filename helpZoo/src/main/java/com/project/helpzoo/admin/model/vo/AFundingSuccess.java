package com.project.helpzoo.admin.model.vo;

public class AFundingSuccess {
	
	private int fundingSuccess;
	private int fundingFailure;
	private int fundingProgress;
	
	public AFundingSuccess() {
		// TODO Auto-generated constructor stub
	}

	public AFundingSuccess(int fundingSuccess, int fundingFailure, int fundingProgress) {
		super();
		this.fundingSuccess = fundingSuccess;
		this.fundingFailure = fundingFailure;
		this.fundingProgress = fundingProgress;
	}

	public int getFundingSuccess() {
		return fundingSuccess;
	}

	public void setFundingSuccess(int fundingSuccess) {
		this.fundingSuccess = fundingSuccess;
	}

	public int getFundingFailure() {
		return fundingFailure;
	}

	public void setFundingFailure(int fundingFailure) {
		this.fundingFailure = fundingFailure;
	}

	public int getFundingProgress() {
		return fundingProgress;
	}

	public void setFundingProgress(int fundingProgress) {
		this.fundingProgress = fundingProgress;
	}

	@Override
	public String toString() {
		return "AFundingSuccess [fundingSuccess=" + fundingSuccess + ", fundingFailure=" + fundingFailure
				+ ", fundingProgress=" + fundingProgress + "]";
	}
	

}
