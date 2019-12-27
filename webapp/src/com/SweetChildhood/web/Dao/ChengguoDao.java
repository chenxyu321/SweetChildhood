package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ChengguoBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class ChengguoDao {
	public static ArrayList<ChengguoBean> chenggguoDao(String username) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from chengguo where sid = "+username;
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<ChengguoBean> list= new ArrayList<ChengguoBean>();
			while (rs.next()) {
				ChengguoBean chengguoBean = new ChengguoBean();
				chengguoBean.setId(Integer.parseInt(rs.getString("id")));
				chengguoBean.setSid(rs.getString("sid"));
				chengguoBean.setText(rs.getString("text"));
				chengguoBean.setTime(rs.getString("time"));
				list.add(chengguoBean);
			}
			return list;
		}
		return null;
	}
	public static ArrayList<ChengguoBean> chenggguoDao(int id) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from chengguo where id = "+id;
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<ChengguoBean> list= new ArrayList<ChengguoBean>();
			while (rs.next()) {
				ChengguoBean chengguoBean = new ChengguoBean();
				chengguoBean.setId(Integer.parseInt(rs.getString("id")));
				chengguoBean.setSid(rs.getString("sid"));
				chengguoBean.setText(rs.getString("text"));
				chengguoBean.setTime(rs.getString("time"));
				list.add(chengguoBean);
			}
			return list;
		}
		return null;
	}
}
