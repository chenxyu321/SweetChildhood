<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
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
	<title>家长反馈</title>
	<link rel="stylesheet" href="../Parent/css/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../Parent/css/style.css">
   	<link rel="shortcut icon" href="../images/favicon.ico">
   	<script type="text/javascript">
	function validate_required(field,alerttxt)
	{
	with (field)
	  {
	  if (value==null||value=="")
	    {alert(alerttxt);return false}
	  else {return true}
	  }
	}
	
	function validate_form(thisform)
	{
	with (thisform)
	  {
	  if (validate_required(name,"不能为空！")==false)
	    {name.focus();return false;}
	}
	</script>
</head>
<body>
<form action="/SetParentfankui" method="post" id="loginform" onsubmit="return validate_form(this)" >
<div class="materialContainer">
	<div class="box">
			<div class="title">家长反馈</div>
			<div class="input">
			<label for="name">请填写反馈或您的宝贵建议</label>
			<input type="text" name="name" id="name">
			<span class="spin"></span>
			</div>
		<div class="button login">
			<button id="parentlogin">
				<span>提交</span>
				<i class="fa fa-check"></i>
			</button>
		</div>
	</div>
</div>
</form>
<script src="../Parent/js/jquery.min.js"></script>
<script src="../Parent/js/index.js"></script>

</body>
</html>