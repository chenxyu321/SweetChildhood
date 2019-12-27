package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ChengguophotoBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class ChengguophotoDao {
	public static ArrayList<ChengguophotoBean> chengguophotoDao(String chengguoid) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql="select * from chengguophoto where chengguoid = "+chengguoid;
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<ChengguophotoBean> list = new ArrayList<ChengguophotoBean>();
			while (rs.next()) {
				ChengguophotoBean chengguophotoBean = new ChengguophotoBean();
				chengguophotoBean.setChengguoid(rs.getString("chengguoid"));
				chengguophotoBean.setId(Integer.parseInt(rs.getString("id")));
				chengguophotoBean.setPhotopath(rs.getString("photopath"));
				list.add(chengguophotoBean);
			}
			return list;
		}
		return null;
	}
}
