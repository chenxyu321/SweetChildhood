/*
 * 链接数据库工具类
 * 作者：陈翔宇
 * 2019年9月17日09:47:49
 * 
 * */
package com.SweetChildhood.web.DbUtil;
import java.sql.*;
public class Driver {
	//重写构造方法，返回Statement型数据，返回连接集
   private static Statement driver(){ 
    String driver = "com.mysql.jdbc.Driver"; 
    String databasenameString = "/sweetchildhood";
    String addressString = "localhost:";
    String pointString = "3306";
    String linkString =addressString+pointString+databasenameString;
    String URL = "jdbc:mysql://"+linkString+"?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; 
    Connection con = null; 
    Statement statement = null;
    try
    { 
      Class.forName(driver);
      String unameString="root";
      String upassString = "root";
      con=DriverManager.getConnection(URL,unameString,upassString); 
      System.out.println("Connect Successfull."); 
      statement = con.createStatement();
    }  
    catch(Exception e) 
    { 
      System.out.println("Connect fail:" + e.getMessage()); 
    } 
    return statement;
  } 
   //查询操作，返回bool型数据，是否查询到结果集
  public static boolean se(String str,String str2) throws SQLException {
	  ResultSet rs = null;
	  boolean bo = false;
	  rs = driver().executeQuery(str);
	  if (rs.next()) {
		  if (str2.equals(rs.getString("pass"))&&rs.getString("active").equals("1")) {
				bo = true;
		}
	}
	  return bo;  
  }
  //增加、删除、更新操作，返回int型数据，受影响的行数
  public static int up(String str) throws SQLException {
	  int i = 0;
	  i = driver().executeUpdate(str);
	  if (i!=0) {
		return i;
	}
	  return 0;  
  }
  public static Statement getStatement(){
	  return driver();
  }
//
//  public static void main(String[] args) {
//	driver();
//}
}
