package com.edusol.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.cart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
