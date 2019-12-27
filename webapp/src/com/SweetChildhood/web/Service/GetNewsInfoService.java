package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.NewsBean;
import com.SweetChildhood.web.Dao.NewsDao;

public class GetNewsInfoService {
	public static ArrayList<NewsBean> getNewsInfoService() throws Exception{
		ArrayList<NewsBean> list = new ArrayList<NewsBean>();
		list = NewsDao.newsDao();
		if (list!=null) {
			return list;
		}
		return null;
	}
	public static ArrayList<NewsBean> getNewsInfoService(int id) throws Exception{
		ArrayList<NewsBean> list = new ArrayList<NewsBean>();
		list = NewsDao.newsDao(id);
		if (list!=null) {
			return list;
		}
		return null;
	}
}
