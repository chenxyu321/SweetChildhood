package com.SweetChildhood.web.Service;

import java.util.ArrayList;

import com.SweetChildhood.web.Bean.PictureBean;
import com.SweetChildhood.web.Dao.PictureDao;

public class GetPictureInfoService {
	public static ArrayList<PictureBean> getPictureInfoService() throws Exception{
		ArrayList<PictureBean> list = new ArrayList<PictureBean>();
		list = PictureDao.pictureDao();
		if (list!=null) {
			return list;
		}
		return null;
	}
}
