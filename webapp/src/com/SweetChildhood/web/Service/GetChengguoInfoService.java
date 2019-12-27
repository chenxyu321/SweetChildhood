package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ChengguoBean;
import com.SweetChildhood.web.Dao.ChengguoDao;

public class GetChengguoInfoService {
	public static ArrayList<ChengguoBean> getChengguoInfoService(String username) throws Exception{
		ArrayList<ChengguoBean> list = ChengguoDao.chenggguoDao(username);
		if (list!=null) {
			return list;
		}
		return null;
	}
	public static ArrayList<ChengguoBean> getChengguoInfoService(int id) throws Exception{
		ArrayList<ChengguoBean> list = ChengguoDao.chenggguoDao(id);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
