package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Product implements Serializable {

	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@NotEmpty(message = "Product name can not be empty.")
	@Column(unique = true, nullable = false)
	private String name;

	private String description;
	// @NotEmpty(message = "Product price can not be empty.")
	private int price;

//	private String category_id;
//	private String supplier_id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

//	public String getCategory_id() {
//		return category_id;
//	}
//
//	public void setCategory_id(String category_id) {
//		this.category_id = category_id;
//
//	}
//
//	public String getSupplier_id() {
//		return supplier_id;
//	}
//
//	public void setSupplier_id(String supplier_id) {
//		this.supplier_id = supplier_id;
//	}

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	@Transient
	private MultipartFile itemImage;

	// getters +setters

	public MultipartFile getItemImage() {
		return itemImage;
	}

	public void setItemImage(MultipartFile itemImage) {
		this.itemImage = itemImage;
	}

	public Category getCategory() {
		System.out.println("get categorycalled***=" + category);
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
		System.out.println("set Category called**" + this.category);

	}

	public Supplier getSupplier() {
		System.out.println("get supplier called **" + supplier);
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
//				+ ", category=" + category + ", supplier=" + supplier + ", itemImage=" + itemImage + "]";
//	}
	
	
	

}
