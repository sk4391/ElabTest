package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.org.beans.LibrarianBean;


public class LibrarianDao {
     
	public static int save(LibrarianBean bean) {
		
		int status = 0;
		
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("insert into elibrarian(id,name,email,password,mobile) values(?,?,?,?,?)");
			ps.setString(1, "1");
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setLong(5, bean.getMobile());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int update(LibrarianBean bean) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("update elibrarian set name=?,email=?,password=?,mobile=? where id=?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setLong(4, bean.getMobile());
			ps.setInt(5, bean.getId());
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<LibrarianBean> view(){
		List<LibrarianBean> list = new ArrayList<LibrarianBean>();
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from elibrarian");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LibrarianBean bean = new LibrarianBean();
				bean.setId(rs.getInt(0));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setMobile(rs.getLong("mobile"));
				list.add(bean);
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		    return list;
	}
	public static LibrarianBean viewById(int id) {
		LibrarianBean bean = new LibrarianBean();
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from elibrarian where id=?");
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return bean;
	}
	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from elibrarian where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean authenticate(String email,String password) {
		boolean status =true;
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from elibrarian where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
