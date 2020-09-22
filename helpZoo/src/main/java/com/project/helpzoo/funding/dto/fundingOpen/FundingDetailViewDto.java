package com.project.helpzoo.funding.dto.fundingOpen;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FundingDetailViewDto {

	
	private String fundingStroy;
	
	private String fundingTitle;
	
	private Long fundingRewardSeq;
	
	private String rewardContent;
	
	private String rewardTitle;
	
	private int rewardPrice;
	
	private int rewardAmount;
	
	private int goalAmount;
	
	private int totalOrderAmount;
	
	private int achievementRate;
	
	private List<String> suppoterName = new ArrayList<String>();
	
	private String makerName;
	
	private String snsUrl;
	
	private String kakaoUrl;

	private int like;
	
	private Timestamp endDay;
	
	private Timestamp startDay;
	
	private String category;
	
	
	
	
	
	
	public int getGoalAmount() {
		return goalAmount;
	}



	public void setGoalAmount(int goalAmount) {
		this.goalAmount = goalAmount;
	}



	public FundingDetailViewDto(String fundingStroy, int goalAmount, int totalOrderAmount, int achievementRate,
			List<String> suppoterName, String makerName, String snsUrl, String kakaoUrl, int like, Timestamp endDay,
			Timestamp startDay, String fundingTitle,String category) {
		super();
		this.fundingStroy = fundingStroy;
		this.goalAmount = goalAmount;
		this.totalOrderAmount = totalOrderAmount;
		this.achievementRate = achievementRate;
		this.suppoterName = suppoterName;
		this.makerName = makerName;
		this.snsUrl = snsUrl;
		this.kakaoUrl = kakaoUrl;
		this.like = like;
		this.endDay = endDay;
		this.startDay = startDay;
		this.fundingTitle = fundingTitle;
		this.category = category;
	}



	public String getCategory() {
		return category;
	}



	public void setCategoryId(String category) {
		this.category = category;
	}



	public String getFundingTitle() {
		return fundingTitle;
	}



	public void setFundingTitle(String fundingTitle) {
		this.fundingTitle = fundingTitle;
	}



	public FundingDetailViewDto(String fundingStroy, Long fundingRewardSeq, String rewardContent, String rewardTitle,
			int rewardPrice, int rewardAmount, int totalOrderAmount, int achievementRate,
			List<String> suppoterName, String makerName, String snsUrl, String kakaoUrl, int like, Timestamp endDay,
			Timestamp startDay) {
		super();
		this.fundingStroy = fundingStroy;
		this.fundingRewardSeq = fundingRewardSeq;
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
		this.like = like;
		this.endDay = endDay;
		this.startDay = startDay;
	}



	public Timestamp getStartDay() {
		return startDay;
	}



	public void setStartDay(Timestamp startDay) {
		this.startDay = startDay;
	}



	public FundingDetailViewDto(String fundingStroy, Long fundingRewardSeq, String rewardContent, String rewardTitle,
			int rewardPrice, int rewardAmount, int totalOrderAmount, int achievementRate,
			List<String> suppoterName, String makerName, String snsUrl, String kakaoUrl, int like, Timestamp endDay) {
		super();
		this.fundingStroy = fundingStroy;
		this.fundingRewardSeq = fundingRewardSeq;
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
		this.like = like;
		this.endDay = endDay;
	}



	public Timestamp getEndDay() {
		return endDay;
	}



	public void setEndDay(Timestamp endDay) {
		this.endDay = endDay;
	}



	public FundingDetailViewDto () {
		
	}



	public int getLike() {
		return like;
	}



	public void setLike(int like) {
		this.like = like;
	}



	public FundingDetailViewDto(String fundingStroy, Long fundingRewardSeq, String rewardContent, String rewardTitle,
			int rewardPrice, int rewardAmount, int totalOrderAmount, int achievementRate,
			List<String> suppoterName, String makerName, String snsUrl, String kakaoUrl, int like) {
		super();
		this.fundingStroy = fundingStroy;
		this.fundingRewardSeq = fundingRewardSeq;
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
		this.like = like;
	}



	public String getFundingStroy() {
		return fundingStroy;
	}



	public void setFundingStroy(String fundingStroy) {
		this.fundingStroy = fundingStroy;
	}



	public Long getFundingRewardSeq() {
		return fundingRewardSeq;
	}



	public void setFundingRewardSeq(Long fundingRewardSeq) {
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



	public List<String> getSuppoterName() {
		return suppoterName;
	}



	public void setSuppoterName(List<String> suppoterName) {
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



	public FundingDetailViewDto(String fundingStroy, Long integer, String rewardContent, String rewardTitle,
			int rewardPrice, int rewardAmount, int totalOrderAmount, int achievementRate,
			List<String> suppoterName, String makerName, String snsUrl, String kakaoUrl) {
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
