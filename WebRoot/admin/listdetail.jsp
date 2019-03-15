<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <script type="text/javascript" src="js/jquery.js"></script>
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
<script type="text/javascript">
	$(function() {
		$("#delete").click(function() {
			$("#msg").html("<font color="red">正在处理</font>");
		});
	});
</script>

  </head>
  
  <style type="text/css">
		#h1{ 
		}
		#h2{ 
		}
	</style>
  <body>
  	<div id=h1>
  		<center><h1>用户购买记录</h1></center>
  	</div>
  	<div id=h2>
  	<table width="100%" align="center" border="0">
  			<tr>
  				<td>序号 </td>
  				<td>用户id</td>
  				<td>购买物品名字及数量</td>
  				<td>购买时间</td>
  				<td>总共花费</td>
  			</tr>
  			<hr>
	  		<c:forEach items="${sessionScope.pageBean.pageData }" var="detail" varStatus="varSta">
	  			<tr>
		  			<td>${varSta.count+(sessionScope.pageBean.currentPage-1)*sessionScope.pageBean.pageCount }</td>
		  			<td>${detail.userid }</td>
		  			<td>${detail.goodsname_num }</td>
		  			<td>${detail.time }</td>
		  			<td>${detail.tallprice }</td>
	  			</tr>
	  		</c:forEach> 
	  		<hr>
	  		<tr>
	  	 		<td><a href="${pageContext.request.contextPath }/GetUserDetail?currentPage=${sessionScope.pageBean.currentPage-1}">上一页</a></td>
	   			<td><a href="${pageContext.request.contextPath }/GetUserDetail?currentPage=${sessionScope.pageBean.currentPage+1}">下一页</a></td>
	   			<td> 第${sessionScope.pageBean.currentPage }页</td>
	   			<td>   共${sessionScope.pageBean.totalPage }页</td>
	   			<td><div id="msg">${msg}</div></td>
	   		</tr>
	   </table>
	 </div>
  </body>
</html>

