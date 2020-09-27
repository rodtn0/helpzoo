package com.project.helpzoo.funding.controller;

public class RewardView {
	
	
	private String title;
	private int amount;
	private int price;
	
	
	
	
	
	public RewardView() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	public RewardView(String title, int amount, int price) {
		super();
		this.title = title;
		this.amount = amount;
		this.price = price;
	}
	@Override
	public String toString() {
		return "RewardView [rewardTitle=" + title + ", amount=" + amount + ", price=" + price + "]";
	}
	
	
	
	
	

}
