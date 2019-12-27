package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.SweetChildhood.web.Bean.ParentfankuiBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class ParentfankuiDao {
	public static ArrayList<ParentfankuiBean> parentfankuiDao() throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from parentfankui order by id desc";
			ArrayList<ParentfankuiBean> list = new ArrayList<ParentfankuiBean>();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ParentfankuiBean parentfankuiBean = new ParentfankuiBean();
				parentfankuiBean.setId(Integer.parseInt(rs.getString("id")));
				parentfankuiBean.setSid(rs.getString("sid"));
				parentfankuiBean.setText(rs.getString("text"));
				parentfankuiBean.setTime(rs.getString("time"));
				list.add(parentfankuiBean);
			}
			return list;
		}
		return null;
	}
	public static int setParentfankuiDao(ArrayList<ParentfankuiBean> list) throws Exception{
		String sid;
		String text;
		String time;
		int i = 0;
		sid = list.get(0).getSid();
		text = list.get(0).getText();
		time = list.get(0).getTime();
		String sql = "insert into parentfankui (sid,text,time) values ('"+sid+"','"+text+"','"+time+"')";
		i = Driver.up(sql);
		return i;
	}
}
