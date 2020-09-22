package com.project.helpzoo.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Mailing {
	
	private int memberNo;
	private String mailStatus;
	
	public Mailing() {
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}
	
	@Override
	public String toString() {
		return "Mailing [memberNo=" + memberNo + ", mailStatus=" + mailStatus + "]";
	}
	
	
	
}
