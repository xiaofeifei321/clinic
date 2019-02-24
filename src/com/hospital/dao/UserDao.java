package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.User;

public class UserDao {
	public int Insert(String username, String password, String sex,
			String name, String phone,String iden) {
		String sql = "insert into user(username,password,sex,name,phone,iden) values('"
				+ username
				+ "','"
				+ password
				+ "','"
				+ sex
				+ "','"
				+ name
				+ "','" + phone +"','" + iden + "')";
		return DbHelper.executeSql(sql);
	}

	public int upda(String password, String sex, String name, String phone,
			int uid) {
		String sql = "update user set password='" + password + "',sex='" + sex
				+ "',name='" + name + "',phone='" + phone + "' where uid='"
				+ uid + "'";
		return DbHelper.executeSql(sql);
	}
	public int dele(int uid) {
		return DbHelper.executeSql("delete from user where uid='"+uid+"'");
	}

	public int add(int uid, int money) {
		String sql = "update user set money='" + money + "' where uid='" + uid
				+ "'";
		return DbHelper.executeSql(sql);

	}

	public User checkUserPass(String username, String password) {
		String sql = "select * from user where username='" + username
				+ "' and password='" + password + "'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		User us = new User();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					us.setUid(rs.getInt("uid"));
					us.setMoney(rs.getInt("money"));
					us.setName(rs.getString("name"));
					us.setSex(rs.getString("sex"));
					us.setPhone(rs.getString("phone"));
					us.setUsername(rs.getString("username"));
					us.setPassword(rs.getString("password"));
				}
		} catch (Exception e) {
		}
		return us;
	}
	
	public User checkUserPassAdmin(String username, String password) {
		String sql = "select * from admin where username='" + username
				+ "' and password='" + password + "'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		User us = new User();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					us.setUid(rs.getInt("uid"));
					us.setMoney(rs.getInt("money"));
					us.setName(rs.getString("name"));
					us.setSex(rs.getString("sex"));
					us.setPhone(rs.getString("phone"));
					us.setUsername(rs.getString("username"));
					us.setPassword(rs.getString("password"));
				}
		} catch (Exception e) {
		}
		return us;
	}
	
	public User checkUserPass2(String username, String password) {
		String sql = "select * from admin where username='" + username
				+ "' and password='" + password + "'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		User us = new User();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					us.setUid(rs.getInt("uid"));
					us.setMoney(rs.getInt("money"));
					us.setName(rs.getString("name"));
					us.setSex(rs.getString("sex"));
					us.setPhone(rs.getString("phone"));
					us.setUsername(rs.getString("username"));
					us.setPassword(rs.getString("password"));
				}
		} catch (Exception e) {
		}
		return us;
	}
	public boolean checkIden(String iden) {
		String sql = "select * from user where iden='" + iden
		+ "'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		User us = new User();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					us.setUid(rs.getInt("uid"));
					us.setMoney(rs.getInt("money"));
					us.setName(rs.getString("name"));
					us.setSex(rs.getString("sex"));
					us.setPhone(rs.getString("phone"));
					us.setUsername(rs.getString("username"));
					us.setPassword(rs.getString("password"));
				}
		} catch (Exception e) {
		}
		if(us.getUid()>0){
			return true;
		}else{
			return false;
		}
	}

	public List<User> getalluser(int uid) {
		String sql = "select * from user where uid='" + uid + "'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					User us = new User();
					us.setUid(rs.getInt("uid"));
					us.setMoney(rs.getInt("money"));
					us.setName(rs.getString("name"));
					us.setIden(rs.getString("iden"));
					us.setSex(rs.getString("sex"));
					us.setPhone(rs.getString("phone"));
					us.setUsername(rs.getString("username"));
					us.setPassword(rs.getString("password"));
					list.add(us);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public List<User> getall() {
		String sql = "select * from user";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					User us = new User();
					us.setUid(rs.getInt("uid"));
					us.setMoney(rs.getInt("money"));
					us.setName(rs.getString("name"));
					us.setSex(rs.getString("sex"));
					us.setPhone(rs.getString("phone"));
					us.setUsername(rs.getString("username"));
					us.setPassword(rs.getString("password"));
					list.add(us);
				}
		} catch (Exception e) {
		}
		return list;
	}

}
