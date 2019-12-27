package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ChengyuanBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class ChengyuanDao {
	public static ArrayList<ChengyuanBean> chengyuanDao(String username) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from chengyuan where sid = "+username;
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<ChengyuanBean> list = new ArrayList<ChengyuanBean>();
			while(rs.next()) {
				ChengyuanBean chengyuanBean = new ChengyuanBean();
				chengyuanBean.setDanwei(rs.getString("danwei"));
				chengyuanBean.setGuanxi(rs.getString("guanxi"));
				chengyuanBean.setId(Integer.parseInt(rs.getString("id")));
				chengyuanBean.setName(rs.getString("name"));
				chengyuanBean.setSid(rs.getString("sid"));
				chengyuanBean.setTel(rs.getString("tel"));
				list.add(chengyuanBean);
			}
			return list;
		}
		return null;
	}
	public static int setChengyuanDao(ArrayList<ChengyuanBean> list) throws Exception{
		int i=0;
		int s=0;
		for (ChengyuanBean chengyuanBean:list) {
			String danwei = chengyuanBean.getDanwei();
			String guanxi = chengyuanBean.getGuanxi();
			String name = chengyuanBean.getName();
			String sid = chengyuanBean.getSid();
			String tel = chengyuanBean.getTel();
			String sql = "insert into chengyuan (danwei,guanxi,name,sid,tel) "
					+ "values ('"+danwei+"','"+guanxi+"','"+name+"','"+sid+"','"+tel+"')";
			i = Driver.up(sql);
			s+=i;
		}
		return s;
	}
}
