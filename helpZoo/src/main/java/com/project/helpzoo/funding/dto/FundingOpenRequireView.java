package com.project.helpzoo.funding.dto;


public class FundingOpenRequireView {
	
		
	private String rewardMakePlan;
	
	private String rewardDeliveryPlan;

	
	
	public FundingOpenRequireView() {
		
	}
	
	
	
	
	
	
	
	
	
	
	











	public String getRewardMakePlan() {
		return rewardMakePlan;
	}

	public void setRewardMakePlan(String rewardMakePlan) {
		this.rewardMakePlan = rewardMakePlan;
	}

	public String getRewardDeliveryPlan() {
		return rewardDeliveryPlan;
	}

	public void setRewardDeliveryPlan(String rewardDeliveryPlan) {
		this.rewardDeliveryPlan = rewardDeliveryPlan;
	}

	@Override
	public String toString() {
		return "fundingOpenRequireView [rewardMakePlan=" + rewardMakePlan + ", rewardDeliveryPlan=" + rewardDeliveryPlan
				+ "]";
	}

	public FundingOpenRequireView(String rewardMakePlan, String rewardDeliveryPlan) {
		super();
		this.rewardMakePlan = rewardMakePlan;
		this.rewardDeliveryPlan = rewardDeliveryPlan;
	}
	
	
	
	
	
}
