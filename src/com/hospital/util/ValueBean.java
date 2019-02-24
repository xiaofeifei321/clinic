package com.hospital.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hospital.db.DbHelper;

public class ValueBean {

	public static String UserName(String id) {
		String name="";
		String sql = "select * from user where uid="+id;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DbHelper.getconnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null)
				if (rs.next()) {
					name=rs.getString("name");
				}
		} catch (Exception e) {
		}
		return name;
	}
}
