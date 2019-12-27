package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.KetangbiaoxianBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class KetangbiaoxianDao {
	public static ArrayList<KetangbiaoxianBean> ketangbiaoxianDao(String username,String classes) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql = "select * from ketangbiaoxian where sid = "+username+" and cid = "+classes;
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<KetangbiaoxianBean> list = new ArrayList<KetangbiaoxianBean>();
			while(rs.next()) {
				KetangbiaoxianBean ketangbiaoxianBean = new KetangbiaoxianBean();
				ketangbiaoxianBean.setBiaoxian(rs.getString("biaoxian"));
				ketangbiaoxianBean.setCid(rs.getString("cid"));
				ketangbiaoxianBean.setId(Integer.parseInt(rs.getString("id")));
				ketangbiaoxianBean.setJihua(rs.getString("jihua"));
				ketangbiaoxianBean.setJilv(rs.getString("jilv"));
				ketangbiaoxianBean.setSid(rs.getString("sid"));
				ketangbiaoxianBean.setTeacher(rs.getString("teacher"));
				ketangbiaoxianBean.setText1(rs.getString("text1"));
				ketangbiaoxianBean.setText2(rs.getString("text2"));
				ketangbiaoxianBean.setText3(rs.getString("text3"));
				ketangbiaoxianBean.setTime(rs.getString("time"));
				ketangbiaoxianBean.setZhanxiannum(rs.getString("zhanxiannum"));
				ketangbiaoxianBean.setZid(rs.getString("zid"));
				list.add(ketangbiaoxianBean);				
			}
			return list;
		}
		return null;
	}
	public static int  SetKetangbiaoxianDao(ArrayList<KetangbiaoxianBean> list) throws Exception{
		int i = 0;
		String biaoxian = null;
		String cid = null;
		String jihua = null;
		String jilv = null;
		String sid = null;
		String teacher = null;
		String text1 = null;
		String text2 = null;
		String text3 = null;
		String time = null;
		String zhanxiannum = null;
		String zid = null;
		for(KetangbiaoxianBean ketangbiaoxianBean : list)
		{
			biaoxian = ketangbiaoxianBean.getBiaoxian();
			cid = ketangbiaoxianBean.getCid();
			jihua = ketangbiaoxianBean.getJihua();
			jilv = ketangbiaoxianBean.getJilv();
			sid = ketangbiaoxianBean.getSid();
			teacher = ketangbiaoxianBean.getTeacher();
			text1 = ketangbiaoxianBean.getText1();
			text2 = ketangbiaoxianBean.getText2();
			text3 = ketangbiaoxianBean.getText3();
			time = ketangbiaoxianBean.getTime();
			zhanxiannum = ketangbiaoxianBean.getZhanxiannum();
			zid = ketangbiaoxianBean.getZid();
		}
		String sql = "insert into ketangbiaoxian (biaoxian,cid,jihua,jilv,sid,teacher,text1,text2,text3,time,zhanxiannum,zid) "
				+ "values ('"+biaoxian+"','"+cid+"','"+jihua+"','"+jilv+"','"+sid+"','"+teacher+"','"+text1+"','"+text2+"','"+text3
				+"','"+time+"','"+zhanxiannum+"','"+zid+"')";
		i = Driver.up(sql);
		return i;
	}
	
}
