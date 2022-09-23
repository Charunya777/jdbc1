package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;
import com.ty.dto.User;

public class UserDao {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String user="root";
	String password="root";
	Connection connection=null;
	public String insertUser(User u) {
		String query="insert into user Values(?,?,?,?,?,?,?)";
		try {
	Class.forName(path);
	connection=DriverManager.getConnection(url,user,password);
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	preparedStatement.setString(1, u.getFirstname());
	preparedStatement.setString(2,u.getLastname());
	preparedStatement.setString(3, u.getEmail());
	preparedStatement.setString(4, u.getPassword());
	preparedStatement.setLong(5, u.getPhone());
	preparedStatement.setString(6, u.getDateofbirth());
	preparedStatement.setString(7, u.getGender());
	
	
	int a=preparedStatement.executeUpdate();
	if (a==1) {
		return "saved";
	}
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
finally {
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

return "not saved";
}
	public String updateUser(User u)
	{
		String query="update user set lastname=?,email=?,password=?,phone=?,dateofbirth=?,gender=? where firstname=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(7, u.getFirstname());
			preparedStatement.setString(1,u.getLastname());
			preparedStatement.setString(2, u.getEmail());
			preparedStatement.setString(3, u.getPassword());
			preparedStatement.setLong(4, u.getPhone());
			preparedStatement.setString(5, u.getDateofbirth());
			preparedStatement.setString(6, u.getGender());
			int a=preparedStatement.executeUpdate();
			if (a==1) {
				return "updated";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "not updated";
	}
	public String deleteuser(String firstname)
	{
		String query="delete from  where firstname=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, firstname);
			int a=preparedStatement.executeUpdate();
			if (a==1) {
				return "deleted";
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "not deleted";
	}
	public User getUser(String firstname) {
		String query="select * from user where firstname=?";
		ResultSet resultSet=null;
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareCall(query);
			preparedStatement.setString(1, firstname);
			 resultSet=preparedStatement.executeQuery();
			 if(resultSet!=null)
				 while(resultSet.next()) {
					 User u= new User();
					 u.setFirstname(resultSet.getString(1));
					 u.setLastname(resultSet.getString(2));
					 u.setEmail(resultSet.getString(3));
					 u.setPassword(resultSet.getString(4));
					 u.setPhone(resultSet.getLong(5));
					 u.setDateofbirth(resultSet.getString(6));
					 u.setGender(resultSet.getString(7));
					 return u;
					 }
			 
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
	public List<User> getAllUser(){
		String query="select * from user";
		ResultSet resultSet= null;
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareCall(query);
			
			 resultSet=preparedStatement.executeQuery();
			 if(resultSet!=null)
			 {
				 List<User> list= new ArrayList<User>();
				 while(resultSet.next()) {
					 User u= new User();
					 u.setFirstname(resultSet.getString(1));
					 u.setLastname(resultSet.getString(2));
					 u.setEmail(resultSet.getString(3));
					 u.setPassword(resultSet.getString(4));
					 u.setPhone(resultSet.getLong(5));
					 u.setDateofbirth(resultSet.getString(6));
					 u.setGender(resultSet.getString(7));
					 list.add(u);
					
				 } 
				 return list;
				 }
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	public User getUserByEmailAndPassword(String email,String password) {
		String query="select * from user where email=? and password=? ";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,this.password);
			PreparedStatement preparedStatement=connection.prepareCall(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				User user=new User();
				user.setFirstname(resultset.getString(1));
				user.setLastname(resultset.getString(2));
				user.setEmail(resultset.getString("email"));
				user.setPassword(resultset.getString("password"));
				user.setPhone(resultset.getLong("phone"));
				user.setDateofbirth(resultset.getString("dateofbirth"));
				user.setGender(resultset.getString("gender"));
				return user;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
		}
	}

