package com.project.helpzoo.model.vo;

import java.sql.Timestamp;

public class DReply {

	private int dReplyNo;
	private String dReplyContent;
	private int dReplyReadCount;
	private int dReplyWriter;
	private Timestamp dReplyCreateDate;
	private Timestamp dReplyModifyDate;
	private String dReplyStatus;
	private int dBoardNo;
	
	public DReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DReply(int dReplyNo, String dReplyContent, int dReplyReadCount, int dReplyWriter, Timestamp dReplyCreateDate,
			Timestamp dReplyModifyDate, String dReplyStatus, int dBoardNo) {
		super();
		this.dReplyNo = dReplyNo;
		this.dReplyContent = dReplyContent;
		this.dReplyReadCount = dReplyReadCount;
		this.dReplyWriter = dReplyWriter;
		this.dReplyCreateDate = dReplyCreateDate;
		this.dReplyModifyDate = dReplyModifyDate;
		this.dReplyStatus = dReplyStatus;
		this.dBoardNo = dBoardNo;
	}
	public int getdReplyNo() {
		return dReplyNo;
	}
	public void setdReplyNo(int dReplyNo) {
		this.dReplyNo = dReplyNo;
	}
	public String getdReplyContent() {
		return dReplyContent;
	}
	public void setdReplyContent(String dReplyContent) {
		this.dReplyContent = dReplyContent;
	}
	public int getdReplyReadCount() {
		return dReplyReadCount;
	}
	public void setdReplyReadCount(int dReplyReadCount) {
		this.dReplyReadCount = dReplyReadCount;
	}
	public int getdReplyWriter() {
		return dReplyWriter;
	}
	public void setdReplyWriter(int dReplyWriter) {
		this.dReplyWriter = dReplyWriter;
	}
	public Timestamp getdReplyCreateDate() {
		return dReplyCreateDate;
	}
	public void setdReplyCreateDate(Timestamp dReplyCreateDate) {
		this.dReplyCreateDate = dReplyCreateDate;
	}
	public Timestamp getdReplyModifyDate() {
		return dReplyModifyDate;
	}
	public void setdReplyModifyDate(Timestamp dReplyModifyDate) {
		this.dReplyModifyDate = dReplyModifyDate;
	}
	public String getdReplyStatus() {
		return dReplyStatus;
	}
	public void setdReplyStatus(String dReplyStatus) {
		this.dReplyStatus = dReplyStatus;
	}
	public int getdBoardNo() {
		return dBoardNo;
	}
	public void setdBoardNo(int dBoardNo) {
		this.dBoardNo = dBoardNo;
	}
	@Override
	public String toString() {
		return "dReply [dReplyNo=" + dReplyNo + ", dReplyContent=" + dReplyContent + ", dReplyReadCount="
				+ dReplyReadCount + ", dReplyWriter=" + dReplyWriter + ", dReplyCreateDate=" + dReplyCreateDate
				+ ", dReplyModifyDate=" + dReplyModifyDate + ", dReplyStatus=" + dReplyStatus + ", dBoardNo="
				+ dBoardNo + "]";
	}
	






}
