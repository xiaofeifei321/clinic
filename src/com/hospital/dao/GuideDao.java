package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.Guide;


public class GuideDao {
	public int add(String menzhen,String zhuyuan,String tijian) {
		return DbHelper.executeSql("insert into guide(menzhen,zhuyuan,tijian) values('"+menzhen+"','"+zhuyuan+"','"+tijian+"')");
		
	}
	public int dele(int gid) {
		return DbHelper.executeSql("delete from guide where gid='"+gid+"'");
	}
	public int xinashi(int gid) {
		String sql = "select * from guide where pd='1'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Guide> list = new ArrayList<Guide>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Guide guide = new Guide();
					guide.setGid(rs.getInt("gid"));
					guide.setMenzhen(rs.getString("menzhen"));
					guide.setPd(rs.getInt("pd"));
					guide.setTijian(rs.getString("tijian"));
					guide.setZhuyuan(rs.getString("zhuyuan"));
					list.add(guide);
				}
		} catch (Exception e) {
		}
		DbHelper.executeSql("update guide set pd=0 where gid='"+list.get(0).getGid()+"' ");
		return DbHelper.executeSql("update guide set pd=1 where gid='"+gid+"' ");
	
	}
	
	public List<Guide> getallte() {
		String sql = "select * from guide where pd='1'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Guide> list = new ArrayList<Guide>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Guide guide = new Guide();
					guide.setGid(rs.getInt("gid"));
					guide.setMenzhen(rs.getString("menzhen"));
					guide.setPd(rs.getInt("pd"));
					guide.setTijian(rs.getString("tijian"));
					guide.setZhuyuan(rs.getString("zhuyuan"));
					list.add(guide);
				}
		} catch (Exception e) {
		}
		return list;
	}
	public List<Guide> getall() {
		String sql = "select * from guide";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Guide> list = new ArrayList<Guide>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Guide guide = new Guide();
					guide.setGid(rs.getInt("gid"));
					guide.setMenzhen(rs.getString("menzhen"));
					guide.setPd(rs.getInt("pd"));
					guide.setTijian(rs.getString("tijian"));
					guide.setZhuyuan(rs.getString("zhuyuan"));
					list.add(guide);
				}
		} catch (Exception e) {
		}
		return list;
	}
}
