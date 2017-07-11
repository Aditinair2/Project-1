package com.niit.dao;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.UserDetail;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();	
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem item : cartItems) {
			removeCartItem(item);
		}
	}

	/*
	 * public CartItem getCartItemByProductId (String id,int cartId) { Session
	 * session = sessionFactory.openSession(); Query query =
	 * session.createQuery("from CartItem where id = ?"); query.setString(0,
	 * id); session.flush(); return (CartItem) query.uniqueResult();
	 * 
	 * String hql = "from CartItem where id='" + id + "' and cartId='"
	 * +cartId+"'"; Session session = sessionFactory.openSession();
	 * System.out.println("ooooo"); Query query = session.createQuery(hql);
	 * System.out.println("pppp");
	 * 
	 * @SuppressWarnings("unchecked") List<CartItem> cartItems =
	 * (List<CartItem>) query.list(); for (CartItem item : cartItems) {
	 * System.out.println("item value"+item.getCartProductId()); //return item;
	 * }
	 * 
	 * //cartItems.get(0); if (cartItems != null && !cartItems.isEmpty()) {
	 * System.out.println(cartItems.get(0).getCartProductId()); return
	 * cartItems.get(0); } return null; }
	 */

	public CartItem getCartItemByProductId(String id, int cartId) {
		/*
		 * Session session = sessionFactory.openSession(); Query query =
		 * session.createQuery("from CartItem where CARTID = '"+cartId+
		 * "' and id='"+id+"'"); List<CartItem> cartItems = (List<CartItem>)
		 * query.list();
		 */

		List<CartItem> cartItems = getAllCartItems(cartId);
		if (cartItems != null && !cartItems.isEmpty()) {
			for (CartItem item : cartItems) {
				if (item.getProduct().getName().equals(id)){
					return item;
				}
			}
		}

		return null;
	}

	public List<CartItem> getAllCartItems(int cartId) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem where CARTID = '" + cartId + "' ORDER BY ID ASC");
		List<CartItem> cartItems = query.list();
		return cartItems;
	}

}
