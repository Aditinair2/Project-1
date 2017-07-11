package com.niit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.UserDetailDao;
import com.niit.dao.ProductDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.UserDetail;
import com.niit.model.Product;
//import com.niit.model.Users;


@Controller
public class CartController {
@Autowired
private CartDao cartDao;
@Autowired
private ProductDao productDao;
@Autowired
private UserDetailDao userdetailDao;
@Autowired
private CategoryDao categoryDao;

@SuppressWarnings("unused")
@RequestMapping(value="/user/cart/additem/{id}",method=RequestMethod.GET)
public String addItem(@PathVariable int id, Model model)
{
	User activeUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	List<UserDetail> Users=userdetailDao.getAllUsers();
	for(UserDetail u:Users)
	{
		if(u.getUser().getUsername().equals(activeUser.getUsername()))
		{
			Cart cart=u.getCart();
			Product product=productDao.getProductById(id);
			List<CartItem> cartItems=cart.getCartItems();
			double grandTotal=0.0;
			if(cartItems.size()>0)
			{
			for (int i = 0; i < cartItems.size(); i++) {
				
				if (product.getId() == cartItems.get(i).getProduct().getId()) {
					System.out.println("First if");
					CartItem cartItem = cartItems.get(i);
					
					cartItem.setQuantity(cartItem.getQuantity() + 1);
					cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
					cartDao.addCartItem(cartItem);	
					
					for (int j = 0; j < cartItems.size(); j++) {
						grandTotal = grandTotal + cartItems.get(j).getProduct().getPrice(); 
					}
					cart.setGrandTotal(grandTotal);
					cartDao.update(cart);
					model.addAttribute("cartId", cart.getCartId());
					model.addAttribute("successMsg", product.getName() + " added to cart");
					model.addAttribute("cartList", cartDao.getAllCartItems(cart.getCartId()));
				
					return "myCart";
			}
				else
				{
					System.out.println("Second");
					CartItem cartItem = new CartItem();
					cartItems.add(cartItem);
					cartItem.setProduct(product);
					cartItem.setQuantity(1);
					cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
					cartItem.setCart(cart);
					cartDao.addCartItem(cartItem);
					
					
					for (int j = 0; j < cartItems.size(); j++) {
						grandTotal = grandTotal + cartItems.get(j).getProduct().getPrice();
					}
					cart.setGrandTotal(grandTotal);
					cartDao.update(cart);
						System.out.println(grandTotal);
					model.addAttribute("successMsg", product.getName() + " product added to cart");
					model.addAttribute("cartId", cart.getCartId());
					model.addAttribute("cartList", cartDao.getAllCartItems(cart.getCartId()));
					return "myCart";
				}
			}
			}
			else{
				System.out.println("third");
				
					CartItem cartItem = new CartItem();
					cartItems.add(cartItem);
					cartItem.setProduct(product);
					cartItem.setQuantity(1);
					cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
					cartItem.setCart(cart);
					cartDao.addCartItem(cartItem);
					
					
					for (int j = 0; j < cartItems.size(); j++) {
						grandTotal = grandTotal + cartItems.get(j).getProduct().getPrice();
					}
					
					cart.setGrandTotal(grandTotal);
					cartDao.update(cart);
						System.out.println(grandTotal);
					model.addAttribute("successMsg", product.getName() + " product added to cart");
					model.addAttribute("cartId", cart.getCartId());
					model.addAttribute("cartList", cartDao.getAllCartItems(cart.getCartId()));
					return "myCart";
				}
		}
	}
		return "myCart";
}



@RequestMapping(value = "/usercart/cart/removeItem/{id}/{cartId}", method = RequestMethod.GET)
public String removeItem(@PathVariable int id, @PathVariable(value = "cartId") int cartId,
		Model model) {
	CartItem cartItem = cartDao.getCartItemByProductId(id, cartId);
	if (cartItem != null) {
		cartDao.removeCartItem(cartItem);
	} else {
		System.out.println("object is null");
	}
	return "redirect:/user/cart/view/" + cartId;
}

@RequestMapping(value = "/usercart/cart/addQty/{id}/{cartId}",method = RequestMethod.GET)
public String addQuantity(@PathVariable(value = "id") int id, @PathVariable(value = "cartId") int cartId,
		Model model) {
	System.out.println("XXXXXXX");
	CartItem cartItem = cartDao.getCartItemByProductId(id, cartId);

	Product product=productDao.getProductById(id); 
	cartItem.setQuantity(cartItem.getQuantity() + 1);
	cartItem.setTotalPrice(cartItem.getQuantity()*product.getPrice());
	cartDao.addCartItem(cartItem);	
	System.out.println("XXXXXXX");
	return "redirect:/user/cart/view/" + cartId;
	
}

@RequestMapping(value = "/usercart/cart/reduceQty/{id}/{cartId}", method = RequestMethod.GET)
public String reduceQuantity(@PathVariable(value = "id") int id, @PathVariable(value = "cartId") int cartId,
		Model model) {
	CartItem cartItem = cartDao.getCartItemByProductId(id, cartId);

	Product product=productDao.getProductById(id);
	if(cartItem.getQuantity()>0){
	cartItem.setQuantity(cartItem.getQuantity() - 1);
	cartItem.setTotalPrice(cartItem.getQuantity()*product.getPrice());
	cartDao.addCartItem(cartItem);
	}
	return "redirect:/user/cart/view/" + cartId;
}
@RequestMapping(value = "/user/cart/update/{cartId}", method = RequestMethod.GET)
public String updateCart(@PathVariable(value = "id") int id, @PathVariable(value = "cartId") int cartId,
		Model model) {

	//CartItem cartItem = null;
	
	double grandTotal = 0.0;
	List<CartItem> cartItems=cartDao.getAllCartItems(cartId);
	for (int j = 0; j < cartItems.size(); j++) {
		grandTotal += cartItems.get(j).getTotalPrice();
	}
	Cart cart=cartDao.getCartById(cartId);
	cart.setGrandTotal(grandTotal);
	cartDao.update(cart);
	return "redirect:/user/cart/view/" + cartId;
}

@RequestMapping(value = "/usercart/cart/clearCartItems/{cartId}", method = RequestMethod.GET)
public String clearCartItems(@PathVariable(value = "cartId") int cartId, Model model) {
	Cart cart = cartDao.getCartById(cartId);
	cartDao.removeAllCartItems(cart);
	return "redirect:/user/cart/view/" + cartId;
}

@RequestMapping("/user/cart/view/{cartId}")
public String getNewUrl(@PathVariable (value = "cartId") int cartId, Model model) {
//	List<Category> category=categoryDao.getlist();
//	model.addAttribute("categoryList",categoryRecord);
    model.addAttribute("cartId", cartId);
    model.addAttribute("cartList", cartDao.getAllCartItems(cartId));
    //model.addAttribute("cartId", cartId);
    return "myCart";
}

@RequestMapping("/user/cart/checkout/{cartId}")
public String checkout(@PathVariable (value = "cartId") int cartId, Model model)
{
//	List<Category> category=categoryDao.getAllCategories();
//	model.addAttribute("categorylist", categoryRecord);
	UserDetail userDetail = cartDao.getCartById(cartId).getUsersDetail();
	model.addAttribute("userDetail",userDetail);  
	return "checkoutpage";
}

@RequestMapping("/page")
public String success(@ModelAttribute(value="userDetail") UserDetail userDetail, BindingResult result, Model model)
{
	model.addAttribute("userDetail",userDetail);
	Cart cart=userDetail.getCart();
	userdetailDao.addUser(userDetail); 
	cartDao.removeAllCartItems(cart); 
	return "successpage";
}
}
			
			/*CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
			cartItem.setCart(cart);
			cartDao.addCartItem(cartItem);
			
			
			for (int j = 0; j < cartItems.size(); j++) {
				grandTotal = grandTotal + cartItem.getTotalPrice();
			}
			cart.setGrandTotal(grandTotal);
			cartDao.update(cart);
				System.out.println(grandTotal);
			model.addAttribute("successMsg", product.getName() + " product added to cart");
			model.addAttribute("cartId", cart.getId());
			model.addAttribute("cartList", cartDao.getAllCartItems(cart.getId()));*/
			//return "myCart";
		


