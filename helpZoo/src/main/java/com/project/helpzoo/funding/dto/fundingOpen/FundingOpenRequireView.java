package com.project.helpzoo.funding.dto.fundingOpen;


public class FundingOpenRequireView {
	
		
	private String rewardMakePlan;
	
	private String rewardDeliveryPlan;

	
	
	public FundingOpenRequireView() {
		
	}
	
	
	
	
public String isSatisfied() {
		
		
	Boolean rewardMakePlanEmpty = rewardMakePlan.trim().isEmpty();
	
	Boolean rewardDeliveryplanEmpty = rewardDeliveryPlan.trim().isEmpty();
	
	
		
		
		
		
	if	(rewardMakePlanEmpty&&rewardDeliveryplanEmpty) {
		return "작성 전";
	}
	
	else if (rewardMakePlanEmpty||rewardDeliveryplanEmpty){
		return "작성 중";
	}else {
		return "작성 완료";
	}
	
	
	
		
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
