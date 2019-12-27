package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.FankuiBean;
import com.SweetChildhood.web.Dao.FankuiDao;

public class GetFankuiInfoService {
		public static ArrayList<FankuiBean> getFankuiInfoService(String username) throws Exception{
			ArrayList<FankuiBean> list = new ArrayList<FankuiBean>();
			list = FankuiDao.fankuiDao(username);
			if (list!=null) {
				return list;
				
			}
			return null;
		}
}
