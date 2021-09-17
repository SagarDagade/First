package com.edusol.customer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import antlr.collections.List;

@Embeddable
public class Product {
	
	private int p_id;
	
	private String p_name;
	
	private long price;
	
	private String desc;
	
	private int quantity=1;
	

	public Product() {
		super();
	}

	public Product(int p_id, String p_name, long price, String desc, List prod) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.price = price;
		this.desc = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", price=" + price + ", desc=" + desc;
	}

	


	

}
