package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {

	public Category getCategoryById(int id);

	public Category getByName(String name);

	public boolean saveOrUpdate(Category category);

	public boolean delete(int id);

	public List<Category> list();
	
//	public Category getCategoryById(int id);

}
