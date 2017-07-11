package com.niit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niit.model.Product;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;

import java.io.Serializable;


@Entity
public class CartItem implements Serializable{
	
	
	private static final long serialVersionUID = 15L;

    @Id
    @GeneratedValue
    private int cartProductId;

    @ManyToOne
    @JoinColumn(name = "cartId")
   // @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

    private int quantity;
    private double totalPrice;
    

    public int getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(int cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
