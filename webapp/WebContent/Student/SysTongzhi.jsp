<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>系统通知</title>
</head>
<body>
<div style=“width:100%”>
<div style="width:100%;margin:0 auto;">
<table width="100%" style="text-align: center">
<c:if test="${Systongzhi[0].id!=null}" var="fa">
<tr style="border-buttom:1px solid white;background-color: #00CCFF;">
<td width="10%">序号</td>
<td width="20%">日期</td>
<td width="70%">通知内容</td>
</tr>
</c:if>
<c:if test="${Systongzhi[0].id==null}" var="fa">
<tr>
<td colspan="4">暂无数据</td>
</tr>
</c:if>
<c:forEach items="${Systongzhi}" var="f" varStatus="a">
<c:if test="${a.index%2!=0}">
<tr style="border-buttom:1px solid white;background-color:#AEDD81;height: 40px;">
<td>${a.index+1}</td>
<td>${f.time}</td>
<td>${f.text}</td>
</tr>
</c:if>
<c:if test="${a.index%2==0}">
<tr style="border-buttom:1px solid white;background-color:#EB7347;height: 40px;">
<td>${a.index+1}</td>
<td>${f.time}</td>
<td>${f.text}</td>
</tr>
</c:if>
</c:forEach>
</table>
</div>
</div>
</body>
</html>