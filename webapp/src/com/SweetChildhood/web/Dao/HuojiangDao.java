package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.HuojiangBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class HuojiangDao {
	public static ArrayList<HuojiangBean> huojiangDao(String username) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from huojiang where sid = "+username+" order by id desc";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<HuojiangBean> list = new ArrayList<HuojiangBean>();
			while (rs.next()) {
				HuojiangBean huojiangBean = new HuojiangBean();
				huojiangBean.setSid(rs.getString("sid"));
				huojiangBean.setId(Integer.parseInt(rs.getString("id")));
				huojiangBean.setJiangxiang(rs.getString("jiangxiang"));
				huojiangBean.setMatchname(rs.getString("matchname"));
				huojiangBean.setClasses(rs.getString("classes"));
				huojiangBean.setTime(rs.getString("time"));
				list.add(huojiangBean);
			}
			return list;
		}
		return null;
	}
}
