package com.proj.ovs.onlinevegetablesale.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	@NotNull(message="name should not be null")
	private String name;
	@NotNull(message="contact number should be mandatory")
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$",message="phone number must be in numerical")
	private String mobileNumber;
	
	@OneToOne(cascade=CascadeType.ALL)
	private  Address address;
	
	@NotNull(message="emailid should not be null")
	@Email
	private String emailId;
	
	@NotNull(message="password is mandatory")
	@Length(min=8,message="you must enter atleast 8 characters")
	@Pattern(regexp="^[a-zA-Z!@#$%^&*+0-9]{8,20}",message="password should contain atleast one upper case,atleast one special characte")
	private String password;
	private String confirmPassword;
	public Customer() {
		super();
	}
	public Customer(int customerId, String name, String mobileNumber, Address address, String emailId,
			String password, String confirmPassword) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "BillingDetailsService [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

}
