package cn.yc.yam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.entitly.Admin;
import cn.yc.yam.service.IAdminService;
import cn.yc.yam.service.impl.AdminService;

public class modifyPwd extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IAdminService adminservice = new AdminService();
		String password = request.getParameter("password");
		Admin admin = (Admin) request.getSession().getAttribute("admininfo");
		admin.setPassword(password);
		boolean flag = adminservice.modifyPwd(admin);
		if(flag){
			response.sendRedirect("/Yam/admin/modifysuccess.jsp");
		}
	}

}
