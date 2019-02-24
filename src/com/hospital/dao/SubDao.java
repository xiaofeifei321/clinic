package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.Office;
import com.hospital.util.Ques;

public class SubDao {
	public int update(int uid,int oid) {
		return DbHelper.executeSql("update sub set buy=1 where uid='"+uid+"' and oid='"+oid+"'");
	}
	public int add(int uid,int oid) {
		return DbHelper.executeSql("insert into sub(uid,oid,buy) values('"+uid+"','"+oid+"','0')");
	}
	
	public int find(int oid) {
		
		String sql = "select count(1) as c from  sub where oid='"+oid+"'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int num=0;
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					num=rs.getInt("c");
				}
		} catch (Exception e) {
		}
		return num;
	}
	
	public List<Office> getallte(int uid) {
		String sql = "SELECT * FROM office WHERE oid IN(SELECT oid FROM sub WHERE uid ='"+uid+"'AND	buy =0)";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Office> list = new ArrayList<Office>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Office office = new Office();
					office.setContent(rs.getString("content"));
					office.setDocname(rs.getString("docname"));
					office.setNeed(rs.getInt("need"));
					office.setOid(rs.getInt("oid"));
					office.setOname(rs.getString("oname"));
					office.setPhone(rs.getString("phone"));
					list.add(office);
				}
		} catch (Exception e) {
		}
		return list;
	}
	
	public List<Ques> getallsub() {
		String sql = "SELECT o.docname as content,u.name as name FROM sub s,office o,user u WHERE u.uid=s.uid and o.oid=s.oid ";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Ques> list = new ArrayList<Ques>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Ques office = new Ques();
					office.setContent(rs.getString("content"));
					office.setName(rs.getString("name"));
					list.add(office);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public List<Office> getallyi(int uid) {
		String sql = "SELECT * FROM office WHERE oid IN(SELECT oid FROM sub WHERE uid ='"+uid+"'AND	buy =1)";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Office> list = new ArrayList<Office>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Office office = new Office();
					office.setContent(rs.getString("content"));
					office.setDocname(rs.getString("docname"));
					office.setNeed(rs.getInt("need"));
					office.setOid(rs.getInt("oid"));
					office.setOname(rs.getString("oname"));
					office.setPhone(rs.getString("phone"));
					list.add(office);
				}
		} catch (Exception e) {
		}
		return list;
	}
}
