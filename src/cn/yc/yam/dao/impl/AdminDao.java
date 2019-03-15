package cn.yc.yam.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.yc.yam.dao.IAdminDao;
import cn.yc.yam.entitly.Admin;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.utils.JdbcUtils;
import cn.yc.yam.utils.PageBean;

public class AdminDao implements IAdminDao{

	@Override
	public Admin findByNameAndPwd(Admin admin) {
		try {
			String sql = "select * from admin where name=? and password=?";
			return JdbcUtils.getQuerrRunner()
					.query(sql, 
							new BeanHandler<Admin>(Admin.class),
							admin.getName(),
							admin.getPassword()
							);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modifyPwd(Admin admin) {
		try {
			String sql = "update admin set password=? where id=?";
			int row = JdbcUtils.getQuerrRunner().update(sql, admin.getPassword(),admin.getId());
			if(row > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean upGoods(Goods goods) {
		String sql = "insert into goods(name,info,uptime,price,imgurl,type) values(?,?,?,?,?,?)";
		try {
			int row = JdbcUtils.getQuerrRunner().update(sql, goods.getName(),goods.getInfo(),new Date(goods.getUptime().getTime()),goods.getPrice(),goods.getImgurl(),goods.getType());
			if(row>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public <T> void getAll(PageBean<T> pb,Class<T> clazz,String str) {
		int totalCount = this.getTotalCount(str);
		pb.setTotalCount(totalCount);
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}
		else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1)*pb.getPageCount();
		int count = pb.getPageCount();
		String sql = "select * from "+str+" limit ?,?";
		try {
			List<T> pageData = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<T>(clazz), index,count);
			pb.setPageData(pageData);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}


	@Override
	public boolean deletGoods(int id) {
		String sql = "delete from goods where id=?";
		try {
			int row = JdbcUtils.getQuerrRunner().update(sql,id);
			if(row>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getTotalCount(String str) {
		String sql = "select count(*) from "+str;
		try {
			Long count = JdbcUtils.getQuerrRunner().query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Goods> getIndexBigImg() {
		String sql = "select * from goods where type='首页大图'";
		List<Goods> list = null;
		try {
			list = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> getIndexSmallImg() {
		String sql1 = "select * from goods where type='铁棍山药'";
		String sql2 = "select * from goods where type='五谷杂粮'";
		String sql3 = "select * from goods where type='干果干货'";
		String sql4 = "select * from goods where type='零食小吃'";
		List<Goods> list = new ArrayList<Goods>();
		Goods g1 = null;
		Goods g2 = null;
		Goods g3 = null;
		Goods g4 = null;
		try {
			g1 = JdbcUtils.getQuerrRunner().query(sql1, new BeanHandler<Goods>(Goods.class));
			g2 = JdbcUtils.getQuerrRunner().query(sql2, new BeanHandler<Goods>(Goods.class));
			g3 = JdbcUtils.getQuerrRunner().query(sql3, new BeanHandler<Goods>(Goods.class));
			g4 = JdbcUtils.getQuerrRunner().query(sql4, new BeanHandler<Goods>(Goods.class));
			if(g1 == null)
				g1 = new Goods();
			if(g2 == null)
				g2 = new Goods();
			if(g3 == null)
				g3 = new Goods();
			if(g4 == null)
				g4 = new Goods();
			list.add(g1);
			list.add(g2);
			list.add(g3);
			list.add(g4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
