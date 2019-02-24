package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.Office;

public class OfficeDao {
	//String oname,docname,content,phone,ontime;
	public int add( String oname,String docname,String content,String phone,String ontime,int need) {
		return DbHelper.executeSql("insert into office(oname,docname,content,phone,ontime,need) values('"+oname+"','"+docname+"','"+content+"','"+phone+"','"+ontime+"',"+need+")");
		
	}
	public int update(int oid, String oname,String docname,String content,String phone,String ontime,int need) {
		return DbHelper.executeSql("update office set oname ='"+oname+"',docname='"+docname+"',content='"+content+"',phone='"+phone+"',ontime='"+ontime+"',need="+need+" where oid="+oid);
		
	}
	public int delete(int oid) {
		return DbHelper.executeSql("delete from office where oid='"+oid+"'");
	}
	public List<Office> getallte() {
		String sql = "select * from office ";
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
					office.setOntime(rs.getString("ontime"));
					list.add(office);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public List<Office> getone(int oid) {
		String sql = "select * from office where oid='"+oid+"'";
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
					office.setOntime(rs.getString("ontime"));
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
	public List<Office> getsousuo(String sousuo) {
		String sql = "select * from office where oname like '%"+sousuo+"%' or docname like '%"+sousuo+"%'";
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
					office.setOntime(rs.getString("ontime"));
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
