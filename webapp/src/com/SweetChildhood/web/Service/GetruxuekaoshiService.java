package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.RuxuetestBean;
import com.SweetChildhood.web.Dao.RuxuetestDao;

public class GetruxuekaoshiService {
	public static ArrayList<RuxuetestBean> getruxuekaoshiService(String username,int id) throws Exception{
		ArrayList<RuxuetestBean> list = new ArrayList<RuxuetestBean>();
		list = RuxuetestDao.ruxuetestDao(username, String.valueOf(id));
		if (list!=null) {
			return list;
		}
		return null;
		
	}
}
