package com.project.helpzoo.funding.model.vo.search;

public class FundingSearch {

	
	   private  String searchText; // 회원 이름
	   private  SearchStatus fundingStatus; 
	   private  SearchSort searchSort;
	   
	   
	   
	   
	   
	   
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public SearchStatus getfundingStatus() {
		return fundingStatus;
	}
	public void setOrderStatus(SearchStatus fundingStatus) {
		this.fundingStatus = fundingStatus;
	}
	public SearchSort getSearchSort() {
		return searchSort;
	}
	public void setSearchSort(SearchSort searchSort) {
		this.searchSort = searchSort;
	}
	@Override
	public String toString() {
		return "OrderSearch [searchText=" + searchText + ", orderStatus=" + fundingStatus + ", searchSort=" + searchSort
				+ "]";
	}

	
	   
	   
}
