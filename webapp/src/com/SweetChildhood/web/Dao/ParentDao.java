package com.SweetChildhood.web.Dao;
import java.sql.ResultSet;
import java.sql.Statement;

import com.SweetChildhood.web.DbUtil.Driver;

public class ParentDao {
	public static Boolean parentDao(String username,String userpass) throws Exception{
		String sql="select * from parent where id="+username;
		boolean bo=false;
		bo = Driver.se(sql,userpass);
		return bo;
	}
	public static int upPassDao(String username,String userpass) throws Exception{
		int i = 0;
		String sql="update parent set pass = "+userpass+" where id = "+username;
		i = Driver.up(sql);
		return i;
	}
	public static String getPassDao(String username) throws Exception{
		String userpass = null;
		String sql = "select pass from parent where id = '"+username+"'";
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				userpass = rs.getString("pass");
			}					
		}
		return userpass;
	}
}
