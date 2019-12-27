package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ShangkeBean;
import com.SweetChildhood.web.Dao.ShangkeDao;

public class GetShangkeInfoService {
	public static ArrayList<ShangkeBean> getShangkeInfoService(String username) throws Exception{
		ArrayList<ShangkeBean> list = ShangkeDao.shangkeDao(username);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
