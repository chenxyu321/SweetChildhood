<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<meta name="keywords" content="小方糖,编程,机器人,口才,全脑,潜能开发,C,Scratch,Python,C++">
	<meta name="description" content="小方糖教育">
	<meta name="robots" content="all">
	<meta name="author" content="陈翔宇">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Content-Language" content="zh-cn" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>学生档案</title>
<style>
*{margin:0;padding:0;}
.window{width:100%;}
.center{margin: 60px auto;}
table{text-align: center;margin:0 auto;width:90%}
.tl{text-align: left;}
.zhan{height:300px;}
.underline{text-decoration:underline;word-spacing:2em;}
</style>
</head>
<body>
	<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String now = df.format(d);
	%>
<div class="window">
<c:if test="${empty errors}">
<div align="center" class="center">
<h1>小方糖</h1>
<h1>学员档案</h1>
<div class="zhan"></div>
<h2>专业：<span class="underline"> 机器人编程&nbsp;</span></h2>
<h2>小组：<span class="underline"> 机器${ketang[0].zid}组&nbsp;</span></h2>
<h2>电话：<span class="underline"> ${chengyuan[0].tel}&nbsp;</span></h2>
<h2>教师：<span class="underline"> ${ketang[0].teacher}&nbsp;</span></h2>
<h2>日期：<span class="underline"> <%=now %>&nbsp;</span></h2>
<div class="zhan"></div>
</div>
<table border="1">
<tr>
<td colspan="5">
<strong>学员基本信息表</strong>
</td>
</tr>
<tr>
<td colspan="4">
<strong>基本信息</strong>
</td>
<td rowspan="4">
<img src="${sinfo[0].sphotopath}" width="140px" height="200px">
</td>
</tr>
<tr>
<td>
姓名
</td>
<td>
${sinfo[0].sname}
</td>
<td>
性别
</td>
<td>
${sinfo[0].ssex}
</td>
</tr>
<tr>
<td>
出生日期
</td>
<td>
${sinfo[0].sbirth}
</td>
<td>
民族
</td>
<td>
${sinfo[0].sminzu}
</td>
</tr>
<tr>
<td>
学校年级
</td>
<td>
${sinfo[0].snianji}
</td>
<td>
籍贯
</td>
<td>
${sinfo[0].sjiiguan}
</td>
</tr>

<tr>
<td>
特长
</td>
<td colspan="4">
${sinfo[0].stechang}
</td>
</tr>
<tr>
<td>
兴趣爱好
</td>
<td colspan="4">
${sinfo[0].saihao}
</td>
</tr>
<tr>
<td>
理想
</td>
<td colspan="4">
${sinfo[0].slixiang}
</td>
</tr>
<tr>
<td>
所获荣誉
</td>
<td colspan="4">
${sinfo[0].srongyu}
</td>
</tr>
<tr>
<td colspan="5">
家庭信息
</td>
</tr>
<tr>
<td>
家庭住址
</td>
<td colspan="4">
${sinfo[0].saddress}
</td>
</tr>
<tr>
<td colspan="5">
家庭成员
</td>
</tr>
<tr>
<td>

