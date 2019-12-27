package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.CanSaiBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class CansaiDao {
	public static ArrayList<CanSaiBean> cansaiDao(String username) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from cansai where sid = "+username+" order by id desc";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<CanSaiBean> list = new ArrayList<CanSaiBean>();
			while(rs.next()) {
				CanSaiBean canSaiBean = new CanSaiBean();
				canSaiBean.setId(Integer.parseInt(rs.getString("id")));
				canSaiBean.setMatchname(rs.getString("matchname"));
				canSaiBean.setSid(rs.getString("sid"));
				canSaiBean.setTime(rs.getString("time"));
				list.add(canSaiBean);
			}
			return list;
		}
		return null;
	}
}
