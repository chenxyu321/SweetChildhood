<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
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
	<title><c:if test="${Student[0].sname!=null}"><c:out value="${Student[0].sname}"/></c:if>家长你好</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../Student/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../Student/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="../Student/css/font-awesome.css" rel="stylesheet"> 
<link rel="shortcut icon" href="../images/favicon.ico">
<!-- //font-awesome icons -->
 <!-- js-->
<script src="../Student/js/jquery-1.11.1.min.js"></script>
<script src="../Student/js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="../Student/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="../Student/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- chart -->
<!-- <script src="../Student/js/Chart.js"></script> -->
<!-- //chart -->
<!--Calender-->
<!-- <link rel="stylesheet" href="../Student/css/clndr.css" type="text/css" /> -->
<script src="../Student/js/underscore-min.js" type="text/javascript"></script>
<script src= "../Student/js/moment-2.2.1.js" type="text/javascript"></script>
<!-- <script src="../Student/js/clndr.js" type="text/javascript"></script> -->
<!-- <script src="../Student/js/site.js" type="text/javascript"></script> -->
<!--End Calender-->
<!-- Metis Menu -->
<script src="../Student/js/metisMenu.min.js"></script>
<script src="../Student/js/custom.js"></script>
<link href="../Student/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<li>
							<a href="/StudentIndex" class="active"><i class="fa fa-home nav_icon"></i>首页</a>
						</li>
						<li>
							<a href="#"><i class="fa fa-cogs nav_icon"></i>用户账户  <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="GoSetpass" target="myframe">修改密码</a>
								</li>
								<li>
									<a href="/ParentLogout">退出登录</a>
								</li>
							</ul>
							<!-- /nav-second-level -->
						</li>
						<li class="">
							<a href="#"><i class="fa fa-book nav_icon"></i>课堂表现<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="/Fankui" target="myframe">教师反馈</a>
<!-- 									这个是小气泡提醒 -->
<!-- 									<span class="nav-badge-btm">08</span> -->
								</li>
								<li>
									<a href="/Chengguo" target="myframe">成果展示</a>
								</li>
							</ul>
							<!-- /nav-second-level -->
						</li>
						<li>
							<a href="/Zuoye" target="myframe"><i class="fa fa-th-large nav_icon"></i>课后作业</a>
						</li>
						<li>
							<a href="#"><i class="fa fa-envelope nav_icon"></i>通知<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="/UserTongzhi" target="myframe">用户通知</a>
								</li>
								<li>
									<a href="/Systongzhi" target="myframe">系统通知</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
						<li>
							<a href="/Shangke" target="myframe"><i class="fa fa-table nav_icon"></i>上课记录</a>
						</li>
						<li>
							<a href="#"><i class="fa fa-check-square-o nav_icon"></i>参赛<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="/Cansai" target="myframe">参赛记录</a>
								</li>
								<li>
									<a href="/Huojiang" target="myframe">获奖记录</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
						<li>
							<a href="#"><i class="fa fa-file-text-o nav_icon"></i>学生档案卡<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse"> 
								<li>
									<a href="/dangan?id=2" target="myframe">少儿编程</a>
								</li>
								<li>
									<a href="/dangan?id=1" target="myframe">口才主持</a>
								</li>
								<li>
									<a href="/dangan?id=4" target="myframe">潜能开发</a>
								</li>
								<li>
									<a href="/dangan?id=3" target="myframe">机器人编程</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
						<li>
							<a href="Parentfankui" target="myframe" class="chart-nav"><i class="fa fa-bar-chart nav_icon"></i>家长反馈</a>
						</li>
					</ul>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="index.html">
						<h1>小方糖教育</h1>
						<span>学生情况时事追踪系统</span>
					</a>
				</div>
				<!--//logo-->
				<div class="clearfix"> </div>
			</div>
			<div class="header-right">
				<div class="profile_details_left"><!--notifications of menu start -->
					<ul class="nofitications-dropdown">
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i></a>
							<ul class="dropdown-menu">
								<li>
									<div class="notification_header">
										<h3><c:if test="${message!=null}">你有<c:out value="${fn:length(message)}"/>条消息</c:if></h3>
									</div>
								</li>
								<c:if test="${message!=null}">
								<c:forEach items="message" var="m">
								<li><a>
								   <div class="notification_desc">
									<p><c:out value="${m}"></c:out></p>
									</div>
								</a></li>
								</c:forEach>
								</c:if>
								<c:if test="${message==null}">
								<li><a>
								   <div>
									<p>没有新消息</p>
									</div>
								</a></li>
								</c:if>
								<li>
									<div class="notification_bottom">
										<a href="/UserTongzhi" target="myframe">查看全部信息</a>
									</div> 
								</li>
							</ul>
						</li>
					</ul>
					<div class="clearfix"> </div>
				</div>
				<!--notification menu end -->
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<c:if test="${Student[0].sphotopath!=null}">
									<span class="prfil-img"><img src="../Student/${Student[0].sphotopath}" alt="" width="50px" height="50px"> </span> 
									</c:if>
									<div class="user-name">
										<p><c:if test="${Student[0].sname!=null}"><c:out value="${Student[0].sname}"/></c:if></p>
										<span>家长你好</span>
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								<li> <a href="/GoSetpass" target="myframe"><i class="fa fa-cog"></i>账户设置 </a> </li> 
								<li> <a href="/ParentLogout"><i class="fa fa-sign-out"></i>退出登录</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
				<div id="page-wrapper">
						<iframe frameborder="0" name="myframe" src="../Student/1.html" width="100%" height="100%" frameborder="0"></iframe>
				</div>
		<!--footer-->
		<div class="footer">
		   <p>Copyright &copy; 2019 山东小方糖教育科技有限公司  All rights reserved.</p>
		</div>
        <!--//footer-->
	</div>
	<!-- Classie -->
		<script src="../Student/js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!--scrolling js-->
	<script src="../Student/js/jquery.nicescroll.js"></script>
	<script src="../Student/js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
   <script src="../Student/js/bootstrap.js"> </script>
</body>
</html>