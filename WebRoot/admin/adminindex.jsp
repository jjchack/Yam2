<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
if(request.getSession().getAttribute("admininfo")==null){
	response.sendRedirect("/login.jsp");}
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">小马山药后台管理</div>
	<div class="navigation">
		<ul>
			<li><a href="${pageContext.request.contextPath}/CancellationServlet">返回到首页</a></li>
		 	<li>欢迎您！</li>
			<li><a href="">${sessionScope.admininfo.name }</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/modify.jsp" target="fr">修改密码</a></li>
			<li><a href="${pageContext.request.contextPath}/CancellationServlet">注销</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
				<li>
          <h4  class="M8"><span></span>网站管理</h4>
          <div class="list-item none">
            <a href=${pageContext.request.contextPath }/admin/upgoods.jsp target="fr">上传商品</a>
            <a href='${pageContext.request.contextPath }/GetGoodsList' target="fr">查看已经上传的商品</a>
            <a href='${pageContext.request.contextPath }/GetUserDetail' target="fr">查看用户购买记录</a>
            <a href='${pageContext.request.contextPath }/admin/upindeximg.jsp' target="fr">首页大图管理</a>
          </div>
        </li>
       
        <li>
          <h4   class="M8"><span></span>用户管理</h4>
          <div class="list-item none">
            <a href='${pageContext.request.contextPath }/GetUserList' target="fr">获取用户列表</a>
          </div>
        </li>
  </ul>
		</div>
		<div class="m-right">
			
			<div class="main">
				<iframe name="fr" src="" width="100%" height="100%"></iframe>
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>版权所有 | 河南理工大学大学 | 河南省焦作市高新区世纪大道2001号 | 454002</p></div>
<script>navList(10);</script>
</body>
</html>
