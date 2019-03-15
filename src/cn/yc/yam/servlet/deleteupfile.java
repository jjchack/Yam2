package cn.yc.yam.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteupfile extends HttpServlet {

private String result;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String imgurl = request.getParameter("imgurl");
	
		 File file = new File(imgurl);
		 if(file.exists()) {
			 file.delete();
			 result = "<font color='green'>以取消上传</font>";
		 }
		 else{
			 result = "<font color='red'>请上传图片</font>";
		 }
		 
		 out.write(result);
	 }
	

}
