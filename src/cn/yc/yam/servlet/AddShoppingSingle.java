package cn.yc.yam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.Shopping;
import cn.yc.yam.entitly.User;
import cn.yc.yam.service.IUserService;
import cn.yc.yam.service.impl.UserService;

public class AddShoppingSingle extends HttpServlet {

	private IUserService userservice = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int goodsid = Integer.valueOf(request.getParameter("goodsid"));
		String goodsnum = request.getParameter("goodsnum");
		User userinfo = (User) request.getSession().getAttribute("userinfo");
		Goods goods = userservice.getSingleById(goodsid);
		Shopping shopping = new Shopping();
		shopping.setGoodsname(goods.getName()+"###"+goodsnum + "###" + goodsid);
		shopping.setUserid(userinfo.getId());
		shopping.setPrice(goods.getPrice());
		boolean flag = userservice.addShopping(shopping);
		if(flag){
			response.getWriter().write("true");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
