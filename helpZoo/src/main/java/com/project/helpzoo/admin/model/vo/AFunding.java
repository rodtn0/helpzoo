package com.project.helpzoo.admin.model.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.util.CollectionUtils;

public class AFunding {

	int fundingNo; // 펀딩 번호
	String fundingTitle; // 펀딩 제목
	String memberName; // 주최자 이름
	int likeCount; // 좋아요
	int readCount; // 조회수
	String fundingStatus; // 펀딩 상태
	int fundingGoal; // 펀딩 목표 금액
	Date fundingSD; // 펀딩 시작 날짜
	Date fundingED; // 펀딩 종료 날짜
	int currentAmount; // 현재금액
	int fees; // 수수료
	
	public AFunding() {
		// TODO Auto-generated constructor stub
	}

	public AFunding(int fundingNo, String fundingTitle, String memberName, int likeCount, int readCount,
			String fundingStatus, int fundingGoal, Date fundingSD, Date fundingED, int currentAmount, int fees) {
		super();
		this.fundingNo = fundingNo;
		this.fundingTitle = fundingTitle;
		this.memberName = memberName;
		this.likeCount = likeCount;
		this.readCount = readCount;
		this.fundingStatus = fundingStatus;
		this.fundingGoal = fundingGoal;
		this.fundingSD = fundingSD;
		this.fundingED = fundingED;
		this.currentAmount = currentAmount;
		this.fees = fees;
	}

	public int getFundingNo() {
		return fundingNo;
	}

	public void setFundingNo(int fundingNo) {
		this.fundingNo = fundingNo;
	}

	public String getFundingTitle() {
		return fundingTitle;
	}

	public void setFundingTitle(String fundingTitle) {
		this.fundingTitle = fundingTitle;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getFundingStatus() {
		return fundingStatus;
	}

	public void setFundingStatus(String fundingStatus) {
		this.fundingStatus = fundingStatus;
	}

	public int getFundingGoal() {
		return fundingGoal;
	}

	public void setFundingGoal(int fundingGoal) {
		this.fundingGoal = fundingGoal;
	}

	public Date getFundingSD() {
		return fundingSD;
	}

	public void setFundingSD(Date fundingSD) {
		this.fundingSD = fundingSD;
	}

	public Date getFundingED() {
		return fundingED;
	}

	public void setFundingED(Date fundingED) {
		this.fundingED = fundingED;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}


	@Override
	public String toString() {
		return "AFunding [fundingNo=" + fundingNo + ", fundingTitle=" + fundingTitle + ", memberName=" + memberName
				+ ", likeCount=" + likeCount + ", readCount=" + readCount + ", fundingStatus=" + fundingStatus
				+ ", fundingGoal=" + fundingGoal + ", fundingSD=" + fundingSD + ", fundingED=" + fundingED
				+ ", currentAmount=" + currentAmount + ", fees=" + fees + "]";
	}

	
}
