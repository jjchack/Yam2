package cn.yc.yam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.entitly.Admin;
import cn.yc.yam.service.IAdminService;
import cn.yc.yam.service.impl.AdminService;

public class AdminLogin extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin ad = new Admin();
		ad.setName(name);
		ad.setPassword(password);
		IAdminService adminservice = new AdminService();
		Admin admininfo = adminservice.findByNameAndPwd(ad);
		if(admininfo!=null){
			request.getSession().setAttribute("admininfo",admininfo );
			response.sendRedirect("/Yam/admin/adminindex.jsp");
		}else{
			String error = "用户名或密码错误！！";
			request.getSession().setAttribute("error",error );
			response.sendRedirect("/Yam/admin/adminlogin.jsp");
		}
	}

}
