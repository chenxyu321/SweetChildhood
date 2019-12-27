package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ZuoyeBean;
import com.SweetChildhood.web.Dao.ZuoyeDao;

public class GetZuoyeInfoService {
	public static ArrayList<ZuoyeBean> getZuoyeInfoService(String username) throws Exception{
		ArrayList<ZuoyeBean> list = ZuoyeDao.zuoyeDao(username);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
