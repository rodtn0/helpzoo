package com.project.helpzoo.model.vo;

public class Donation2 {
	private int dFileNo;
	private int dBoardNo;
	private String dBoardTitle;
	private String dFilePath;
	private String dFileChangeName;
	
	private int dBoardCurrentAmount; // 현재 금액
	private int dBoardTargetAmount; // 목표 금액
	private int achivement; // 달성률
	
	public Donation2() {
	}

	
	public Donation2(int dFileNo, String dBoardTitle, String dFilePath, String dFileChangeName) {
		super();
		this.dFileNo = dFileNo;
		this.dBoardTitle = dBoardTitle;
		this.dFilePath = dFilePath;
		this.dFileChangeName = dFileChangeName;
	}

	public Donation2(String dBoardTitle, String dFilePath, String dFileChangeName) {
		super();
		this.dBoardTitle = dBoardTitle;
		this.dFilePath = dFilePath;
		this.dFileChangeName = dFileChangeName;
	}

	
	public Donation2(String dBoardTitle, String dFilePath, String dFileChangeName, int dBoardCurrentAmount,
			int dBoardTargetAmount) {
		super();
		this.dBoardTitle = dBoardTitle;
		this.dFilePath = dFilePath;
		this.dFileChangeName = dFileChangeName;
		this.dBoardCurrentAmount = dBoardCurrentAmount;
		this.dBoardTargetAmount = dBoardTargetAmount;
	}
	
	

	public Donation2(String dBoardTitle, String dFilePath, String dFileChangeName, int dBoardCurrentAmount,
			int dBoardTargetAmount, int achivement) {
		super();
		this.dBoardTitle = dBoardTitle;
		this.dFilePath = dFilePath;
		this.dFileChangeName = dFileChangeName;
		this.dBoardCurrentAmount = dBoardCurrentAmount;
		this.dBoardTargetAmount = dBoardTargetAmount;
		this.achivement = achivement;
	}
	
	

	public Donation2(int dBoardNo, String dBoardTitle, String dFilePath, String dFileChangeName,
			int dBoardCurrentAmount, int dBoardTargetAmount, int achivement) {
		super();
		this.dBoardNo = dBoardNo;
		this.dBoardTitle = dBoardTitle;
		this.dFilePath = dFilePath;
		this.dFileChangeName = dFileChangeName;
		this.dBoardCurrentAmount = dBoardCurrentAmount;
		this.dBoardTargetAmount = dBoardTargetAmount;
		this.achivement = achivement;
	}


	public int getdFileNo() {
		return dFileNo;
	}

	public void setdFileNo(int dFileNo) {
		this.dFileNo = dFileNo;
	}

	public String getdBoardTitle() {
		return dBoardTitle;
	}

	public void setdBoardTitle(String dBoardTitle) {
		this.dBoardTitle = dBoardTitle;
	}

	public String getdFilePath() {
		return dFilePath;
	}

	public void setdFilePath(String dFilePath) {
		this.dFilePath = dFilePath;
	}

	public String getdFileChangeName() {
		return dFileChangeName;
	}

	public void setdFileChangeName(String dFileChangeName) {
		this.dFileChangeName = dFileChangeName;
	}
	
	

	public int getdBoardCurrentAmount() {
		return dBoardCurrentAmount;
	}

	public void setdBoardCurrentAmount(int dBoardCurrentAmount) {
		this.dBoardCurrentAmount = dBoardCurrentAmount;
	}

	public int getdBoardTargetAmount() {
		return dBoardTargetAmount;
	}

	public void setdBoardTargetAmount(int dBoardTargetAmount) {
		this.dBoardTargetAmount = dBoardTargetAmount;
	}
	
	

	public int getAchivement() {
		return achivement;
	}

	public void setAchivement(int achivement) {
		this.achivement = achivement;
	}
	
	

	public int getdBoardNo() {
		return dBoardNo;
	}


	public void setdBoardNo(int dBoardNo) {
		this.dBoardNo = dBoardNo;
	}


	@Override
	public String toString() {
		return "Donation2 [dFileNo=" + dFileNo + ", dBoardNo=" + dBoardNo + ", dBoardTitle=" + dBoardTitle
				+ ", dFilePath=" + dFilePath + ", dFileChangeName=" + dFileChangeName + ", dBoardCurrentAmount="
				+ dBoardCurrentAmount + ", dBoardTargetAmount=" + dBoardTargetAmount + ", achivement=" + achivement
				+ "]";
	}




	
	
	
	
	
}
