package com.project.helpzoo.funding.model.vo.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
		name = "ORDER_REWARD_SEQ_GENERATOR",
		sequenceName = "ORDER_REWARD_SEQ",
		initialValue = 1, allocationSize = 1)
@Table(name="order_reward")
public class OrderReward {

	
	@Id @GeneratedValue
	@Column(name="order_reward_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "reward_id")
	private Reward reward;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Orders order;
	
	@Column(name="ORDER_REWARD_AMOUNT")
	private int count;
	
	private int price;
	
	
	
	
	
	public static OrderReward makeOrderReward(Reward reward, int price, int count) {
		
		OrderReward orderReward = new OrderReward();
		orderReward.setReward(reward);
		orderReward.setPrice(price);
		orderReward.setCount(count);
		
		reward.removeStock(count);
		
		return orderReward;
		
	}
	
	public void cancel() {
		
		getReward().addStock(count);
		
		
	}
	


	
	
	
	
	
	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Reward getReward() {
		return reward;
	}



	public void setReward(Reward reward) {
		this.reward = reward;
	}



	public Orders getOrder() {
		return order;
	}



	public void setOrder(Orders order) {
		this.order = order;
	}






	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderReward [id=" + id + ", reward=" + reward + ", order=" + order + ", count=" + count + ", price="
				+ price + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
