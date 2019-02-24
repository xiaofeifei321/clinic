package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.Lianxi;

public class LianxiDao {
	public int Add(int uid,String name,String phone) {
		return DbHelper.executeSql("insert into lianxi(uid,name,phone) values('"+uid+"','"+name+"','"+phone+"')");
	}
	public int dele(int lid) {
		return DbHelper.executeSql("delete from lianxi where lid='"+lid+"'");
	}
	
	public List<Lianxi> getalllianxi(int uid) {
		String sql = "select * from lianxi where uid='"+uid+"'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Lianxi> list = new ArrayList<Lianxi>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Lianxi lianxi = new Lianxi();
					lianxi.setLid(rs.getInt("lid"));
					lianxi.setName(rs.getString("name"));
					lianxi.setPhone(rs.getString("phone"));
					lianxi.setUid(rs.getInt("uid"));
					list.add(lianxi);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public List<Lianxi> getall() {
		String sql = "select * from lianxi";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Lianxi> list = new ArrayList<Lianxi>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Lianxi lianxi = new Lianxi();
					lianxi.setLid(rs.getInt("lid"));
					lianxi.setName(rs.getString("name"));
					lianxi.setPhone(rs.getString("phone"));
					lianxi.setUid(rs.getInt("uid"));
					list.add(lianxi);
				}
		} catch (Exception e) {
		}
		return list;
	}
}
