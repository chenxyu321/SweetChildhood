package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ActiveBean;
import com.SweetChildhood.web.Dao.ActiveDao;

public class GetActiveInfoService {
	public static ArrayList<ActiveBean> getActiveInfoService() throws Exception{
		ArrayList<ActiveBean> list = new ArrayList<ActiveBean>();
		list = ActiveDao.activeDao();
		if (list!=null) {
			return list;
		}
		return null;
	}
}
