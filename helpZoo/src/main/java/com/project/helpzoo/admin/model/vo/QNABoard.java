package com.project.helpzoo.admin.model.vo;

import java.sql.Timestamp;

public class QNABoard {

	private int qnaNo;
	private int originNo;
	private int groupOrd;
	private int groupLayer;
	private String qnaTitle;
	private String qnaContent;
	private int readCount;
	private Timestamp qnaCreateDate;
	private Timestamp qnaModifyDate;
	private String qnaWriter;
	private int qnaAnswer; // 답변 유무
	
	public QNABoard() {
		// TODO Auto-generated constructor stub
	}
	
	public QNABoard(int qnaNo, int originNo, int groupOrd, int groupLayer, String qnaTitle, String qnaContent,
			int readCount, Timestamp qnaCreateDate, Timestamp qnaModifyDate, String qnaWriter, int qnaAnswer) {
		super();
		this.qnaNo = qnaNo;
		this.originNo = originNo;
		this.groupOrd = groupOrd;
		this.groupLayer = groupLayer;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.readCount = readCount;
		this.qnaCreateDate = qnaCreateDate;
		this.qnaModifyDate = qnaModifyDate;
		this.qnaWriter = qnaWriter;
		this.qnaAnswer = qnaAnswer;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public int getOriginNo() {
		return originNo;
	}

	public void setOriginNo(int originNo) {
		this.originNo = originNo;
	}

	public int getGroupOrd() {
		return groupOrd;
	}

	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}

	public int getGroupLayer() {
		return groupLayer;
	}

	public void setGroupLayer(int groupLayer) {
		this.groupLayer = groupLayer;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Timestamp getQnaCreateDate() {
		return qnaCreateDate;
	}

	public void setQnaCreateDate(Timestamp qnaCreateDate) {
		this.qnaCreateDate = qnaCreateDate;
	}

	public Timestamp getQnaModifyDate() {
		return qnaModifyDate;
	}

	public void setQnaModifyDate(Timestamp qnaModifyDate) {
		this.qnaModifyDate = qnaModifyDate;
	}

	public String getQnaWriter() {
		return qnaWriter;
	}

	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	

	public int getQnaAnswer() {
		return qnaAnswer;
	}

	public void setQnaAnswer(int qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}

	@Override
	public String toString() {
		return "QNABoard [qnaNo=" + qnaNo + ", originNo=" + originNo + ", groupOrd=" + groupOrd + ", groupLayer="
				+ groupLayer + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", readCount=" + readCount
				+ ", qnaCreateDate=" + qnaCreateDate + ", qnaModifyDate=" + qnaModifyDate + ", qnaWriter=" + qnaWriter
				+ ", qnaAnswer=" + qnaAnswer + "]";
	}

}
