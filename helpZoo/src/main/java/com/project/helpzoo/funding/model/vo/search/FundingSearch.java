package com.project.helpzoo.funding.model.vo.search;

import java.util.Arrays;

public class FundingSearch {

	private String ct;
	private String sKey;
	private String sVal;
	
	public FundingSearch() {
		
	}
	
	public FundingSearch(String ct, String sKey, String sVal) {
		super();
		this.ct = ct;
		this.sKey = sKey;
		this.sVal = sVal;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getsKey() {
		return sKey;
	}

	public void setsKey(String sKey) {
		this.sKey = sKey;
	}

	public String getsVal() {
		return sVal;
	}

	public void setsVal(String sVal) {
		this.sVal = sVal;
	}

	@Override
	public String toString() {
		return "Search [ct=" + ", sKey=" + sKey + ", sVal=" + sVal + "]";
	}
	
	
	

	
	   
	   
}
