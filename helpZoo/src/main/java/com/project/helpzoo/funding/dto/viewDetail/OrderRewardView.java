package com.project.helpzoo.funding.dto.viewDetail;

import java.util.Arrays;

public class OrderRewardView {

	
	private int[] id;
	
	private int[] amount;
	
	
	
	public OrderRewardView() {
		
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}

	public int[] getAmount() {
		return amount;
	}

	public void setAmount(int[] amount) {
		this.amount = amount;
	}

	public OrderRewardView(int[] id, int[] amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderRewardView [id=" + Arrays.toString(id) + ", amount=" + Arrays.toString(amount) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(amount);
		result = prime * result + Arrays.hashCode(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderRewardView other = (OrderRewardView) obj;
		if (!Arrays.equals(amount, other.amount))
			return false;
		if (!Arrays.equals(id, other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
}
