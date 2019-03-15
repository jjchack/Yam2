package cn.yc.yam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.service.IUserService;
import cn.yc.yam.service.impl.UserService;

public class DeleteShopById extends HttpServlet {

	private IUserService userservice = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("shoppingid"));
		boolean flag = userservice.deletShopping(id);
		if(flag){
			request.getRequestDispatcher("/WishCart").forward(request, response);
		}
	}

	

}
