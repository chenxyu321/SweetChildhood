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
	<title>家长登录</title>
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
	  if (validate_required(name,"用户名不能为空！")==false)
	    {name.focus();return false}
	  
	  if (validate_required(pass,"密码不能为空")==false)
	    {pass.focus();return false}
	  }
	}
	</script>
</head>
<body>
<form action="/Parentlogin" method="post" id="loginform" onsubmit="return validate_form(this)" >
<div class="materialContainer">
	<div class="box">
		<div class="title">家长登录</div>
		<div class="input">
			<label for="name">用户名</label>
			<input type="text" name="name" id="name">
			<span class="spin"></span>
		</div>
		<div class="input">
			<label for="pass">密码</label>
			<input type="password" name="pass" id="pass">
			<span style="color:red;"><c:out value="${err}"/></span>
		</div>
		<div class="button login">
			<button id="parentlogin">
				<span>登录</span>
				<i class="fa fa-check"></i>
			</button>
		</div>
	</div>

	<div class="overbox">
		<div class="material-button alt-2">
			<span class="shape"></span>
		</div>
		<div class="title">不知道如何登录？</div>
		<div class="input" style="border-buttom:none;height: 120px;">
		此平台为孩子情况追踪平台，为了更好的进行个性化服务和因材施教，请报名我们的课程后使用学号进行登录，密码默认为123456，建议您登录后更改密码，如果忘记密码可以联系我们的老师为您重置密码。
		</div>
	</div>
</div>
</form>
<script src="../Parent/js/jquery.min.js"></script>
<script src="../Parent/js/index.js"></script>

</body>
</html>