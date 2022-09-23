package com.ty.controller;

import java.util.List;

import com.ty.dao.CartDao;
import com.ty.dto.Cart;

public class GetAllCart {

	public static void main(String[] args) {
		CartDao dao = new CartDao();
		List<Cart> c=dao.getAllCart();
		for(Cart a:c) {
			System.out.println(a.getId());
			System.out.println(a.getEmail());
			System.out.println(a.getPassword());
			System.out.println(a.getUsername());
			System.out.println(a.getAddress());
		}
			
		

	}

}
