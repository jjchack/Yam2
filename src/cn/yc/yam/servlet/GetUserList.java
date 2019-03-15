package cn.yc.yam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yc.yam.entitly.User;
import cn.yc.yam.service.IAdminService;
import cn.yc.yam.service.impl.AdminService;
import cn.yc.yam.utils.PageBean;

public class GetUserList extends HttpServlet {

	private IAdminService adminservice = new AdminService();
	private String uri;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String currPage = request.getParameter("currentPage");
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
			}
			int currentPage = Integer.parseInt(currPage);
			PageBean<User> pageBean = new PageBean<User>();
			pageBean.setCurrentPage(currentPage);
			adminservice.getAllUser(pageBean);   // ��pageBean�Ѿ���dao��������ݡ�
			request.getSession().setAttribute("pageBean", pageBean);
			uri = "/admin/listuser.jsp";
		} catch (Exception e) {
			e.printStackTrace();  // ����ʹ��
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

}
