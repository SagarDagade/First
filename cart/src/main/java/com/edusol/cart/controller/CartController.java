package com.edusol.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.cart.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartServ;
	
	@PostMapping("/add-to-cart")
	public String addCart(@RequestParam int cid, @RequestParam int pid)
	{
		return cartServ.addCart(cid,pid);
	}
	
	@GetMapping("/get")
	public Object getCart()
	{
		return cartServ.getCart();
	}
	
	@DeleteMapping("/remove-from-cart")
	public Object removeProd(@RequestParam int cid, @RequestParam int pid)
	{
		return cartServ.removeProd(cid,pid);
	}
	
	@PutMapping("/add-quantity")
	public Object addQuantity(@RequestParam int cid, @RequestParam int pid, @RequestParam int q)
	{
		return cartServ.addQuantity(cid,pid,q);
	}

}
