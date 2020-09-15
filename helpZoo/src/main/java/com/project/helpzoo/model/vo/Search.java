package com.project.helpzoo.model.vo;

import java.util.Arrays;

public class Search {
	private String[] ct;
	private String sKey;
	private String sVal;
	/**
	 * 
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ct
	 * @param sKey
	 * @param sVal
	 */
	public Search(String[] ct, String sKey, String sVal) {
		super();
		this.ct = ct;
		this.sKey = sKey;
		this.sVal = sVal;
	}
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
