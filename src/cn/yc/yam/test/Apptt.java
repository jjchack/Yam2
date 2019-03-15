package cn.yc.yam.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.yc.yam.dao.IUserDao;
import cn.yc.yam.dao.impl.AdminDao;
import cn.yc.yam.dao.impl.UserDao;
import cn.yc.yam.entitly.Admin;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.Shopping;
import cn.yc.yam.service.IAdminService;
import cn.yc.yam.service.IUserService;
import cn.yc.yam.service.impl.AdminService;
import cn.yc.yam.service.impl.UserService;
import cn.yc.yam.utils.JdbcUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Apptt {

	private IUserDao userdao = new UserDao();
	private IAdminService adminservice = new AdminService();
	private IUserService userservice = new UserService();
	@Test
	public void test1() throws Exception {
		UserDao userdao = new UserDao();
		userdao.deleteshoplist(1);
	}
	@Test
	public void test2() throws Exception {
		UserDao userdao = new UserDao();
		Shopping shop = new Shopping();
		shop.setUserid(2);
		shop.setGoodsname("sss55");
		shop.setPrice(2233);
		userdao.addShopping(shop);
	}
	@Test
	public void test3() throws Exception {
		AdminDao dao = new AdminDao();
		Admin a = new Admin();
		a.setName("1");
		a.setPassword("1");
		Admin admin = dao.findByNameAndPwd(a);
		System.out.println(admin.getId());
	}
	@Test
	public void test4() throws Exception {
		Connection conn = (Connection) JdbcUtils.getDataSource().getConnection();
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement("select * from admin where name='1' and password='1'");
		pstm.executeUpdate();
	}
	@Test
	public void test5() throws Exception {
		String uri = "";
	}
	@Test
	public void test6() throws Exception {
		String sql = "select * from detail";
		List<Detail> list = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Detail>(Detail.class));
		for(Detail d : list){
			System.out.println(d.getGoodsname_num());
		}
	}
	@Test
	public void test7() throws Exception {
		List<Goods> list = adminservice.getIndexBigImg();
		for(Goods g : list){
			String url = "http://localhost:8080/Yam/goodsimg";
			String uri = g.getImgurl();
			String bigimgurl = url + uri.substring(uri.lastIndexOf("//")+1, uri.length());
			System.out.println(bigimgurl);
		}
		
	}
	@Test
	public void test8() throws Exception {
		//List<Goods> list = adminservice.getIndexSmallImg();
		Goods g = new Goods();
		Goods g1 = new Goods();
		Goods g2 = new Goods();
		List<Goods> list = new ArrayList<Goods>();
		list.add(g2);
		list.add(g1);
		list.add(g);
		System.out.println(list);
		/*for(Goods g : list){
			String url = "http://localhost:8080/Yam/goodsimg";
			String uri = g.getImgurl();
			String smallimgurl = url + uri.substring(uri.lastIndexOf("//")+1, uri.length());
			g.setImgurl(smallimgurl);
			System.out.println(g.getImgurl());
		}*/
	}
	@Test
	public void test9() throws Exception {
		String goodstype = "Ìú¹÷É½Ò©";
		List<Goods> list = userservice.getDiffGoods(goodstype);
		for(Goods g : list){
			System.out.println(g.getId()+g.getName()+g.getImgurl());
		}
	}
	@Test
	public void test10() throws Exception {
		Goods g = userservice.getSingleById(12);
		System.out.println(g.getId()+g.getName()+g.getImgurl());
	}
	@Test
	public void test11() throws Exception {
		String a = "Îå¹ÈÔÓÁ¸###1";
		String b = a.split("###")[1];
		System.out.println(a.split("###")[1]);
	}
	@Test
	public void test12() throws Exception {
		String str = "É½Ò©";
		List<Goods> list = userdao.selectGoodsByInfo(str);
		for(Goods g : list){
			System.out.println(g.getName());
		}
	}
}


