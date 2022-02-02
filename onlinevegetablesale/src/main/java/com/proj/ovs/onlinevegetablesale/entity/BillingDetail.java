package com.proj.ovs.onlinevegetablesale.entity;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class BillingDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bilingId;
	
	@Min(value=1)
	@Max(value=1000000)
	private int orderId;
	
	
	@Enumerated(value=EnumType.STRING)
	private TransactionMode transactionMode;
	
	
	private Date transactionDate;

	@Enumerated(value=EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address billingAddress;
	
	public BillingDetail() {
		super();
	}

	public BillingDetail(int bilingId, int orderId,
			@NotNull(message = "transaction mode is mandatory") TransactionMode transactionMode, Date transactionDate,
			TransactionStatus transactionStatus, Address billingAddress) {
		super();
		this.bilingId = bilingId;
		this.orderId = orderId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.billingAddress = billingAddress;
	}

	public int getBilingId() {
		return bilingId;
	}

	public void setBilingId(int bilingId) {
		this.bilingId = bilingId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public TransactionMode getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "BillingDetail [bilingId=" + bilingId + ", orderId=" + orderId + ", transactionMode=" + transactionMode
				+ ", transactionDate=" + transactionDate + ", transactionStatus=" + transactionStatus
				+ ", billingAddress=" + billingAddress + "]";
	}
}