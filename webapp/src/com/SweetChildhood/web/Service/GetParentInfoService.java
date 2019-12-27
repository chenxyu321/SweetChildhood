package com.SweetChildhood.web.Service;

import com.SweetChildhood.web.Dao.ParentDao;

public class GetParentInfoService {
	public static boolean getParentInfoService(String username,String userpass) throws Exception{
		boolean bo = ParentDao.parentDao(username, userpass);
		return bo;
	}
	public static String getPassService(String username) throws Exception{
		String userpass = null;
		userpass = ParentDao.getPassDao(username);
		return userpass;
	}
}
