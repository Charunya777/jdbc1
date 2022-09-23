package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;



public class CartDao {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String user="root";
	String password="root";
	Connection connection=null;
	public String insertCartObj(Cart c)  {
		String query="INSERT INTO cart VALUES (?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, c.getId());
			preparedStatement.setString(2,c.getEmail());
			preparedStatement.setString(3, c.getPassword());
			preparedStatement.setString(4, c.getUsername());
			preparedStatement.setString(5, c.getAddress());
			
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
	public String updateCartObj(Cart c)
	{
		String query="update cart set email=?,password=?,username=?,address=? where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, c.getId());
			preparedStatement.setString(2,c.getEmail());
			preparedStatement.setString(3, c.getPassword());
			preparedStatement.setString(4, c.getUsername());
			preparedStatement.setString(5, c.getAddress());
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
	public String deleteCart(int id)
	{
		String query="delete from cart where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
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
	public Cart getCart(int id) {
		String query="select * from cart where id=?";
		ResultSet resultSet=null;
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareCall(query);
			preparedStatement.setInt(1, id);
			 resultSet=preparedStatement.executeQuery();
			 if(resultSet!=null)
				 while(resultSet.next()) {
					 Cart c= new Cart();
					 c.setId(resultSet.getInt(1));
					 c.setEmail(resultSet.getString(2));
					 c.setPassword(resultSet.getString(3));
					 c.setUsername(resultSet.getString(4));
					 c.setAddress(resultSet.getString(5));
					 
					 
					 
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
		public List<Cart> getAllCart(){
			String query="select * from Cart";
			ResultSet resultSet= null;
			try {
				Class.forName(path);
				connection=DriverManager.getConnection(url,user,password);
				PreparedStatement preparedStatement=connection.prepareCall(query);
				
				 resultSet=preparedStatement.executeQuery();
				 if(resultSet!=null)
				 {
					 List<Cart> list= new ArrayList<Cart>();
					 while(resultSet.next()) {
						 Cart c= new Cart();
						 c.setId(resultSet.getInt(1));
						 c.setEmail(resultSet.getString(2));
						 c.setPassword(resultSet.getString(3));
						 c.setUsername(resultSet.getString(4));
						 c.setAddress(resultSet.getString(5));
						 list.add(c);
						 
						 
						 
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
}
