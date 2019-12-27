package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ParentfankuiBean;
import com.SweetChildhood.web.Dao.ParentfankuiDao;

public class SetParentfankuiService {
	public static int setParentfankuiService(ArrayList<ParentfankuiBean> list) throws Exception{
		int i = 0;
		i = ParentfankuiDao.setParentfankuiDao(list);
		return i;
	}
}
