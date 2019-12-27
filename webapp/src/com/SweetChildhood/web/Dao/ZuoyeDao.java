package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.SweetChildhood.web.Bean.ZuoyeBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class ZuoyeDao {
	public static ArrayList<ZuoyeBean> zuoyeDao(String username) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from zuoye where sid = "+username+" order by id desc";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<ZuoyeBean> list = new ArrayList<ZuoyeBean>();
			while (rs.next()) {
				ZuoyeBean zuoyeBean = new ZuoyeBean();
				zuoyeBean.setClasses(rs.getString("classes"));
				zuoyeBean.setId(Integer.parseInt(rs.getString("id")));
				zuoyeBean.setSid(rs.getString("sid"));
				zuoyeBean.setText(rs.getString("text"));
				zuoyeBean.setTime(rs.getString("time"));
				list.add(zuoyeBean);				
			}
			return list;
		}
		return null;
	}
}
