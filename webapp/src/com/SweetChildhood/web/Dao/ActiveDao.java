package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.SweetChildhood.web.Bean.ActiveBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class ActiveDao {
	public static ArrayList<ActiveBean> activeDao() throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from active where open = 1";
			ResultSet rs= statement.executeQuery(sql);
			ArrayList<ActiveBean> list = new ArrayList<ActiveBean>();
			while (rs.next()) {
			ActiveBean activeBean = new ActiveBean();
			activeBean.setId(Integer.parseInt(rs.getString("id")));
			activeBean.setAddress(rs.getString("address"));
			activeBean.setText(rs.getString("text"));
			activeBean.setOpen(Integer.parseInt(rs.getString("open")));
			activeBean.setTime(rs.getString("time"));
			activeBean.setTitle(rs.getString("title"));
			list.add(activeBean);
			}
			return list;
		}
		return null;
	}
}
