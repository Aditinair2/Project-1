package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {

	//public boolean save(Product product);

	//public boolean update(Product product);

	public boolean saveOrUpdate(Product product);

	public boolean deleteProductById(int id);

	public Product getProductById(int id);
	
	//public Product getByName(String name);

	public List<Product> list();

	public Product get(String id);

	

}
