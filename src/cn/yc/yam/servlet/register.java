package cn.yc.yam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.entitly.User;
import cn.yc.yam.service.IUserService;
import cn.yc.yam.service.impl.UserService;

public class register extends HttpServlet {

	private IUserService userservice = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phone = request.getParameter("phone");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User();
		u.setName(name);
		u.setPassword(password);
		u.setPhone(phone);
		boolean flag = userservice.register(u);
		if(flag){
			User user = userservice.findByNameAndPwd(u);
			if(user != null){
				request.getSession().setAttribute("userinfo", user);
				response.sendRedirect("/Yam/indexAfter.jsp");
			}
		}
	}

}
