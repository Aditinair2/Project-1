package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cart;
import com.niit.model.User;
import com.niit.model.UserDetail;
import com.niit.model.UserRole;

@Repository("usersDetailDAO")
@Transactional
public class UserDetailDaoImpl implements UserDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(UserDetail usersDetail) {

		Session session = sessionFactory.openSession();

		session.saveOrUpdate(usersDetail);

		// User newUser = new User();
		User newUser = usersDetail.getUser();
//		newUser.setUsername(usersDetail.getUser().);
//		newUser.setPassword(usersDetail.getPassword());
		newUser.setEnabled(true);
		newUser.setId(usersDetail.getId());

		UserRole newUserRole = new UserRole();
		newUserRole.setUsername(usersDetail.getUser().getUsername());
		newUserRole.setRole("ROLE_USER");
		Cart cart = new Cart();
		cart.setUsersDetail(usersDetail);
		usersDetail.setCart(cart);

		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newUserRole);

		session.saveOrUpdate(usersDetail);

		session.flush();
		session.close();

	}

	// LOOK HERE
	@Transactional
	public boolean isValidUser(String name) {
		// select * from UserDetails where id='101' and password='niit'
		String hql = "from UserDetail where username='" + name + "'";
		Query query = sessionFactory.openSession().createQuery(hql);

		List<UserDetail> list = query.list();// list of users detail

		if (list != null) {
			return false;// invalid user
		} else {
			return true;// valid user
		}
	}

	public UserDetail getUserById(int userId) {
		Session session = sessionFactory.openSession();
		return (UserDetail) session.get(UserDetail.class, userId);
	}

	public List<UserDetail> getAllUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserDetail");
		List<UserDetail> usersDetail = query.list();

		return usersDetail;
	}

	// public UserDetail getUserByUsername (String username) {
	// Session session = sessionFactory.openSession();
	// Query query = session.createQuery("from UserDetail where username = ?");
	// query.setString(0, username);
	// return (UserDetail) query.uniqueResult();
	// }

	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username = ?");
		query.setString(0, username);
		return (User) query.uniqueResult();
	}

	public boolean isValidUser(String name, String password) {

		return false;
	}
}