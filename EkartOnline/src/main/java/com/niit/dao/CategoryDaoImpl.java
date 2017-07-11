package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl()
	{
		
	}

	public CategoryDaoImpl(SessionFactory sessionFactory) {
	 this.sessionFactory = sessionFactory;
	

	 }

	
	public Category getCategoryById(int id) {

		String hql = "from Category where id=:id";
		System.out.println(hql);
		Session session = sessionFactory.openSession();
		System.out.println("get called**");
		Query query = session.createQuery(hql).setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		System.out.println(listCategory);
		if (listCategory != null && !listCategory.isEmpty()) {

			System.out.println(listCategory.get(0));
			return listCategory.get(0);
		}
		return null;
	}


	public Category getByName(String name) {

		String hql = "from Category where name='" + name + "'";

		Query query = sessionFactory.openSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		System.out.println(listCategory);

		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}

		return null;

	}


	public boolean saveOrUpdate(Category category) {

		try {
			System.out.println("inside save or update");
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(category);
			session.flush();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		}
	}


	public boolean delete(int id) {
		try {
			Category categoryToDelete = new Category();
			categoryToDelete.setId(id);
			Session session = sessionFactory.openSession();
			session.delete(categoryToDelete);
			session.flush();

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		}
	}


	public List<Category> list() {

		String hql = "from Category ORDER BY ID ASC";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Category> list = query.list();
		if (list == null || list.isEmpty()) {
			System.out.println("list is empty");
		}

		return list;
	}
//
//	public Category getCategoryById(int id) {
//		
//		
//		Category category=(Category) sessionFactory.getCurrentSession().get(Category.class, id);
//		
//		return category;
//	}
}