</td>
<td>
关系
</td>
<td>
姓名
</td>
<td>
单位
</td>
<td>
电话
</td>
</tr>
<tr>
<td>
1
</td>
<td>
${chengyuan[0].guanxi}
</td>
<td>
${chengyuan[0].name}
</td>
<td>
${chengyuan[0].danwei}
</td>
<td>
${chengyuan[0].tel}
</td>
</tr>
<tr>
<td>
2
</td>
<td>
${chengyuan[1].guanxi}
</td>
<td>
${chengyuan[1].name}
</td>
<td>
${chengyuan[1].danwei}
</td>
<td>
${chengyuan[1].tel}
</td>
</tr>
<tr>
<td>
3
</td>
<td>
${chengyuan[2].guanxi}
</td>
<td>
${chengyuan[2].name}
</td>
<td>
${chengyuan[2].danwei}
</td>
<td>
${chengyuan[2].tel}
</td>
</tr>
<tr>
<td>
4
</td>
<td>
${chengyuan[3].guanxi}
</td>
<td>
${chengyuan[3].name}
</td>
<td>
${chengyuan[3].danwei}
</td>
<td>
${chengyuan[3].tel}
</td>
</tr>
<tr>
<td>
备注
</td>
<td colspan="4">
${sinfo[0].sinfo}
</td>
</tr>
</table>
<div class="zhan"></div>
<table border="1">
<tr>
<td colspan="10"><strong>入学测试记录表</strong></td>
</tr>
<tr>
<td>姓名</td>
<td>${sinfo[0].sname}</td>
<td>学校</td>
<td>小方糖教育总部基地</td>
<td>年级</td>
<td>${sinfo[0].snianji}</td>
<td>年龄</td>
<td>${ruxue[0].age}</td>
<td>得分</td>
<td>${ruxue[0].score}</td>
</tr>
<tr>
<td rowspan="5" colspan="2">入学测试情况</td>
<td colspan="8" class="tl">普通话基础：${ruxue[0].text1}</td>
</tr>
<tr>
<td colspan="8" class="tl">语言表达：${ruxue[0].text2}</td>
</tr>
<tr>
<td colspan="8" class="tl">表现力：${ruxue[0].text3}</td>
</tr>
<tr>
<td colspan="8" class="tl">形象气质：${ruxue[0].text4}</td>
</tr>
<tr>
<td colspan="8" class="tl">性格：${ruxue[0].text5}</td>
</tr>
<tr>
<td colspan="2">学习规划</td>
<td colspan="8">${ruxue[0].guihua}</td>
</tr>
<tr>
<td colspan="2">备注</td>
<td colspan="8">${ruxue[0].beizhu}</td>
</tr>
<tr>
<td colspan="2">教师签名</td>
<td colspan="4">${ruxue[0].teacher}</td>
<td colspan="1">日期</td>
<td colspan="3">${ruxue[0].time}</td>
</tr>
</table>
<div class="zhan"></div>
<table border="1">
<tr>
<td colspan="8"><strong>课堂表现记录表</strong></td>
</tr>
<tr>
<td>姓名</td>
<td>${sinfo[0].sname}</td>
<td>小组</td>
<td>${ketang[0].zid}组</td>
<td>时间</td>
<td><%=now %></td>
<td>教师</td>
<td>${ketang[0].teacher}</td>
</tr>
<tr>
<td>课堂纪律</td>
<td colspan="7" class="tl">${ketang[0].jilv}</td>
</tr>
<tr>
<td rowspan="2">表演展现</td>
<td colspan="7" class="tl">次数：${ketang[0].zhanxiannum}</td>
</tr>
<tr>
<td colspan="7" class="tl">表现力：${ketang[0].biaoxian}</td>
</tr>
<tr>
<td>情感表达</td>
<td colspan="7" class="tl">${ketang[0].text1}</td>
</tr>
<tr>
<td>普通话发音声音状态</td>
<td colspan="7" class="tl">${ketang[0].text2}</td>
</tr>
<tr>
<td>形体礼仪</td>
<td colspan="7" class="tl">${ketang[0].text3}</td>
</tr>
<tr>
<td>学习计划</td>
<td colspan="7" class="tl">${ketang[0].jihua}</td>
</tr>
</table>
<div class="zhan"></div>
<table border="1">
<tr>
<td colspan="8"><strong>活动记录</strong></td>
</tr>
<tr>
<td>姓名</td>
<td>${sinfo[0].sname}</td>
<td>小组</td>
<td>${huodong[0].zid}</td>
<td>时间</td>
<td><%=now %></td>
<td>教师</td>
<td>${huodong[0].teacher}</td>
</tr>
<c:forEach items="${huodong}" var="f" varStatus="a">
<tr>
<td>活动事项</td>
<td colspan="7" class="tl">${f.shixiang}</td>
</tr>
<tr>
<td>成果</td>
<td colspan="7" class="tl">${f.chengguo}</td>
</tr>
<tr>
<td>评价</td>
<td colspan="7" class="tl">${f.pingjia}</td>
</tr>
</c:forEach>
</table>
<div class="zhan"></div>
</c:if>
${errors}
</div>
</body>
</html>