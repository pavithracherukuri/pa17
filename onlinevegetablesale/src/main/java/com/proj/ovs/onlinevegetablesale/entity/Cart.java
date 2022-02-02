package com.proj.ovs.onlinevegetablesale.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int cartId;
	@OneToOne
	private Customer customer;
	
@OneToMany(cascade=CascadeType.ALL)
@NotNull(message="vegetable list should not be null")
private List<Vegetable> vegetable;

public Cart() {
	super();
}
public Cart(int cartId, Customer customer, List<Vegetable> vegetable) {
	super();
	this.cartId = cartId;
	this.customer= customer;
	this.setVegetable(vegetable);
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public List<Vegetable> getVegetable() {
	return vegetable;
}
public void setVegetable(List<Vegetable> vegetable) {
	this.vegetable = vegetable;
}
@Override
public String toString() {
	return "Cart [cartId=" + cartId + ", customer=" + customer + ", vegetable=" + vegetable + "]";
}
}