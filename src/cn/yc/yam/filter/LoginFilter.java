package cn.yc.yam.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yc.yam.entitly.Goods;
import cn.yc.yam.service.IAdminService;
import cn.yc.yam.service.impl.AdminService;

/**
 * 真对登录判断过滤器，若是已登录可访问，若果未登录不可访问
 * @author 森林之舞
 *未登录可直接访问的只有index.jsp
 */
public class LoginFilter implements Filter{

	private String resuri;
	private boolean flag = false;
	private IAdminService adminservie = new AdminService();
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String uri = request.getRequestURL().toString();
		String requestPath = uri.substring(uri.lastIndexOf("/")+1, uri.length());
		String otherPath = requestPath.substring(requestPath.lastIndexOf(".")+1, requestPath.length());
		int ifadmin = uri.indexOf("admin");
		//放行资源 index.jsp
		flag = false;
		//如果是首页则重新加载首页图片
		if("index.jsp".equals(requestPath)||"indexAfter.jsp".equals(requestPath)){
			System.out.println("开始");
			if(request.getSession().getAttribute("bigimgurllist")==null){
				getIndexImg(request);
				System.out.println("为空重插");
			}
			if(request.getSession().getAttribute("smallimgurllist")==null){
				getIndexSmall(request);
				System.out.println("为空重插");
			}
		}
		if("register.jsp".equals(requestPath)||"index.jsp".equals(requestPath)||"adminlogin.jsp".equals(requestPath)||!otherPath.equals("jsp")||"login.jsp".equals(requestPath)){
			chain.doFilter(request, response);
		}
		else{
			HttpSession session = request.getSession();
			if(session.getAttribute("userinfo")!=null||session.getAttribute("admininfo")!=null){
				chain.doFilter(request, response);
			}else{
				resuri = "/Yam/login.jsp";
				response.sendRedirect(resuri);
			}
			
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	public void getIndexImg(HttpServletRequest request){
		List<Goods> list = adminservie.getIndexBigImg();
		List<String> bigimgurllist = new ArrayList<String>();
		//http://localhost:8080/Yam/goodsimg/1453971588355.jpg bigimgurl
		for(Goods g : list){
			String url = "http://localhost:8080/Yam/goodsimg";
			String uri = g.getImgurl();
			String bigimgurl = url + uri.substring(uri.lastIndexOf("//")+1, uri.length());
			bigimgurllist.add(bigimgurl);
		}
		request.getSession().setAttribute("bigimgurllist", bigimgurllist);
	}
	
	public void getIndexSmall(HttpServletRequest request){
		List<Goods> list = adminservie.getIndexSmallImg();
		List<Goods> smallimgurllist = new ArrayList<Goods>();
		//http://localhost:8080/Yam/goodsimg/1453971588355.jpg bigimgurl
		if(list != null){
			for(Goods g : list){
				String url = "http://localhost:8080/Yam/goodsimg";
				String uri = g.getImgurl();
				if(uri!=null){
					String smallimgurl = url + uri.substring(uri.lastIndexOf("//")+1, uri.length());
					g.setImgurl(smallimgurl);
					smallimgurllist.add(g);
				}
			}
		}
		
		request.getSession().setAttribute("smallimgurllist", smallimgurllist);
	}
	
}
