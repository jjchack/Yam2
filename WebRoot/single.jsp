<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>您的选择</title>
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
<script>
function aa(){
var x=document.getElementById("a").innerHTML;
x=parseInt(x)+1;
document.getElementById("a").innerHTML=x;
}
function bb(){
var x=document.getElementById("a").innerHTML;
x=parseInt(x)-1;
if(x<1){
document.getElementById("a").innerHTML=1;
}else{
document.getElementById("a").innerHTML=x;
}
}							
</script>
<script type="text/javascript">
	$(function(){
		$("#cart1").click(function(){
			var goodsid = ${goods.id};
			var goodsnum = document.getElementById("a").innerHTML;
					var url = "${pageContext.request.contextPath}/AddShoppingSingle";
					var args = {"goodsid":goodsid,"goodsnum":goodsnum,"time":new Date()};
					$.get(url,args,function(data){
						if(data == "true"){
							$("#error").html("<font color='greed'>加入购物车成功！！！</font>");
						}else{
							$("#error").html("<font color='red'>加入失败，请与管理员联系</font>");
						}
					});
		return false;
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
	<!---->
		<div class="container">
			<div class="single">
				<div class="col-md-9 top-in-single">
					<div class="col-md-5 single-top">	
						<!-- start product_slider -->
				    <div class="flexslider">
							        <!-- FlexSlider -->
										<script src="js/imagezoom.js"></script>
										  <script defer src="js/jquery.flexslider.js"></script>
										<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

										<script>
										// Can also be used with $(document).ready()
										$(window).load(function() {
										  $('.flexslider').flexslider({
											animation: "slide",
											controlNav: "thumbnails"
										  });
										});
										</script>
									<!-- //FlexSlider-->

							  <ul class="slides">
								<li data-thumb="${goods.imgurl }">
									<div class="thumb-image"> <img src="${goods.imgurl }" data-imagezoom="true" class="img-responsive" style="width:100%;height:450px"> </div>
								</li>
							  </ul>
							<div class="clearfix"></div>
					</div>
				<!-- end product_slider -->
					
					</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para">
							<h4>${goods.name }</h4>
							<div class="para-grid">
								<span  class="add-to">$${goods.price }</span>
								<a href="#" class="hvr-shutter-in-vertical cart-to" id="cart1">加入购物车</a>					
								<div class="clearfix"></div>
							 </div>
							<div class="available">
								<h6>请选定所购数量</h6>
								<ul>
								<li>数量：</li><br><br>
								<div id="a" style="float:left;width:10px" >1</div>
								<div style="float:right margin-right:50px">件</div>
								<br>
								<div>
								<input name="submit" type="image" value="减" src="images/jian.jpg" " onclick="bb()" style="width:25px;height:25px;"/>
								<input name="submit" type="image" value="加" src="images/jia.jpg" " onclick="aa()" style="width:25px;height:25px;"/>
								</div>
								</ul>
						</div>
							<p>${goods.info }</p>
							
								<a href="#" class="hvr-shutter-in-vertical ">结算</a><br><br><br>
								<div id="error"></div>
						</div>
					</div>
				<div class="clearfix"> </div>
				<div class="content-top-in">
				<c:forEach items="${sessionScope.similarlists }" var="list" varStatus="varSta">
						<div class="col-md-4 top-single">
							<div class="col-md">
								<img  src="${list.imgurl }" alt="" />	
								<div class="top-content">
									<h5>${list.name }</h5>
									<div class="white">
										<a href="GetSingleById?goodsid=${list.id }" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
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
				<div class="col-md-3">
					<div class="single-bottom">
						<h4>宝贝分类</h4>
						<ul>
						<li><a href="GetDiffGoods?goodstype=铁棍山药" >铁棍山药</a></li>            
						<li><a href="GetDiffGoods?goodstype=五谷杂粮" >五谷杂粮</a></li>						  				 
						<li><a href="GetDiffGoods?goodstype=干果干货" >干果干货</a></li>
						<li><a href="GetDiffGoods?goodstype=零食小吃" >零食小吃 </a></li>
						</ul>
					</div>
					<div class="single-bottom">
						<h4>相关连接</h4>
						<ul>
						<li><a href="https://shop104265449.taobao.com/?spm=a230r.7195193.1997079397.20.7ue2HH"><i> </i>小马淘宝店铺</a></li>
						<li><a href="https://www.taobao.com/"><i> </i>淘宝网</a></li>
						<li><a href="http://www.jd.com/"><i> </i> 京东商城</a></li>
						<li><a href="http://www.vip.com/"><i> </i>唯品会</a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
		</div>
	</div>
			<!---->
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
			<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.</p>
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
