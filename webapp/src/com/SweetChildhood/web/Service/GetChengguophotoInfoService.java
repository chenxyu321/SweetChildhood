package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.ChengguophotoBean;
import com.SweetChildhood.web.Dao.ChengguophotoDao;

public class GetChengguophotoInfoService {
	public static ArrayList<ChengguophotoBean> getChengguophotoInfoService(String chengguoid) throws Exception{
		ArrayList<ChengguophotoBean> list = ChengguophotoDao.chengguophotoDao(chengguoid);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
