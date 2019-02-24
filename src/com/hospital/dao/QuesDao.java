package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.Events;
import com.hospital.util.Lianxi;
import com.hospital.util.Ques;

public class QuesDao {
	public int Add(int uid,String name,String content) {
		return DbHelper.executeSql("insert into ques(uid,name,content) values('"+uid+"','"+name+"','"+content+"')");
	}
	public int dele(int lid) {
		return DbHelper.executeSql("delete from ques where lid='"+lid+"'");
	}
	
	public List<Ques> getallques(int uid) {
		String sql = "select * from ques where uid='"+uid+"'";
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
					Ques lianxi = new Ques();
					lianxi.setLid(rs.getInt("lid"));
					lianxi.setName(rs.getString("name"));
					lianxi.setReply(rs.getString("reply"));
					lianxi.setContent(rs.getString("content"));
					lianxi.setUid(rs.getInt("uid"));
					list.add(lianxi);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public List<Ques> getall() {
		String sql = "select * from ques";
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
					Ques lianxi = new Ques();
					lianxi.setLid(rs.getInt("lid"));
					lianxi.setName(rs.getString("name"));
					lianxi.setContent(rs.getString("content"));
					lianxi.setReply(rs.getString("reply"));
					lianxi.setUid(rs.getInt("uid"));
					list.add(lianxi);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public int update(int oid, String reply) {
		return DbHelper.executeSql("update ques set reply ='"+reply+"'"+" where lid="+oid);
		
	}
	public Ques getone(int mid) {
		String sql = "select * from ques where lid='"+mid+"'";
		Connection con = null;
		Statement st = null; 
		ResultSet rs = null;
		Ques e = null ;
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					 e = new Ques();
					e.setLid(rs.getInt("lid"));
					e.setName(rs.getString("name"));
					e.setContent(rs.getString("content"));
					e.setReply(rs.getString("reply"));
					e.setUid(rs.getInt("uid"));
				}
		} catch (Exception err) {
		}
		return e;
	}
}
