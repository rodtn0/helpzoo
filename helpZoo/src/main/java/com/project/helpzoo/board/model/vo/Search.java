package com.project.helpzoo.board.model.vo;

import java.util.Arrays;

public class Search {


	// field
	private String[] ct;
	private String sKey;
	private String sVal;
	
	// constructor
	public Search() {
	}
	
	// getter/setter
	public String[] getCt() {
		return ct;
	}

	public void setCt(String[] ct) {
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
		return "Search [ct=" + Arrays.toString(ct) + ", sKey=" + sKey + ", sVal=" + sVal + "]";
	}
	
	
}
