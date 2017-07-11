package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItem;
//import com.niit.model.Product;

public interface CartDao {
	Cart getCartById (int cartId);
	void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId (int id,int cartId);
    
   List<CartItem> getAllCartItems(int cartId);
   
   void update(Cart cart);
   //void deleteCartItemThroughProduct(Product product);
}