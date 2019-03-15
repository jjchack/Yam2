package cn.yc.yam.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.service.impl.AdminService;

public class DeleteGoods extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "É¾³ýÊ§°Ü";
		String filePtah = request.getParameter("filepath");
		int id = Integer.parseInt(request.getParameter("id"));
		//String[] dir = filePtah.split("/");
		File f = new File(filePtah);
			if(f.exists()) {
				f.delete();
			}
			if(new AdminService().deletGoods(id)){
				msg = "É¾³ý³É¹¦";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/GetGoodsList").forward(request, response);
		}
		
	
}
