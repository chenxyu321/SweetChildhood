package com.SweetChildhood.web.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.SweetChildhood.web.Bean.*;
import com.SweetChildhood.web.DbUtil.Driver;
public class ReturnDao {
	public static ArrayList<ReturnBean> returnDao() throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
		String sql="select * from `return`";
		ArrayList<ReturnBean> list = new ArrayList<ReturnBean>();
		ResultSet rs;
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				ReturnBean returnBean = new ReturnBean();
				returnBean.setId(Integer.parseInt(rs.getString("id"))); 
				returnBean.setClasses(rs.getString("classes")); 
				returnBean.setProple(rs.getString("people")); 
				returnBean.setText(rs.getString("text"));
				list.add(returnBean);	
				}
			return list;
		}
			return null;
	}
//	public static void main(String[] args) {
//		Driver.getStatement();
//	}
}
