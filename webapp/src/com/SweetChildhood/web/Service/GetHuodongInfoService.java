package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.HuodongBean;
import com.SweetChildhood.web.Dao.HuodongDao;

public class GetHuodongInfoService {
	public static ArrayList<HuodongBean> getHuodongInfoService(String username,String classes) throws Exception{
		ArrayList<HuodongBean> list = HuodongDao.huodongDao(username, classes);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
