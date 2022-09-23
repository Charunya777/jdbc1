package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDao;
import com.ty.dto.Cart;



public class getCart {

	public static void main(String[] args) {
		CartDao dao= new CartDao();
		 Scanner sc1= new Scanner(System.in);
			System.out.println("enter the id");
			int id=sc1.nextInt();
			//Cart c = new Cart();
			Cart rs=dao.getCart(id);
			System.out.println(rs.getId());
			System.out.println(rs.getEmail());
			System.out.println(rs.getPassword());
			System.out.println(rs.getUsername());
			System.out.println(rs.getAddress());

	}

}
