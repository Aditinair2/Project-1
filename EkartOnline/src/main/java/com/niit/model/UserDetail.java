package com.niit.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 8L;

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 3, max = 30, message = "Size can be between 3 and 30")
	@NotEmpty(message = "User full name can not be empty.")
	private String userFullName;

	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "email format abc@xyz.com")
	@NotEmpty(message = "Email can not be empty.")
	@Column(unique = true)
	private String userEmail;

	@Pattern(regexp = "\\d{10}", message = "Enter 10 digit phone number")
	@NotEmpty(message = "Phone can not be empty.")
	@Column(unique = true)
	private String userPhone;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_id")
	private BillingAddress billingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_id")
	private ShippingAddress shippingAddress;

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	private boolean enabled;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
}