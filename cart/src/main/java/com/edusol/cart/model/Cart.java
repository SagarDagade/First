package com.edusol.cart.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
public class Cart {

	@Id
	private int c_id;
	@ElementCollection
	private List<Product> prod;
	
	private long total;

	public Cart() {
		super();
	}

	public Cart(int c_id, List<Product> prod, long total) {
		super();
		this.c_id = c_id;
		this.prod = prod;
		this.total = total;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public List<Product> getProd() {
		return prod;
	}

	public void setProd(List<Product> prod) {
		this.prod = prod;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [c_id=" + c_id + ", prod=" + prod + ", total=" + total + "]";
	}

	
}
