package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDao;

public class DeleteCart {

	public static void main(String[] args) {
		CartDao dao = new CartDao();
		Scanner sc1= new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc1.nextInt();
	System.out.println(dao.deleteCart(id));

	}

}
