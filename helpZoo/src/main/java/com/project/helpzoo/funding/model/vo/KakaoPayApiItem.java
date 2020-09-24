package com.project.helpzoo.funding.model.vo;

public class KakaoPayApiItem {

	
	private String name;
	
	private int quantity;
	
	private String userId;
	
	private long orderId;
	
	private int totalAmount;

	
	


	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	
	
	
	
	
	
	public KakaoPayApiItem(String name, int quantity, String userId, long orderId, int totalAmount) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.userId = userId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "KakaoPayApiItem [name=" + name + ", quantity=" + quantity + ", userId=" + userId + ", orderId="
				+ orderId + "]";
	}
	
	
	
	
	
	
	
}
