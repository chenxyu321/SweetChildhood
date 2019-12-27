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
	<link rel="stylesheet" href="../Parent/css/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../Parent/css/style.css">
   	<link rel="shortcut icon" href="../images/favicon.ico">
<title>修改密码</title>
</head>
<body>

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
	  if (validate_required(name,"密码不能为空")==false)
	    {pass.focus();return false}
	  }
	}
	</script>
</head>
<body>
<form action="/UpPassword" method="post" id="passform" onsubmit="return validate_form(this)">
<div class="materialContainer">
	<div class="box">
		<div class="title">修改密码</div>

		<div class="input">
			<label for="name">新密码</label>
			<input type="password" name="pass" id="name">
			<span style="color:red;"><c:out value="${err}"/></span>
			<span class="spin"></span>
		</div>
		<div class="button login">
			<button id="parentlogin">
				<span>修改</span>
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