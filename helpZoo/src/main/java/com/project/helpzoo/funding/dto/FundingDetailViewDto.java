package com.project.helpzoo.funding.dto;

import java.util.Arrays;
import java.util.Optional;

public class FundingDetailViewDto {

	
	private String fundingStroy;
	
	private Integer fundingRewardSeq;
	
	private String rewardContent;
	
	private String rewardTitle;
	
	private int rewardPrice;
	
	private int rewardAmount;
	
	private int totalOrderAmount;
	
	private int achievementRate;
	
	Optional<String[]> suppoterName;
	
	private String makerName;
	
	private String snsUrl;
	
	private String kakaoUrl;

	
	
	public FundingDetailViewDto () {
		
	}



	public String getFundingStroy() {
		return fundingStroy;
	}



	public void setFundingStroy(String fundingStroy) {
		this.fundingStroy = fundingStroy;
	}



	public Integer getFundingRewardSeq() {
		return fundingRewardSeq;
	}



	public void setFundingRewardSeq(Integer fundingRewardSeq) {
		this.fundingRewardSeq = fundingRewardSeq;
	}



	public String getRewardContent() {
		return rewardContent;
	}



	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}



	public String getRewardTitle() {
		return rewardTitle;
	}



	public void setRewardTitle(String rewardTitle) {
		this.rewardTitle = rewardTitle;
	}



	public int getRewardPrice() {
		return rewardPrice;
	}



	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}



	public int getRewardAmount() {
		return rewardAmount;
	}



	public void setRewardAmount(int rewardAmount) {
		this.rewardAmount = rewardAmount;
	}



	public int getTotalOrderAmount() {
		return totalOrderAmount;
	}



	public void setTotalOrderAmount(int totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}



	public int getAchievementRate() {
		return achievementRate;
	}



	public void setAchievementRate(int achievementRate) {
		this.achievementRate = achievementRate;
	}



	public Optional<String[]> getSuppoterName() {
		return suppoterName;
	}



	public void setSuppoterName(Optional<String[]> suppoterName) {
		this.suppoterName = suppoterName;
	}



	public String getMakerName() {
		return makerName;
	}



	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}



	public String getSnsUrl() {
		return snsUrl;
	}



	public void setSnsUrl(String snsUrl) {
		this.snsUrl = snsUrl;
	}



	public String getKakaoUrl() {
		return kakaoUrl;
	}



	public void setKakaoUrl(String kakaoUrl) {
		this.kakaoUrl = kakaoUrl;
	}



	public FundingDetailViewDto(String fundingStroy, Integer integer, String rewardContent, String rewardTitle,
			int rewardPrice, int rewardAmount, int totalOrderAmount, int achievementRate,
			Optional<String[]> suppoterName, String makerName, String snsUrl, String kakaoUrl) {
		super();
		this.fundingStroy = fundingStroy;
		this.fundingRewardSeq = integer;
		this.rewardContent = rewardContent;
		this.rewardTitle = rewardTitle;
		this.rewardPrice = rewardPrice;
		this.rewardAmount = rewardAmount;
		this.totalOrderAmount = totalOrderAmount;
		this.achievementRate = achievementRate;
		this.suppoterName = suppoterName;
		this.makerName = makerName;
		this.snsUrl = snsUrl;
		this.kakaoUrl = kakaoUrl;
	}



	@Override
	public String toString() {
		return "FundingDetailViewDto [fundingStroy=" + fundingStroy + ", fundingRewardSeq=" + fundingRewardSeq
				+ ", rewardContent=" + rewardContent + ", rewardTitle=" + rewardTitle + ", rewardPrice=" + rewardPrice
				+ ", rewardAmount=" + rewardAmount + ", totalOrderAmount=" + totalOrderAmount + ", achievementRate="
				+ achievementRate + ", suppoterName=" + suppoterName + ", makerName=" + makerName + ", snsUrl=" + snsUrl
				+ ", kakaoUrl=" + kakaoUrl + "]";
	}
	
	
	
	
	
}
