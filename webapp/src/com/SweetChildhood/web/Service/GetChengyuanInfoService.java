package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ChengyuanBean;
import com.SweetChildhood.web.Dao.ChengyuanDao;

public class GetChengyuanInfoService {
	public static ArrayList<ChengyuanBean> getChengyuanInfoService(String username) throws Exception{
		ArrayList<ChengyuanBean> list = ChengyuanDao.chengyuanDao(username);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
