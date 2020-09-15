package com.project.helpzoo.model.vo;

import java.sql.Date;

public class OrganizationInfo {
	
	private int organizationNo;
	private String corperationNo;
	private String organizationName;
	private String organizationContent;
	private String organizationTel;
	private String organizationCode;
	private String organizationAddr;
	private String organizationZip;
	private int memberNo;
	private String organizationOutYn;
	private Date organizationEnrollDate;
	private String organizationUseYn;
	
	
	
	public OrganizationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrganizationInfo(int organizationNo, String corperationNo, String organizationName,
			String organizationContent, String organizationTel, String organizationCode, String organizationAddr,
			String organizationZip, int memberNo, String organizationOutYn, Date organizationEnrollDate,
			String organizationUseYn) {
		super();
		this.organizationNo = organizationNo;
		this.corperationNo = corperationNo;
		this.organizationName = organizationName;
		this.organizationContent = organizationContent;
		this.organizationTel = organizationTel;
		this.organizationCode = organizationCode;
		this.organizationAddr = organizationAddr;
		this.organizationZip = organizationZip;
		this.memberNo = memberNo;
		this.organizationOutYn = organizationOutYn;
		this.organizationEnrollDate = organizationEnrollDate;
		this.organizationUseYn = organizationUseYn;
	}
	public int getOrganizationNo() {
		return organizationNo;
	}
	public void setOrganizationNo(int organizationNo) {
		this.organizationNo = organizationNo;
	}
	public String getCorperationNo() {
		return corperationNo;
	}
	public void setCorperationNo(String corperationNo) {
		this.corperationNo = corperationNo;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationContent() {
		return organizationContent;
	}
	public void setOrganizationContent(String organizationContent) {
		this.organizationContent = organizationContent;
	}
	public String getOrganizationTel() {
		return organizationTel;
	}
	public void setOrganizationTel(String organizationTel) {
		this.organizationTel = organizationTel;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getOrganizationAddr() {
		return organizationAddr;
	}
	public void setOrganizationAddr(String organizationAddr) {
		this.organizationAddr = organizationAddr;
	}
	public String getOrganizationZip() {
		return organizationZip;
	}
	public void setOrganizationZip(String organizationZip) {
		this.organizationZip = organizationZip;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getOrganizationOutYn() {
		return organizationOutYn;
	}
	public void setOrganizationOutYn(String organizationOutYn) {
		this.organizationOutYn = organizationOutYn;
	}
	public Date getOrganizationEnrollDate() {
		return organizationEnrollDate;
	}
	public void setOrganizationEnrollDate(Date organizationEnrollDate) {
		this.organizationEnrollDate = organizationEnrollDate;
	}
	public String getOrganizationUseYn() {
		return organizationUseYn;
	}
	public void setOrganizationUseYn(String organizationUseYn) {
		this.organizationUseYn = organizationUseYn;
	}
	@Override
	public String toString() {
		return "OrganizationInfo [organizationNo=" + organizationNo + ", corperationNo=" + corperationNo
				+ ", organizationName=" + organizationName + ", organizationContent=" + organizationContent
				+ ", organizationTel=" + organizationTel + ", organizationCode=" + organizationCode
				+ ", organizationAddr=" + organizationAddr + ", organizationZip=" + organizationZip + ", memberNo="
				+ memberNo + ", organizationOutYn=" + organizationOutYn + ", organizationEnrollDate="
				+ organizationEnrollDate + ", organizationUseYn=" + organizationUseYn + "]";
	}
	
	

}
