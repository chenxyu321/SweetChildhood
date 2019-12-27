<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<meta name="keywords" content="小方糖,编程,机器人,口才,全脑,潜能开发,C,Scratch,Python,C++">
		<meta name="description" content="小方糖教育">
		<meta name="robots" content="all">
		<meta name="author" content="陈翔宇">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Content-Language" content="zh-cn" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<title>${Newsinfo[0].title}</title>
		<!-- Favicons -->
		<link rel="shortcut icon" href="../images/favicon.ico">
		<!-- all css here -->
		<!-- bootstrap v3.3.6 css -->
		<link rel="stylesheet" href="../News/css/bootstrap.min.css">
		<!-- owl.carousel css -->
		<link rel="stylesheet" href="../News/css/owl.carousel.css">
		<link rel="stylesheet" href="../News/css/owl.transitions.css">
       <!-- Animate css -->
        <link rel="stylesheet" href="../News/css/animate.css">
        <!-- meanmenu css -->
        <link rel="stylesheet" href="../News/css/meanmenu.min.css">
		<!-- font-awesome css -->
		<link rel="stylesheet" href="../News/css/font-awesome.min.css">
		<link rel="stylesheet" href="../News/css/icon.css">
		<link rel="stylesheet" href="../News/css/flaticon.css">
		<!-- magnific css -->
        <link rel="stylesheet" href="../News/css/magnific.min.css">
		<!-- style css -->
		<link rel="stylesheet" href="../News/style.css">
		<!-- responsive css -->
		<link rel="stylesheet" href="../News/css/responsive.css">

		<!-- modernizr css -->
		<script src="../News/js/vendor/modernizr-2.8.3.min.js"></script>
	</head>
		<body>

		<!--[if lt IE 8]>
			<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->

        <div id="preloader"></div>
        <header class="header-one">
            <!-- header-area start -->
            <div id="sticker" class="header-area hidden-xs">
                <div class="container">
                    <div class="row">
                        <!-- logo start -->
                        <div class="col-md-3 col-sm-3">
                            <div class="logo">
                                <!-- Brand -->
                                <a class="navbar-brand page-scroll black-logo" href="/Index">
                                    <img src="../images/logo/logo1.png" alt="">
                                </a>
                            </div>
                            <!-- logo end -->
                        </div>
                        <div class="col-md-9 col-sm-9">
                            <!-- mainmenu start -->
                            <nav class="navbar navbar-default">
                                <div class="collapse navbar-collapse" id="navbar-example">
                                    <div class="main-menu">
                                        <ul class="nav navbar-nav navbar-right">
                                            <li><a href="Index">返回首页</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                            <!-- mainmenu end -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- header-area end -->
            <!-- mobile-menu-area start -->
            <div class="mobile-menu-area hidden-lg hidden-md hidden-sm">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="mobile-menu">
                                <div class="logo">
                                    <a href="Index"><img src="../images/logo/logo1.png" alt="" /></a>
                                </div>
                                <nav id="dropdown">
                                    <ul>
                                        <li><a href="Index">点击返回首页</a></li>
                                    </ul>
                                </nav>
                            </div>					
                        </div>
                    </div>
                </div>
            </div>
            <!-- mobile-menu-area end -->		
        </header>
        <!-- header end -->
        <!-- Start Slider Area -->
        <div class="intro-area">
            <div class="bg-wrapper">
            	<img src="../News/img/background/bg.jpg" alt="">
            </div>
            <div class="intro-bg">
            	<img src="../News/img/background/bgp.png" alt="">
            </div>
			<div class="intro-content">
				<div class="slider-content">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<!-- layer 1 -->
								<div class="layer-1 wow fadeInUp" data-wow-delay="0.3s">
								    <h6 class="best-title">${Newsinfo[0].title}</h6>
									<h2 class="title2">${Newsinfo[0].time}</h2>
								</div>
								<!-- layer 2 -->
								<div class="layer-2 wow fadeInUp" data-wow-delay="0.5s">
									<p>${Newsinfo[0].text}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
        </div>
        <!-- End Slider Area -->
      
		
		<!-- all js here -->

		<!-- jquery latest version -->
		<script src="../News/js/vendor/jquery-1.12.4.min.js"></script>
		<!-- bootstrap js -->
		<script src="../News/js/bootstrap.min.js"></script>
		<!-- owl.carousel js -->
		<script src="../News/js/owl.carousel.min.js"></script>
		<!-- Counter js -->
		<script src="../News/js/jquery.counterup.min.js"></script>
		<!-- waypoint js -->
		<script src="../News/js/waypoints.js"></script>
		<!-- magnific js -->
        <script src="../News/js/magnific.min.js"></script>
        <!-- wow js -->
        <script src="../News/js/wow.min.js"></script>
        <!-- meanmenu js -->
        <script src="../News/js/jquery.meanmenu.js"></script>
		<!-- Form validator js -->
		<script src="../News/js/form-validator.min.js"></script>
		<!-- plugins js -->
		<script src="../News/js/plugins.js"></script>
		<!-- main js -->
		<script src="../News/../News/js/main.js"></script>
	</body>
</html>
