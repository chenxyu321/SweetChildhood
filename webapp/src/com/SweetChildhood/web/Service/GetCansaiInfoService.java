package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.CanSaiBean;
import com.SweetChildhood.web.Dao.CansaiDao;

public class GetCansaiInfoService {
	public static ArrayList<CanSaiBean> gettCansaiInfoService(String username) throws Exception{
		ArrayList<CanSaiBean> list = CansaiDao.cansaiDao(username);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
