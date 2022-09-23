package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDao;
import com.ty.dto.User;

public class getUser {

	public static void main(String[] args) {
		UserDao dao= new UserDao();
		 Scanner sc1= new Scanner(System.in);
			System.out.println("enter the firstname");
			String firstname=sc1.next();
			
			User rs=dao.getUser(firstname);
			System.out.println(rs.getFirstname());
			System.out.println(rs.getLastname());
			System.out.println(rs.getEmail());
			System.out.println(rs.getPassword());
			System.out.println(rs.getPhone());
			System.out.println(rs.getDateofbirth());
			System.out.println(rs.getGender());

	}

}
