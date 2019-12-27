package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.SweetChildhood.web.Bean.PictureBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class PictureDao {
	public static ArrayList<PictureBean> pictureDao() throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql="select * from picture";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<PictureBean> list = new ArrayList<PictureBean>();
			while (rs.next()) {
				PictureBean pictureBean = new PictureBean();
				pictureBean.setPicid(Integer.parseInt(rs.getString("picid")));
				pictureBean.setPictext(rs.getString("pictext"));
				pictureBean.setPicpath(rs.getString("picpath"));
				list.add(pictureBean);
			}
			return list;
		}
	
	return null;
	}
}
