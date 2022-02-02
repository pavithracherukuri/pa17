package com.proj.ovs.onlinevegetablesale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Admin {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int adminId;
@NotNull(message="name should not be null")
private String name;

@NotNull(message="contact number should be mandatory")
@Pattern(regexp="^[0-9]{10}$",message="phone number must be in numerical")
private String contactNumber;

@NotNull(message="emailid should not be null")
@Email
private String emailId;
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(int adminId, String name, String contactNumber, String emailId) {
	super();
	this.adminId = adminId;
	this.name = name;
	this.contactNumber = contactNumber;
	this.emailId = emailId;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber + ", emailId=" + emailId
			+ "]";
}
}
