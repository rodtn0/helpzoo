package com.project.helpzoo.model.vo;

import java.sql.Date;

public class Donation {
	private int dBoardNo;
	private String dBoardPlan;
	private String dBoardTitle;
	private String dBoardQuestion1;
	private String dBoardQuestion2;
	private String dBoardQuestion3;
	private String dBoardQuestion4;
	private String dBoardQuestion5;
	private int dBoardTargetAmount;
	private int dBoardCurrentAmount;
	private int dBoardReadCount;
	private Date dBoardCrateDate;
	private Date dBoardModifyDate;
	private Date dBoardEndDate;
	private Date dBoardStartDate;
	private int dBoardLikeButton;
	private String dBoardStatus;
	private int organizationNo;
	private int dBoardWriter;
	private int dBoardCategory;
	private int dBoardType;
	
	// attachment 파일 패스 추가
	private String dfilePath;
	private String dfileChangeName;
	private int dParentBoardNo;
	private int memberNo;
	
	// DONATION_INFO 테이블 컬럼값 추가
	private int infoDonationNo;
	private int infoDonationCurrentAmount;
	
	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Donation(int dBoardNo, String dBoardPlan, String dBoardTitle, String dBoardQuestion1, String dBoardQuestion2,
			String dBoardQuestion3, String dBoardQuestion4, String dBoardQuestion5, int dBoardTargetAmount,
			int dBoardCurrentAmount, int dBoardReadCount, Date dBoardCrateDate, Date dBoardModifyDate,
			Date dBoardEndDate, Date dBoardStartDate, int dBoardLikeButton, String dBoardStatus, int organizationNo,
			int dBoardWriter, int dBoardCategory, int dBoardType, String dfilePath, String dfileChangeName,
			int dParentBoardNo, int memberNo, int infoDonationNo, int infoDonationCurrentAmount) {
		super();
		this.dBoardNo = dBoardNo;
		this.dBoardPlan = dBoardPlan;
		this.dBoardTitle = dBoardTitle;
		this.dBoardQuestion1 = dBoardQuestion1;
		this.dBoardQuestion2 = dBoardQuestion2;
		this.dBoardQuestion3 = dBoardQuestion3;
		this.dBoardQuestion4 = dBoardQuestion4;
		this.dBoardQuestion5 = dBoardQuestion5;
		this.dBoardTargetAmount = dBoardTargetAmount;
		this.dBoardCurrentAmount = dBoardCurrentAmount;
		this.dBoardReadCount = dBoardReadCount;
		this.dBoardCrateDate = dBoardCrateDate;
		this.dBoardModifyDate = dBoardModifyDate;
		this.dBoardEndDate = dBoardEndDate;
		this.dBoardStartDate = dBoardStartDate;
		this.dBoardLikeButton = dBoardLikeButton;
		this.dBoardStatus = dBoardStatus;
		this.organizationNo = organizationNo;
		this.dBoardWriter = dBoardWriter;
		this.dBoardCategory = dBoardCategory;
		this.dBoardType = dBoardType;
		this.dfilePath = dfilePath;
		this.dfileChangeName = dfileChangeName;
		this.dParentBoardNo = dParentBoardNo;
		this.memberNo = memberNo;
		this.infoDonationNo = infoDonationNo;
		this.infoDonationCurrentAmount = infoDonationCurrentAmount;
	}



	public int getdBoardNo() {
		return dBoardNo;
	}

	public void setdBoardNo(int dBoardNo) {
		this.dBoardNo = dBoardNo;
	}

	public String getdBoardPlan() {
		return dBoardPlan;
	}

	public void setdBoardPlan(String dBoardPlan) {
		this.dBoardPlan = dBoardPlan;
	}

	public String getdBoardTitle() {
		return dBoardTitle;
	}

	public void setdBoardTitle(String dBoardTitle) {
		this.dBoardTitle = dBoardTitle;
	}

	public String getdBoardQuestion1() {
		return dBoardQuestion1;
	}

	public void setdBoardQuestion1(String dBoardQuestion1) {
		this.dBoardQuestion1 = dBoardQuestion1;
	}

	public String getdBoardQuestion2() {
		return dBoardQuestion2;
	}

	public void setdBoardQuestion2(String dBoardQuestion2) {
		this.dBoardQuestion2 = dBoardQuestion2;
	}

	public String getdBoardQuestion3() {
		return dBoardQuestion3;
	}

	public void setdBoardQuestion3(String dBoardQuestion3) {
		this.dBoardQuestion3 = dBoardQuestion3;
	}

	public String getdBoardQuestion4() {
		return dBoardQuestion4;
	}

	public void setdBoardQuestion4(String dBoardQuestion4) {
		this.dBoardQuestion4 = dBoardQuestion4;
	}

	public String getdBoardQuestion5() {
		return dBoardQuestion5;
	}

	public void setdBoardQuestion5(String dBoardQuestion5) {
		this.dBoardQuestion5 = dBoardQuestion5;
	}

	public int getdBoardTargetAmount() {
		return dBoardTargetAmount;
	}

