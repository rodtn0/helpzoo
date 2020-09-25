package com.project.helpzoo.funding.model.vo.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.funding.Reward;

@Entity
@SequenceGenerator(
		name = "ORDER_REWARD_SEQ_GENERATOR",
		sequenceName = "ORDER_REWARD_SEQ",
		initialValue = 1, allocationSize = 1)
@Table(name="order_reward")
public class OrderReward {

	
	@Column(name="order_reward_id")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDER_REWARD_SEQ_GENERATOR")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "reward_id")
	private Reward reward;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Orders order;
	
	@Column(name="ORDER_REWARD_AMOUNT")
	private int count;
	
	
	@Column(name = "PRICE")
	private int price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="funding_id")
	private FundingProject funding;
	
	
	
	
	
	
	
	

	public FundingProject getFunding() {
		return funding;
	}

	public void setFunding(FundingProject funding) {
		this.funding = funding;
	}

	public OrderReward(Reward reward, Orders order, int count, int price) {
		super();
		this.reward = reward;
		this.order = order;
		this.count = count;
		this.price = price;
	}

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
	


	
	
	
	
	


	public OrderReward(Reward reward, Orders order, int count) {
		super();
		this.reward = reward;
		this.order = order;
		this.count = count;
	}

	public OrderReward() {
		super();
	}

	public OrderReward(Reward reward, int count) {
		super();
		this.reward = reward;
		this.count = count;
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
