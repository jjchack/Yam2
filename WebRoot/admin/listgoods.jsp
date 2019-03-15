<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
if(request.getSession().getAttribute("admininfo")==null){
	response.sendRedirect("/login.jsp");
	//request.getRequestDispatcher("/login.jsp").forward(request, response);
	
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listdata.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript" src="js/jquery.js"></script>
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
  		<center><h1>上传商品记录</h1></center>
  	</div>
  	<div id=h2>
  	<table width="100%" align="center" border="0">
  			<tr>
  				<td>商品序号 </td>
  				<td>商品名字</td>
  				<td>商品详情</td>
  				<td>商品种类</td>
  				<td>商品价格</td>
  				<td>商品上传时间</td>
  				<td>操作</td>
  			</tr>
  			<hr>
	  		<c:forEach items="${sessionScope.pageBean.pageData }" var="goods" varStatus="varSta">
	  			<tr>
		  			<td>${varSta.count+(sessionScope.pageBean.currentPage-1)*sessionScope.pageBean.pageCount }</td>
		  			<td>${goods.name }</td>
		  			<td>${goods.info }</td>
		  			<td>${goods.type }</td>
		  			<td>${goods.price }</td>
		  			<td>${goods.uptime }</td>
		  			<td><div id="delete"><a href="${pageContext.request.contextPath }/DeleteGoods?filepath=${goods.imgurl }&id=${goods.id}">下架</a></div></td>
	  			</tr>
	  		</c:forEach> 
	  		<hr>
	  		<tr>
	  	 		<td><a href="${pageContext.request.contextPath }/GetGoodsList?currentPage=${sessionScope.pageBean.currentPage-1}">上一页</a></td>
	   			<td><a href="${pageContext.request.contextPath }/GetGoodsList?currentPage=${sessionScope.pageBean.currentPage+1}">下一页</a></td>
	   			<td> 第${sessionScope.pageBean.currentPage }页</td>
	   			<td>   共${sessionScope.pageBean.totalPage }页</td>
	   			<td><div id="msg">${msg}</div></td>
	   		</tr>
	   </table>
	 </div>
  </body>
</html>

