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

public class GetSingleById extends HttpServlet {

	private IUserService userservice = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int goodsid = Integer.valueOf(request.getParameter("goodsid"));
		Goods g = userservice.getSingleById(goodsid);
		String url = "http://localhost:8080/Yam/goodsimg";
		if(g != null){
			String uri = g.getImgurl();
			if(uri!=null){
				String smallimgurl = url + uri.substring(uri.lastIndexOf("//")+1, uri.length());
				g.setImgurl(smallimgurl);
			}
		}
		else{
			response.getWriter().write("该商品不存在。");
			return;
		}
		request.getSession().setAttribute("goods", g);
		List<Goods> similarlist = userservice.getDiffGoods(g.getType());
		List<Goods> similarlists = new ArrayList<Goods>();
		if(similarlist != null){
			for(int i=0; i<(similarlist.size()>2?3:similarlist.size()) ; i++){
				String uri1 = similarlist.get(i).getImgurl();
				if(uri1!=null){
					String smallimgurl = url + uri1.substring(uri1.lastIndexOf("//")+1, uri1.length());
					similarlist.get(i).setImgurl(smallimgurl);
					similarlists.add(similarlist.get(i));
				}
			}
		}
		request.getSession().setAttribute("similarlists", similarlists);
		request.getRequestDispatcher("/single.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
