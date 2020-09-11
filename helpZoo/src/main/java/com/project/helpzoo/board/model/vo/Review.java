package com.project.helpzoo.board.model.vo;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Review {
	private int reviewNo;
	private String reviewTitle;
	private String reviewContent;
	private int readCount;
	private Date reviewCreateDate;
	private Date reviewModifyDate;
	private char reviewStatus;
	private int projectNo;
	private int reviewType;
	private int reviewWriter;
	
	private String projectTitle;
	private String memberId;
	
	private String filePath;
	private String fileChangeName;
	
	
	public Review() {
	}

	

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getReviewCreateDate() {
		return reviewCreateDate;
	}

	public void setReviewCreateDate(Date reviewCreateDate) {
		this.reviewCreateDate = reviewCreateDate;
	}

	public Date getReviewModifyDate() {
		return reviewModifyDate;
	}

	public void setReviewModifyDate(Date reviewModifyDate) {
		this.reviewModifyDate = reviewModifyDate;
	}

	public char getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(char reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getReviewType() {
		return reviewType;
	}

	public void setReviewType(int reviewType) {
		this.reviewType = reviewType;
	}

	public int getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(int reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	


	public String getProjectTitle() {
		return projectTitle;
	}



	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	


	public String getFilePath() {
		return filePath;
	}



	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	


	public String getFileChangeName() {
		return fileChangeName;
	}



	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}



	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewNo", reviewNo);
		map.put("reviewTitle", reviewTitle);
		map.put("reviewContent", reviewContent);
		map.put("readCount", readCount);
		map.put("reviewCreateDate", reviewCreateDate);
		map.put("reviewModifyDate", reviewModifyDate);
		map.put("reviewStatus", reviewStatus);
		map.put("projectNo", projectNo);
		map.put("reviewType", reviewType);
		map.put("reviewWriter", reviewWriter);
		map.put("projectTitle", projectTitle);
		map.put("memberId", memberId);
		map.put("filePath", filePath);
		map.put("fileChangeName", fileChangeName);
		
		
		return gson.toJson(map);
	}



	

	
	
	
}