	public void setdBoardTargetAmount(int dBoardTargetAmount) {
		this.dBoardTargetAmount = dBoardTargetAmount;
	}

	public int getdBoardCurrentAmount() {
		return dBoardCurrentAmount;
	}

	public void setdBoardCurrentAmount(int dBoardCurrentAmount) {
		this.dBoardCurrentAmount = dBoardCurrentAmount;
	}

	public int getdBoardReadCount() {
		return dBoardReadCount;
	}

	public void setdBoardReadCount(int dBoardReadCount) {
		this.dBoardReadCount = dBoardReadCount;
	}

	public Date getdBoardCrateDate() {
		return dBoardCrateDate;
	}

	public void setdBoardCrateDate(Date dBoardCrateDate) {
		this.dBoardCrateDate = dBoardCrateDate;
	}

	public Date getdBoardModifyDate() {
		return dBoardModifyDate;
	}

	public void setdBoardModifyDate(Date dBoardModifyDate) {
		this.dBoardModifyDate = dBoardModifyDate;
	}

	public Date getdBoardEndDate() {
		return dBoardEndDate;
	}

	public void setdBoardEndDate(Date dBoardEndDate) {
		this.dBoardEndDate = dBoardEndDate;
	}

	public Date getdBoardStartDate() {
		return dBoardStartDate;
	}

	public void setdBoardStartDate(Date dBoardStartDate) {
		this.dBoardStartDate = dBoardStartDate;
	}

	public int getdBoardLikeButton() {
		return dBoardLikeButton;
	}

	public void setdBoardLikeButton(int dBoardLikeButton) {
		this.dBoardLikeButton = dBoardLikeButton;
	}

	public String getdBoardStatus() {
		return dBoardStatus;
	}

	public void setdBoardStatus(String dBoardStatus) {
		this.dBoardStatus = dBoardStatus;
	}

	public int getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(int organizationNo) {
		this.organizationNo = organizationNo;
	}

	public int getdBoardWriter() {
		return dBoardWriter;
	}

	public void setdBoardWriter(int dBoardWriter) {
		this.dBoardWriter = dBoardWriter;
	}

	public int getdBoardCategory() {
		return dBoardCategory;
	}

	public void setdBoardCategory(int dBoardCategory) {
		this.dBoardCategory = dBoardCategory;
	}

	public int getdBoardType() {
		return dBoardType;
	}

	public void setdBoardType(int dBoardType) {
		this.dBoardType = dBoardType;
	}

	public String getDfilePath() {
		return dfilePath;
	}

	public void setDfilePath(String dfilePath) {
		this.dfilePath = dfilePath;
	}

	public String getDfileChangeName() {
		return dfileChangeName;
	}

	public void setDfileChangeName(String dfileChangeName) {
		this.dfileChangeName = dfileChangeName;
	}

	public int getdParentBoardNo() {
		return dParentBoardNo;
	}

	public void setdParentBoardNo(int dParentBoardNo) {
		this.dParentBoardNo = dParentBoardNo;
	}
	
	

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getInfoDonationNo() {
		return infoDonationNo;
	}

	public void setInfoDonationNo(int infoDonationNo) {
		this.infoDonationNo = infoDonationNo;
	}

	public int getInfoDonationCurrentAmount() {
		return infoDonationCurrentAmount;
	}

	public void setInfoDonationCurrentAmount(int infoDonationCurrentAmount) {
		this.infoDonationCurrentAmount = infoDonationCurrentAmount;
	}



	@Override
	public String toString() {
		return "Donation [dBoardNo=" + dBoardNo + ", dBoardPlan=" + dBoardPlan + ", dBoardTitle=" + dBoardTitle
				+ ", dBoardQuestion1=" + dBoardQuestion1 + ", dBoardQuestion2=" + dBoardQuestion2 + ", dBoardQuestion3="
				+ dBoardQuestion3 + ", dBoardQuestion4=" + dBoardQuestion4 + ", dBoardQuestion5=" + dBoardQuestion5
				+ ", dBoardTargetAmount=" + dBoardTargetAmount + ", dBoardCurrentAmount=" + dBoardCurrentAmount
				+ ", dBoardReadCount=" + dBoardReadCount + ", dBoardCrateDate=" + dBoardCrateDate
				+ ", dBoardModifyDate=" + dBoardModifyDate + ", dBoardEndDate=" + dBoardEndDate + ", dBoardStartDate="
				+ dBoardStartDate + ", dBoardLikeButton=" + dBoardLikeButton + ", dBoardStatus=" + dBoardStatus
				+ ", organizationNo=" + organizationNo + ", dBoardWriter=" + dBoardWriter + ", dBoardCategory="
				+ dBoardCategory + ", dBoardType=" + dBoardType + ", dfilePath=" + dfilePath + ", dfileChangeName="
				+ dfileChangeName + ", dParentBoardNo=" + dParentBoardNo + ", memberNo=" + memberNo
				+ ", infoDonationNo=" + infoDonationNo + ", infoDonationCurrentAmount=" + infoDonationCurrentAmount
				+ "]";
	}
	
	
}
