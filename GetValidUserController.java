package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDao;
import com.ty.dto.User;

public class GetInvalidUser {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		Scanner sc1= new Scanner(System.in);
		System.out.println("enter the email");
		String email=sc1.next();
		System.out.println("enter the password");
		String password=sc1.next();
		User u=dao.getUserByEmailAndPassword(email, password);
		if(u!=null) {
			System.out.println("welcome"+ u.getFirstname());
		}
		else {
			System.out.println("sorry user doesnot exist");
		}
	}

}
