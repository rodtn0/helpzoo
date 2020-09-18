package com.project.helpzoo.member.model.vo;

import java.sql.Timestamp;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private String memberPetType;
	private String memberPetName;
	private Timestamp memberEnrollDate;
	private String memberStatus;
	private String memberGrade;
	
	private String projectNo;
	private String projectTitle;
	private String projectSummay;
	private String filePath;
	private String fileChangeName;
	
	// (1) 기본 생성자 작성
	public Member() {
		
	}
	
	// (2) 매개변수 있는 생성자
	public Member(int memberNo, String memberId, String memberPwd, String memberName, String memberPhone,
			String memberEmail, String memberAddress, String memberPetType, String memberPetName,
			Timestamp memberEnrollDate, String memberStatus, String memberGrade) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberPetType = memberPetType;
		this.memberPetName = memberPetName;
		this.memberEnrollDate = memberEnrollDate;
		this.memberStatus = memberStatus;
		this.memberGrade = memberGrade;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberPetType() {
		return memberPetType;
	}

	public void setMemberPetType(String memberPetType) {
		this.memberPetType = memberPetType;
	}

	public String getMemberPetName() {
		return memberPetName;
	}

	public void setMemberPetName(String memberPetName) {
		this.memberPetName = memberPetName;
	}

	public Timestamp getMemberEnrollDate() {
		return memberEnrollDate;
	}

	public void setMemberEnrollDate(Timestamp memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
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
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberAddress="
				+ memberAddress + ", memberPetType=" + memberPetType + ", memberPetName=" + memberPetName
				+ ", memberEnrollDate=" + memberEnrollDate + ", memberStatus=" + memberStatus + ", memberGrade="
				+ memberGrade + ", projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", projectSummay="
				+ projectSummay + ", filePath=" + filePath + ", fileChangeName=" + fileChangeName + "]";
	}
	
	
}
