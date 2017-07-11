package com.niit.dao;

import com.niit.dao.CartDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.UserDetail;

import org.hibernate.HibernateException;
import org.hibernate.Query;
//import com.niit.service.OrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{

    @Autowired
    private SessionFactory sessionFactory;

   /* @Autowired
    private OrderService orderService;*/

    public Cart getCartById (int cartId) {
        Session session = sessionFactory.openSession();
        
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart) {
		
		Session session = sessionFactory.openSession();
		try {
			cart.setGrandTotal(3.33);
			session.update(cart);
			session.flush();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 public Cart validate(int cartId) throws IOException {
        Cart cart=getCartById(cartId);
        if(cart==null||cart.getCartItems().size()==0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }

public void addCartItem(CartItem cartItem) {
	Session session = sessionFactory.openSession();	
	session.saveOrUpdate(cartItem);
	session.flush();
	session.close();

}

public void removeCartItem(CartItem cartItem) {
	Session session = sessionFactory.openSession();
	session.delete(cartItem);
	session.flush();
}

public void removeAllCartItems(Cart cart) {
	String hql="delete from CartItem C where cartId='" + cart.getCartId() + "'";  
    Session session=sessionFactory.openSession();
    Query query=session.createQuery(hql);
    query.executeUpdate(); 
}

public CartItem getCartItemByProductId(int id, int cartId) {
	List<CartItem> cartItems = getAllCartItems(cartId);
	if (cartItems != null && !cartItems.isEmpty()) {
		for (CartItem item : cartItems) {
			if (item.getProduct().getId()==id){
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
