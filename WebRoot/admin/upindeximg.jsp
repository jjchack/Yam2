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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updata.jsp' starting page</title>
    
    <meta name="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js" /></script>
	<script type="text/javascript" src="js/public.js"></script>
	<script src="js/jquery.searchMeme.js" type="text/javascript"></script>
	<!--调整图片大小  -->
	<script type="text/javascript">
    	$(function(){
    		$("#img1").each(function(){
    			$(this).css("width", 90);
    			$(this).css("height", 90);
    		});
    	})
    </script>
    <script src="js/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript">
    var imgurl = null;
    var ifup = false;
        $(function () {
            $(":button[name='upfile']").click(function () {
                if(ifup == false){
                	ajaxFileUpload();
                }
                else{
                	$("#msg").html("<font color='green'>您已经上传，不得重复上传，只有取消上传后，才能再次上传</font>");
                }
            });
            $(":button[name='deletefile']").click(function(){
            	deleteupfile();
            	var url = "${pageContext.request.contextPath}/GoodsUpLoad";
				var args = {"time":new Date()};
					$.get(url,args,function(data){
					});
            });
        });
        //上传文件操作
        function ajaxFileUpload() {
            $.ajaxFileUpload
            (
                {
                    url: '<%=basePath%>/GoodsUpLoad?fb=\'no\'', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'file1', //文件上传域的ID
                    dataType: 'jsonp', //返回值类型 一般设置为json
                    success: function (data, status){ //服务器成功响应处理函数
                    	var jsondata = JSON.parse(data);
	                   	ifup = true;
	                    if(jsondata.imgurl != "null") {
	                    imgurl = jsondata.uploadPath;
	                     $("#msg").html("<font color='green'>上传成功</font>");
	                     $("#img1").attr("src",jsondata.imgurl);
	                    }
	                    else{
	                     $("#msg").html("<font color='red'>请选择正确格式</font>");
	                    }
	                   	
	                    	
	                    },
	                    error: function (data, status, e)//服务器响应失败处理函数
	                    {	alert(e);
	                    	$("#msg").html("<font color='red'>请选择图片</font>");
	                    	ifup = false;
	                    }
                }
            )
            return false;
        }
        //删除文件操作
        function deleteupfile() {
        if(imgurl != null) {
        	var url = "<%=basePath%>/deleteupfile";
			var args = {
				"imgurl" : imgurl
			};
			$.post(url, args, function(data) {
				$("#msg").html(data);
			});
			imgurl = null;
			ifup = false;
			$("#img1").attr("src", "${pageContext.request.contextPath}/admin/images/wu.jpg");
		} else {
			$("#msg").html("<font color='red'>请上传图片</font>");
		}

	}
</script>
<!-- 发布按钮监控 -->
<script type="text/javascript">
	$(function(){
		$(":input[name='fbsubmit']").click(function(){
			var goodsname = $.trim($("#disHotel").val());
			var property1 = $.trim($("#property1").val());
			var desc = $.trim($(".texta").val());
			var price = $.trim($(".price").val());
				if(goodsname != "") {
					var url = "${pageContext.request.contextPath}/GoodsUpLoad";
					var args = {"fb":"ok","goodsname":goodsname,"property1":property1,"desc":"null","price":"0","time":new Date()};
					
					$.post(url,args,function(data){
						if(data == "true"){
					
							$("#fberror").html("<font color='greed'>发布成功，可继续发布</font>");
							<%request.getSession().setAttribute("bigimgurllist", null);%>
							alert("发布成功，可继续发布.");
							history.go(0);
						}else{
							$("#fberror").html("<font color='red'>发布失败，请与管理员联系</font>");
						}
					});
				}
				else{
					$("#fberror").html("<font color='red'>除了图片，其余必填</font>");
				}
		return false;
	});
	});
	
</script>
    
  </head>
	
  <body>
  		<div class="webIndex">
					<div class="stay-list clearFloat">
						<div class="stay-list-left">
							<span class="search-sign"></span>
							<div class="tupian">
								<div class="tupiantitle">上传图片</div>
								<div class="liulan">
									<tr>
										<input type="file" id="file1" name="file" />
									</tr>
								</div>
								<table border="0" class="table_img" class="table_img">
									<tr>
										<td class="yulan">图片预览</br></br></td>
										<td>
										</td>
									</tr>
									<tr>
										<td><img id="img1" src="${pageContext.request.contextPath}/admin/images/wu.jpg" width="200" />
										</td>
										<td ></td>
									</tr>
									<tr>
										<td><input name="upfile" type="button" value="上传" class="upfile"/> <input
											name="deletefile" type="button" value="取消上传" class="deletefile"/></td>
										<td><div id="msg"></div>
										</td>
									</tr>
								</table>
							</div>
							<form id="form1" name="form1" method="post" action="">

								<div class="sea-div">
									<label class="search-lab">图片名称</label><input type="text"
										placeholder="物品名称" class="hotel-name" id="disHotel" />
								</div>
								<div class="sea-div">
									<label class="search-lab">类别</label> 
									<select name="property1" id="property1"size="1" onChange="redirect(this.options.selectedIndex)"
										class="property1">
										<option value="首页大图">首页大图</option>
								</div>
								<input type="submit" class="search-but" name="fbsubmit" value="发布" />
							</form>
							<div  id="fberror" class="fberror"></div>
						</div>
						<div>说明：此页上传的是首页滚动大图，建议大小1000*350像素，上传结果同样可在“查看已上传的商品”中查看并删除。<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首页大图最少一张，用户可主动增添图片，系统会自动增添滚动。
						</div>
					</div>
				</div>
  </body>
</html>
