package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.SmininfoBean;
import com.SweetChildhood.web.Dao.SmininfoDao;

public class GetSmininfoService {
	public static ArrayList<SmininfoBean> getSmininfoService(String username) throws Exception{
		
		ArrayList<SmininfoBean> list = SmininfoDao.smininfoDao(username);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
