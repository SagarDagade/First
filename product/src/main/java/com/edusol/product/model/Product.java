package com.edusol.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name = "PRODUCT_MART")
public class Product {
	
	@Id
	@Column(name = "PRODUCT_ID")
	private int p_id;
	@Column(name = "PRODUCT_NAME")
	private String p_name;
	@Column(name = "PRODUCT_PRICE")
	private long price;
	@Column(name = "PRODUCT_DESC")
	private String desc;
	@Column(name = "PRODUCT_QUAN")
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
