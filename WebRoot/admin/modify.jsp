<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
if(request.getSession().getAttribute("admininfo")==null){
	response.sendRedirect("/login.jsp");
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form method="post" action="${pageContext.request.contextPath}/modifyPwd">
		用户名：${admininfo.name }<br><br><br>
		密    码：<input type="text" name="password" placeholder="填写修改的密码" required="required" /><br><br><br>
		<button type="submit" class="btn btn-primary btn-block btn-large">确定并修改</button>
	</form>
  </body>
</html>
