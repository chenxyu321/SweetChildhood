package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.SweetChildhood.web.Bean.NewsBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class NewsDao {
	public static ArrayList<NewsBean> newsDao() throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql="select * from news limit 0, 3";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<NewsBean> list = new ArrayList<NewsBean>();
			NewsBean newsBean = new NewsBean();
			while (rs.next()) {
				newsBean.setId(Integer.parseInt(rs.getString("id")));
				newsBean.setMintext(rs.getString("mintext"));
				newsBean.setPeople(rs.getString("people"));
				newsBean.setPicpath(rs.getString("picpath"));
				newsBean.setText(rs.getString("text"));
				newsBean.setTitle(rs.getString("title"));
				newsBean.setTime(rs.getString("time"));
				list.add(newsBean);
			}
			return list;
		}
		return null;
	}
	public static ArrayList<NewsBean> newsDao(int id) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql="select * from news where id="+id;
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<NewsBean> list = new ArrayList<NewsBean>();
			while (rs.next()) {
				NewsBean newsBean = new NewsBean();
				newsBean.setId(Integer.parseInt(rs.getString("id")));
				newsBean.setMintext(rs.getString("mintext"));
				newsBean.setPeople(rs.getString("people"));
				newsBean.setPicpath(rs.getString("picpath"));
				newsBean.setText(rs.getString("text"));
				newsBean.setTitle(rs.getString("title"));
				newsBean.setTime(rs.getString("time"));
				list.add(newsBean);
			}
			return list;
		}
		return null;
	}
}
