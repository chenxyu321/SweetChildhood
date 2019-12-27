package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.SystongzhiBean;
import com.SweetChildhood.web.Dao.SystongzhiDao;

public class GetSystongzhiInfoService {
	public static ArrayList<SystongzhiBean> getSystongzhiInfoService() throws Exception{
		ArrayList<SystongzhiBean> list = SystongzhiDao.systongzhiDao();
		if (list!=null) {
			return list;
		}
		return null;
	}
}
