package com.proj.ovs.onlinevegetablesale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int addressId;
	@Length(min=2,max=6)
 private String flatNo;
	@NotNull(message=" building name should not be null")
	@Length(min=5,max=20,message="length should be minimum 5 and maximum 20 characters")
 private String buildingName;
	@NotNull(message="area name should not be null")
 private String area;
	@NotNull(message="city name should not be null")
 private String city ;
	@NotNull(message="state name should be mandatory")
 private String state;
	@NotNull(message="pincode should be mandatory")
	@Pattern(regexp="^[1-9]{1}[0-9]{5}$",message="pin code should not start with 0,must have only numbers and should have length is 6")
 private String pincode;
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public Address(int addressId,String flatNo, String buildingName, String area, String city, String state, String pincode) {
	super();
	this.addressId=addressId;
	this.flatNo = flatNo;
	this.buildingName = buildingName;
	this.area = area;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
}
public String getFlatNo() {
	return flatNo;
}
public void setFlatNo(String flatNo) {
	this.flatNo = flatNo;
}
public String getBuildingName() {
	return buildingName;
}
public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}

public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", flatNo=" + flatNo + ", buildingName=" + buildingName + ", area="
			+ area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
}
 
}
