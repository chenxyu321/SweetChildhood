package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.FankuiBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class FankuiDao {
	public static ArrayList<FankuiBean> fankuiDao(String username) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from fankui where sid = "+username+" order by id desc";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<FankuiBean> list = new ArrayList<FankuiBean>();
			while (rs.next()) {
				FankuiBean fankuiBean = new FankuiBean();
				fankuiBean.setId(Integer.parseInt(rs.getString("id")));
				fankuiBean.setClasses(rs.getString("classes"));
				fankuiBean.setSid(rs.getString("sid"));
				fankuiBean.setTeacher(rs.getString("teacher"));
				fankuiBean.setText(rs.getString("text"));
				fankuiBean.setTime(rs.getString("time"));		
				list.add(fankuiBean);
			}
			return list;
		}
		return null;
	}
}
