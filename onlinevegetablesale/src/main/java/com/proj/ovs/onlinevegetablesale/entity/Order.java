package com.proj.ovs.onlinevegetablesale.entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Entity(name="order_Table")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	@Min(value=1)
	@Max(value=1000000)
private int customerId;
@NotNull(message="amount is not null")
@Min(value=15)
private double totalAmount;
@NotNull(message="status should be mandatory")
private String status;
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public Order(int orderNo, int customerId,  double totalAmount, String status) {
	super();
	this.orderId = orderNo;
	this.customerId=customerId;
	this.totalAmount = totalAmount;
	this.status = status;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderNo) {
	this.orderId = orderNo;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Order [orderNo=" + orderId + ", customerId=" + customerId + ",  totalAmount=" + totalAmount + ", status=" + status + "]";
}

}
