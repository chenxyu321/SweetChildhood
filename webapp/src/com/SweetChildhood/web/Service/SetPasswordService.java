package com.SweetChildhood.web.Service;

import com.SweetChildhood.web.Dao.ParentDao;

public class SetPasswordService {
	public static int setPasswordService(String username,String userpass) throws Exception {
		int i = 0;
		i = ParentDao.upPassDao(username, userpass);
		return i;
	}
}
