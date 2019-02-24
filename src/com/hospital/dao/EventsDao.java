package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.Events;
import com.hospital.util.Office;

public class EventsDao {
	//String oname,docname,content,phone,ontime;
	public int add( String mname,String mpic,String mcontent,String mtype,String mtime,String username) {
		return DbHelper.executeSql("insert into events(mname,mpic,mcontent,mtype,mtime,username) values('"+mname+"','"+mpic+"','"+mcontent+"','"+mtype+"','"+mtime+"','"+username+"')");
		
	}
	public int update(int mid, String mname,String mpic,String mcontent,String mtype,String username) {
		return DbHelper.executeSql("update events set mname ='"+mname+"',mpic='"+mpic+"',mcontent='"+mcontent+"',mtype='"+mtype+"',username='"+username+"' where mid="+mid);
		
	}
	public int delete(int mid) {
		return DbHelper.executeSql("delete from events where mid='"+mid+"'");
	}
	public List<Events> getallte() {
		String sql = "select * from events ";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Events> list = new ArrayList<Events>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Events o = new Events();
					o.setMcontent(rs.getString("mcontent"));
					o.setMid(rs.getInt("mid"));
					o.setMname(rs.getString("mname"));
					o.setMpic(rs.getString("mpic"));
					o.setMtime(rs.getString("mtime"));
					o.setMtype(rs.getString("mtype"));
					o.setUsername(rs.getString("username"));
					list.add(o);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public List<Events> getbytype(String mtype) {
		String sql = "select * from events where mtype ='"+mtype+"'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Events> list = new ArrayList<Events>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Events o = new Events();
					o.setMcontent(rs.getString("mcontent"));
					o.setMid(rs.getInt("mid"));
					o.setMname(rs.getString("mname"));
					o.setMpic(rs.getString("mpic"));
					o.setMtime(rs.getString("mtime"));
					o.setMtype(rs.getString("mtype"));
					o.setUsername(rs.getString("username"));
					list.add(o);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public Events getone(int mid) {
		String sql = "select * from events where mid='"+mid+"'";
		Connection con = null;
		Statement st = null; 
		ResultSet rs = null;
		Events e = null ;
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					e = new Events();
					e.setMcontent(rs.getString("mcontent"));
					e.setMid(rs.getInt("mid"));
					e.setMname(rs.getString("mname"));
					e.setMpic(rs.getString("mpic"));
					e.setMtime(rs.getString("mtime"));
					e.setMtype(rs.getString("mtype"));
					e.setUsername(rs.getString("username"));
				}
		} catch (Exception err) {
		}
		return e;
	}
	public Events getbyname(String mname) {
		String sql = "select * from events where mname='"+mname+"'";
		Connection con = null;
		Statement st = null; 
		ResultSet rs = null;
		Events e = null ;
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					e = new Events();
					e.setMcontent(rs.getString("mcontent"));
					e.setMid(rs.getInt("mid"));
					e.setMname(rs.getString("mname"));
					e.setMpic(rs.getString("mpic"));
					e.setMtime(rs.getString("mtime"));
					e.setMtype(rs.getString("mtype"));
					e.setUsername(rs.getString("username"));
				}
		} catch (Exception err) {
		}
		return e;
	}
}
