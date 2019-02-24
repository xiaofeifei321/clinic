package com.hospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.db.DbHelper;
import com.hospital.util.Lianxi;
import com.hospital.util.Tousu;

public class TousuDao {
	public int Add(String username,String doc_name,String doc_office) {
		return DbHelper.executeSql("insert into tousu(username,doc_name,doc_office) values('"+username+"','"+doc_name+"','"+doc_office+"')");
	}
	public int dele(int lid) {
		return DbHelper.executeSql("delete from tousu where id='"+lid+"'");
	}
	
	public List<Tousu> getall() {
		String sql = "select * from tousu";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Tousu> list = new ArrayList<Tousu>();
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				while (rs.next()) {
					Tousu tousu = new Tousu();
					tousu.setId(rs.getInt("id"));
					tousu.setUsername(rs.getString("username"));
					tousu.setDoc_name(rs.getString("doc_name"));
					tousu.setDoc_office(rs.getString("doc_office"));
					list.add(tousu);
				}
		} catch (Exception e) {
		}
		return list;
	}
}
