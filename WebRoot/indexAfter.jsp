<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>首页</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.useso.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
<!--slider-script-->
		<script src="js/responsiveslides.min.js"></script>
			<script>
				$(function () {
				  $("#slider1").responsiveSlides({
					auto: true,
					speed: 500,
					namespace: "callbacks",
					pager: true,
				  });
				});
			</script>
<!--//slider-script-->
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
</head>

  <body>
	<div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
							<li  ><a href="#">欢迎： ${userinfo.name }</a></li>
							<li ><a href="WishCart?kind=1" >购物车</a></li>
							<li > <a href="WishCart?kind=2" >结算</a> </li>		
							
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">菜单</a>
				<ul class="nav">
					<li class="active"><a href="indexAfter.jsp"><i> </i>首页</a></li>
											
						<li><a href="GetDiffGoods?goodstype=铁棍山药" >铁棍山药</a></li>            
						<li><a href="GetDiffGoods?goodstype=五谷杂粮" >五谷杂粮</a></li>						  				 
						<li><a href="GetDiffGoods?goodstype=干果干货" >干果干货</a></li>
						<li><a href="GetDiffGoods?goodstype=零食小吃" >零食小吃 </a></li>
					
				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div>
		</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
			<div class="header-bottom-on">
			<p class="wel"><a href="#">欢迎访问您可以登录或创建一个帐户。</a></p>
			<div class="header-can">
					
					<div class="search">
						<form action="SelectByNameInfo">
							<input type="text" name="goodsname" value="搜索商品名的关键字" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
							<input type="submit" value="">
						</form>
					</div>

					<div class="clearfix"> </div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
		</div>
	</div>
	<div class="banner-mat">
		<div class="container">
			<div class="banner">
	
			   <div class="slider">
			<ul class="rslides" id="slider1">
			<c:choose>
			   <c:when test="${!empty sessionScope.bigimgurllist}"> 
			   		<c:forEach items="${sessionScope.bigimgurllist }" var="list" varStatus="varSta">
						<li><img src="${list }" alt=""></li>
					</c:forEach> 
			   </c:when>
			   <c:otherwise> 
			   		<li><img src="images/ma1.png" alt=""></li>
			  		<li><img src="images/ma2.png" alt=""></li>
			 	 	<li><img src="images/ma3.png" alt=""></li>
			  		<li><img src="images/ma4.png" alt=""></li>
			   </c:otherwise>
			</c:choose>
			</ul>
		</div>

				<div class="banner-bottom">
					<div class="banner-matter">
						<p>欢迎购买门店镇店之宝</p> 
						<a href="GetDiffGoods?goodstype=铁棍山药" class="hvr-shutter-in-vertical ">查看</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>				
		</div>
	</div>
		
		<div class="container">
			<div class="content">
				<div class="content-top">
					<h3 class="future">精选</h3>
					<div class="content-top-in">
					
						<c:forEach items="${sessionScope.smallimgurllist }" var="list" varStatus="varSta">
							<div class="col-md-3 md-col">
								<div class="col-md">
									<a href="GetSingleById?goodsid=${list.id }"><img  src="${list.imgurl }" alt="" style="width: 236px; height: 205px;"/></a>	
								<div class="top-content">
									<h5><a href="GetSingleById?goodsid=${list.id }">${list.name }</a></h5>
									<div class="white">
										<a href="GetSingleById?goodsid=${list.id }" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">添加到购物车</a>
										<p class="dollar"><span class="in-dollar">$${list.price }</p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						</c:forEach>
						
						
					<div class="clearfix"></div>
					</div>
				</div>
				
		
			<div class="footer-middle">
				<div class="container">
					<div class="footer-middle-in">
						<h6>About us</h6>
						<p>We're from the source team. Welcome to join us.</p>
					</div>
					<div class="footer-middle-in">
						<h6>Information</h6>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="admin/adminlogin.jsp">back-stage management</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Terms & Conditions</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>Customer Service</h6>
						<ul>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="#">Returns</a></li>
							<li><a href="#">Site Map</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>My Account</h6>
						<ul>
							<li><a href="account.html">My Account</a></li>
							<li><a href="#">Order History</a></li>
							<li><a href="wishlist.html">Wish List</a></li>
							<li><a href="#">Newsletter</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>Extras</h6>
						<ul>
							<li><a href="#">Brands</a></li>
							<li><a href="#">Gift Vouchers</a></li>
							<li><a href="#">Affiliates</a></li>
							<li><a href="#">Specials</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<p class="footer-class">Copyright &copy; 2016.Source team All rights reserved.
			<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'toTop', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

		</div>
</body> 

</html>
