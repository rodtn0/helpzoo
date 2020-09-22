package com.project.helpzoo.model.vo;

public class Donation2 {
	private int dFileNo;
	private String dBoardTitle;
	private String dFilePath;
	private String dFileChangeName;
	
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

	@Override
	public String toString() {
		return "Donation2 [dFileNo=" + dFileNo + ", dBoardTitle=" + dBoardTitle + ", dFilePath=" + dFilePath
				+ ", dFileChangeName=" + dFileChangeName + "]";
	}
	
	
	
	
}
