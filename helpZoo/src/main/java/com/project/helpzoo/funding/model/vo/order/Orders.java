package com.project.helpzoo.funding.model.vo.order;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ORDERS")
@SequenceGenerator(
		name = "ORDER_SEQ_GENERATOR",
		sequenceName = "ORDER_SEQ",
		initialValue = 1, allocationSize = 1)
public class Orders {
	
	
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDER_SEQ_GENERATOR")
	private long id;
	
	@Column(name = "ORDER_DATE")
	private Timestamp orderDate;
	
	@Column(name = "ORDER_STATUS")
	private String status;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Delivery delivery;
	
	@Column(name = "MEMBER_NO")
	private long memberId;

	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	 private List<OrderReward> orderRewards = new ArrayList<>();
	
	
	
	public void addOrderReward(OrderReward orderReward) {
		orderRewards.add(orderReward);
		orderReward.setOrder(this);
		
	}
	
	
	
	
	
	public Orders() {
		
	}
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getMember_no() {
		return memberId;
	}

	public void setMember_no(long member_no) {
		this.memberId = member_no;
	}
	
	
	
	

	public Delivery getDelivery() {
		return delivery;
	}





	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}





	public long getMemberId() {
		return memberId;
	}





	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}





	public List<OrderReward> getOrderRewards() {
		return orderRewards;
	}





	public void setOrderRewards(List<OrderReward> orderRewards) {
		this.orderRewards = orderRewards;
	}





	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", status=" + status + ", deliveryId="
				+ ", deliveryId2=" + ", member_no=" + memberId + "]";
	}

	public Orders(long id, Timestamp orderDate, String status, long deliveryId, long deliveryId2, long member_no) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.status = status;
		this.memberId = member_no;
	}



	
	

}
