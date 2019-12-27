package com.SweetChildhood.web.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.SweetChildhood.web.Bean.RuxuetestBean;
import com.SweetChildhood.web.DbUtil.Driver;

public class RuxuetestDao {
	public static ArrayList<RuxuetestBean> ruxuetestDao(String username,String classes) throws Exception{
		Statement statement = Driver.getStatement();
		if (statement!=null) {
			String sql="select * from ruxuetest where sid= '"+username+"' and cid= '"+classes +"'";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<RuxuetestBean> list = new ArrayList<RuxuetestBean>();
			while(rs.next()) {
				RuxuetestBean ruxuetestBean = new RuxuetestBean();
				ruxuetestBean.setAge(rs.getString("age"));
				ruxuetestBean.setBeizhu(rs.getString("beizhu"));
				ruxuetestBean.setCid(rs.getString("cid"));
				ruxuetestBean.setGuihua(rs.getString("guihua"));
				ruxuetestBean.setId(Integer.parseInt(rs.getString("id")));
				ruxuetestBean.setScore(rs.getString("score"));
				ruxuetestBean.setSid(rs.getString("sid"));
				ruxuetestBean.setTeacher(rs.getString("teacher"));
				ruxuetestBean.setText1(rs.getString("text1"));
				ruxuetestBean.setText2(rs.getString("text2"));
				ruxuetestBean.setText3(rs.getString("text3"));
				ruxuetestBean.setText4(rs.getString("text4"));
				ruxuetestBean.setText5(rs.getString("text5"));
				ruxuetestBean.setTime(rs.getString("time"));
				list.add(ruxuetestBean);
			}
			return list;
		}
		return null;
	}
	public static int setRuxuetestDao(ArrayList<RuxuetestBean> list) throws Exception{
		int i = 0;
		String classes = null;
		String age = null;
		String beizhu = null;
		String guihua = null;
		String score = null;
		String sid = null;
		String teacher = null;
		String text1 = null;
		String text2 = null;
		String text3 = null;
		String text4 = null;
		String text5 = null;
		String time = null;
		for (RuxuetestBean ruxuetestBean:list) {
			age = ruxuetestBean.getAge();
			beizhu = ruxuetestBean.getBeizhu();
			classes = ruxuetestBean.getCid();
			guihua = ruxuetestBean.getGuihua();
			score = ruxuetestBean.getScore();
			sid = ruxuetestBean.getSid();
			teacher = ruxuetestBean.getTeacher();
			text1 = ruxuetestBean.getText1();
			text2 = ruxuetestBean.getText2();
			text3 = ruxuetestBean.getText3();
			text4 = ruxuetestBean.getText4();
			text5 = ruxuetestBean.getText5();
			time = ruxuetestBean.getTime();
		}
		if (classes!=null) {
			String sql="insert into ruxuetest (sid,cid,text1,text2,text3,text4,text5,age,score,guihua,beizhu,teacher,time)";
			sql=sql+ " valuse ('"+sid+"','"+classes+"','"+text1+"','"+text2+"','"+text3+"','"+text4+"','"+text5+"','"
				+ age+"','"+score+"','"+guihua+"','"+beizhu+"','"+teacher+"','"+time+"')";
			i = Driver.up(sql);
		}
		

		return i;
	}
	

}
