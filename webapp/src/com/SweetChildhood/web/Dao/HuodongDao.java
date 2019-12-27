package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.HuodongBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class HuodongDao {
	public static ArrayList<HuodongBean> huodongDao(String username,String classes) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from huodong where sid = "+username+" and cid = "+classes;
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<HuodongBean> list = new ArrayList<HuodongBean>();
			while(rs.next()) {
				HuodongBean huodongBean = new HuodongBean();
				huodongBean.setChengguo(rs.getString("chengguo"));
				huodongBean.setCid(rs.getString("cid"));
				huodongBean.setId(Integer.parseInt(rs.getString("id")));
				huodongBean.setPingjia(rs.getString("pingjia"));
				huodongBean.setShixiang(rs.getString("shixiang"));
				huodongBean.setSid(rs.getString("sid"));
				huodongBean.setTeacher(rs.getString("teacher"));
				huodongBean.setTime(rs.getString("time"));
				huodongBean.setZid(rs.getString("zid"));
				list.add(huodongBean);
			}
			return list;
		}
		return null;
	}
	public static int SetHuodongDao(ArrayList<HuodongBean> list) throws Exception{
		int i = 0;
		String chengguo = null;
		String cid = null;
		String pingjia = null;
		String shixiang = null;
		String sid = null;
		String teacher = null;
		String time = null;
		String zid = null;
		for(HuodongBean huodongBean :list)
		{
			chengguo = huodongBean.getChengguo();
			cid = huodongBean.getCid();
			pingjia = huodongBean.getPingjia();
			shixiang = huodongBean.getShixiang();
			sid = huodongBean.getSid();
			teacher = huodongBean.getTeacher();
			time = huodongBean.getTeacher();
			zid = huodongBean.getZid();
		}
		String sql = "insert into huodong (chengguo,cid,pingjia,shixiang,siid,teacher,time,zid) "
				+ "values ('"+chengguo+"','"+cid+"','"+pingjia+"','"+shixiang+"','"+sid+"','"+teacher+"','"+time+"','"+zid+"')";
		i = Driver.up(sql);
		return i;
	}
}
