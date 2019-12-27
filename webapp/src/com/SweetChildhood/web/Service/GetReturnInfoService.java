package com.SweetChildhood.web.Service;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ReturnBean;
import com.SweetChildhood.web.Dao.ReturnDao;

public class  GetReturnInfoService {
	public static ArrayList<ReturnBean> getReturnInfoService() throws Exception{
	ArrayList<ReturnBean> list = ReturnDao.returnDao();
	if (list!=null) {
		return list;
	}
	return null;
	}
//	public static void main(String[] args) {
//		ArrayList<ReturnBean> list = ReturnDao.returnDao();
//	}
}
