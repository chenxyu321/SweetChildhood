package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.KetangbiaoxianBean;
import com.SweetChildhood.web.Dao.KetangbiaoxianDao;

public class GetKetangbiaoxianInfoService {
	public static ArrayList<KetangbiaoxianBean> getKetangbiaoxianInfoService(String username,String classes) throws Exception{
		ArrayList<KetangbiaoxianBean> list = KetangbiaoxianDao.ketangbiaoxianDao(username, classes);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
