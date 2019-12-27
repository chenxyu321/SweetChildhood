package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.HuojiangBean;
import com.SweetChildhood.web.Dao.HuojiangDao;

public class GetHuojiangService {
	public static ArrayList<HuojiangBean> getHuojiangService (String username) throws Exception{
		ArrayList<HuojiangBean> list = HuojiangDao.huojiangDao(username);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
