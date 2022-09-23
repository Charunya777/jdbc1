package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDao;
import com.ty.dto.Cart;



public class UpdateCart {

	public static void main(String[] args) {
		CartDao dao = new CartDao();
		Scanner sc1= new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc1.nextInt();
		System.out.println("enter the email");
		String email=sc1.next();
		System.out.println("enter the password");
		String password=sc1.next();
		System.out.println("enter the username");
		String username= sc1.next();
		System.out.println("enter the address");
		String address=sc1.next();
		
		Cart c= new Cart();
		c.setId(id);
		c.setEmail(email);
		c.setPassword(password);
		c.setUsername(username);
		c.setAddress(address);
		
			System.out.println(dao.updateCartObj(c));

	}

}
