package com.project.helpzoo.funding.model.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ORDERS")
public class Order {
	
	
	@Id
	@Column(name = "ORDER_ID")
	private long id;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "ORDER_STATUS")
	private String status;
	
	
	@Column(name = "DELIVERY_ID")
	private long deliveryId;
	
	@Column(name = "DELIVERY_ID2")
	private long deliveryId2;
	
	@Column(name = "MEMBER_NO")
	private long member_no;

	
	
	
	
	
	public Order() {
		
	}
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public long getDeliveryId2() {
		return deliveryId2;
	}

	public void setDeliveryId2(long deliveryId2) {
		this.deliveryId2 = deliveryId2;
	}

	public long getMember_no() {
		return member_no;
	}

	public void setMember_no(long member_no) {
		this.member_no = member_no;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", status=" + status + ", deliveryId=" + deliveryId
				+ ", deliveryId2=" + deliveryId2 + ", member_no=" + member_no + "]";
	}

	public Order(long id, Date orderDate, String status, long deliveryId, long deliveryId2, long member_no) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.status = status;
		this.deliveryId = deliveryId;
		this.deliveryId2 = deliveryId2;
		this.member_no = member_no;
	}
	

}
