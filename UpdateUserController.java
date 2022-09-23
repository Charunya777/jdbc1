package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDao;
import com.ty.dto.User;

public class UpdateUser {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		Scanner sc1= new Scanner(System.in);
		System.out.println("enter the firstname");
		String firstname=sc1.next();
		System.out.println("enter the Lastname");
		String lastname=sc1.next();
		System.out.println("enter the email");
		String email=sc1.next();
		System.out.println("enter the password");
		String password= sc1.next();
		System.out.println("enter the phone");
		long phone=sc1.nextLong();
		System.out.println("enter the dateofbirth");
		String dateofbirth=sc1.next();
		System.out.println("enter the gender");
		String gender=sc1.next();
		
		User u= new User();
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		u.setDateofbirth(dateofbirth);
		u.setGender(gender);
		
		
			System.out.println(dao.updateUser(u));

	}


	}

