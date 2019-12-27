package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.SmininfoBean;
import com.SweetChildhood.web.Dao.SmininfoDao;

public class SetSmininfoService {
	public static int setSmininfoService(ArrayList<SmininfoBean> list) throws Exception{
		int i =0;
		i = SmininfoDao.smininfoDao(list);
		return i;
	}
}
