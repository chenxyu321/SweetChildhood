package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.SystongzhiBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class SystongzhiDao {
	public static ArrayList<SystongzhiBean> systongzhiDao() throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from systongzhi where active = 1";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<SystongzhiBean> list = new ArrayList<SystongzhiBean>();
			while (rs.next()) {
				SystongzhiBean systongzhiBean = new SystongzhiBean();
				systongzhiBean.setId(Integer.parseInt(rs.getString("id")));
				systongzhiBean.setActive(Integer.parseInt(rs.getString("active")));
				systongzhiBean.setText(rs.getString("text"));
				systongzhiBean.setTime(rs.getString("time"));
				list.add(systongzhiBean);
			}
			return list;
		}
		return null;
	}
}
