package com.SweetChildhood.web.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.SweetChildhood.web.Bean.SmininfoBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class SmininfoDao {
	public static ArrayList<SmininfoBean> smininfoDao(String username) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql ="select * from smininfo where id="+username; 
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<SmininfoBean> list = new ArrayList<SmininfoBean>();
			if (rs.next()) {
				SmininfoBean smininfoBean = new SmininfoBean();
				smininfoBean.setId(rs.getString("id"));
				smininfoBean.setSaddress(rs.getString("saddress"));
				smininfoBean.setSaihao(rs.getString("saihao"));
				smininfoBean.setSbirth(rs.getString("sbirth"));
				smininfoBean.setSinfo(rs.getString("sinfo"));
				smininfoBean.setSjiiguan(rs.getString("sjiguan"));
				smininfoBean.setSlixiang(rs.getString("slixiang"));
				smininfoBean.setSminzu(rs.getString("sminzu"));
				smininfoBean.setSname(rs.getString("sname"));
				smininfoBean.setSnianji(rs.getString("snianji"));
				smininfoBean.setSphotopath(rs.getString("sphotopath"));
				smininfoBean.setSrongyu(rs.getString("srongyu"));
				smininfoBean.setSsex(rs.getString("ssex"));
				smininfoBean.setStechang(rs.getString("stechang"));
				list.add(smininfoBean);
				return list;
			}
		}
		return null;
	}
	public static int smininfoDao(ArrayList<SmininfoBean> list) throws Exception{
		int i =0;
		if (list!=null) {
			SmininfoBean smininfoBean = list.get(0);
			if (smininfoBean!=null) {
				String id = smininfoBean.getId();
			
				if (id!=null) {
					String sname = smininfoBean.getSname();
					String ssex = smininfoBean.getSsex();
					String sbirth = smininfoBean.getSbirth();
					String sminzu = smininfoBean.getSminzu();
					String snianji = smininfoBean.getSnianji();
					String sjiiguan = smininfoBean.getSjiiguan();
					String stechang  = smininfoBean.getStechang();
					String saihao = smininfoBean.getSaihao();
					String slixiang = smininfoBean.getSlixiang();
					String srongyu = smininfoBean.getSrongyu();
					String saddress = smininfoBean.getSaddress();
					String sinfo = smininfoBean.getSinfo();
					String sphotopath = smininfoBean.getSphotopath();
					String sql = "insert into smininfo "
							+ "('id','sname','ssex','sbirth','sminzu','snianji','sjiguan','stechang','saihao','slixiang','srongyu','saddress','sinfo','sphotopath') "
							+ "values ('"+id+"',"+"'"+sname+"',"+"'"+ssex+"',"+"'"+sbirth+"',"+"'"+sminzu+"',"+"'"+snianji+"',"+"'"+sjiiguan+"',"+"'"+stechang+"',"+"'"+saihao+"',"+"'"+slixiang+"',"+"'"+srongyu+"',"+"'"+saddress+"',"+"'"+sinfo+"',"+"'"+sphotopath+"')";
					i=Driver.up(sql);
				}
			}
			
		}
		return i;
		
	}
}
