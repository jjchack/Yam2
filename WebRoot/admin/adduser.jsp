<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
if(request.getSession().getAttribute("admininfo")==null){
	response.sendRedirect("/login.jsp");
}
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newslist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style type="text/css">
		#h1{ 
		}
		#h2{ 
		}
	</style>
  <body>
  	<div id=h1>
  		<center><h1>添加用户</h1></center>
  	</div>
  	<div id=h2>
	   <form action="AddStudent" method="post">
		  用户名<br>
		  <textarea rows="2" cols="40" name="name">张三</textarea><br>
		   密码<br><textarea rows="10" cols="40" name="password">123456</textarea><br>
		   <input type="submit" value="修改并保存"/>
		   <font color="greed">${requestScope.msg }</font>
	</form>
	 </div>
  </body>
</html>

