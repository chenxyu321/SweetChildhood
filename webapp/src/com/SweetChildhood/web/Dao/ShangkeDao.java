package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ShangkeBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class ShangkeDao {
 public static ArrayList<ShangkeBean> shangkeDao(String username) throws Exception{
	 Statement statement = Driver.getStatement();
	 if (statement!=null) {
		String sql ="select * from shangke where sid = "+username+" order by id desc";
		ResultSet rs = statement.executeQuery(sql);
		ArrayList<ShangkeBean> list = new ArrayList<ShangkeBean>();
		while(rs.next()) {
			ShangkeBean shangkeBean = new ShangkeBean();
			shangkeBean.setClasses(rs.getString("classes"));
			shangkeBean.setId(Integer.parseInt(rs.getString("id")));
			shangkeBean.setSid(rs.getString("sid"));
			shangkeBean.setTeacher(rs.getString("teacher"));
			shangkeBean.setTime(rs.getString("time"));
			list.add(shangkeBean);
		}
		return list;
	}
	 return null;
 }
}
