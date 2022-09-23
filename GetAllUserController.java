package com.ty.controller;

import java.util.List;

import com.ty.dao.UserDao;

import com.ty.dto.User;

public class GetAllUser {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		List<User> u=dao.getAllUser();
		for(User a:u) {
			System.out.println(a.getFirstname());
			System.out.println(a.getLastname());
			System.out.println(a.getEmail());
			System.out.println(a.getPassword());
			System.out.println(a.getPhone());
			System.out.println(a.getDateofbirth());
			System.out.println(a.getGender());

	}

	}
}
