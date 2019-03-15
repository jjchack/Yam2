package cn.yc.yam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.entitly.Goods;
import cn.yc.yam.service.IUserService;
import cn.yc.yam.service.impl.UserService;

public class GetDiffGoods extends HttpServlet {

	private String uri;
	private IUserService userservice = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("userinfo")==null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else{
			String goodstype = request.getParameter("goodstype");
			List<Goods> diffimgurllist = new ArrayList<Goods>();
			List<Goods> goodslist = userservice.getDiffGoods(goodstype);
			request.getSession().setAttribute("requestname",goodstype );
			if(goodslist != null){
				for(Goods g : goodslist){
					String url = "http://localhost:8080/Yam/goodsimg";
					String uri = g.getImgurl();
					if(uri!=null){
						String smallimgurl = url + uri.substring(uri.lastIndexOf("//")+1, uri.length());
						g.setImgurl(smallimgurl);
						diffimgurllist.add(g);
					}
				}
			}
			request.getSession().setAttribute("diffimgurllist", diffimgurllist);
			uri = "/products.jsp";
			request.getRequestDispatcher(uri).forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	

}
