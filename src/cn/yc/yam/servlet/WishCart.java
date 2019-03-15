package cn.yc.yam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.entitly.Shopping;
import cn.yc.yam.entitly.SingleShopinfo;
import cn.yc.yam.entitly.User;
import cn.yc.yam.service.IUserService;
import cn.yc.yam.service.impl.UserService;

public class WishCart extends HttpServlet {

	private IUserService userservice = new UserService();
	private List<SingleShopinfo> wishlist;
	private SingleShopinfo singleshop;
	private int accountprice;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userinfo");
		if(user==null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else{
			String kind = request.getParameter("kind");
			List<Shopping> list = userservice.getShopping(user.getId());
			wishlist = new ArrayList<SingleShopinfo>();
			if(list != null){
				accountprice = 0;
				for(Shopping s : list){
					singleshop = new SingleShopinfo();
					singleshop.setId(s.getId());
					singleshop.setUserid(s.getUserid());
					singleshop.setGoodsname(s.getGoodsname().split("###")[0]);
					singleshop.setGoodsnum(Integer.valueOf(s.getGoodsname().split("###")[1]));
					singleshop.setGoodsid(Integer.valueOf(s.getGoodsname().split("###")[2]));
					singleshop.setSingleprice(s.getPrice());
					singleshop.setTotalprices(singleshop.getGoodsnum()*singleshop.getSingleprice());
					accountprice = accountprice + singleshop.getTotalprices();
					wishlist.add(singleshop);
				}
				request.getSession().setAttribute("wishlist", wishlist);
				request.getSession().setAttribute("accountprice", accountprice);
			}
			else{
				request.getSession().setAttribute("wishlist", null);
			}
			if(kind.equals("1")){
				request.getRequestDispatcher("/wishlist.jsp").forward(request, response);
			}
			else if(kind.equals("2")){
				request.getRequestDispatcher("/close_account.jsp").forward(request, response);
			}
			
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
