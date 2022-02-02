package com.proj.ovs.onlinevegetablesale.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int userId;
	
	@NotNull(message="password is mandatory")
    @Length(min=6,max=8,message="password must be of length 8")
private String password;
	
@NotNull(message="role should not be null")
private String role;
public User() {
	super();
	
}
public User(int userId, String password, String role) {
	super();
	this.userId = userId;
	this.password = password;
	this.role = role;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
}
}
