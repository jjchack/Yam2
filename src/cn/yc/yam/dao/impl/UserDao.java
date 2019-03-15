package cn.yc.yam.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.yc.yam.dao.IUserDao;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.Shopping;
import cn.yc.yam.entitly.User;
import cn.yc.yam.utils.JdbcUtils;

public class UserDao implements IUserDao{

	@Override
	public User findByNameAndPwd(User user) {
		try {
			String sql = "select * from user where name=? and password=?";
			return JdbcUtils.getQuerrRunner()
					.query(sql, 
							new BeanHandler<User>(User.class), 
							user.getName(),
							user.getPassword());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Shopping> getShopping(int userid) {
		String sql="select * from shopping where userid=?";
		try {
			List<Shopping> shoppinglist = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Shopping>(Shopping.class),userid);
			return shoppinglist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Shopping> list = new ArrayList<Shopping>();
		return list;
	}

	@Override
	public boolean addShopping(Shopping shop) {
		String sql = "insert into shopping(userid,goodsname,price) values(?,?,?)";
		try {
			int row = JdbcUtils.getQuerrRunner().update(sql, shop.getUserid(),shop.getGoodsname(),shop.getPrice());
			if(row>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletShopping(int shoppingid) {
		String sql = "delete from shopping where id=?";
		try {
			int row = JdbcUtils.getQuerrRunner().update(sql,shoppingid);
			if(row>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int settlement(int userid,List<Shopping> list) {
		int pricecount = 0;
		String goodsname = "";
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(Shopping shop : list){
			pricecount = pricecount + shop.getPrice();
			if(map.get(shop.getGoodsname())!= null){
				int value = map.get(shop.getGoodsname());
				map.put(goodsname, value++);
			}
			else{
				map.put(goodsname, 1);
			}
		}
		for(Entry<String, Integer> entry : map.entrySet()){
			goodsname = goodsname + entry.getKey() +"["+ entry.getValue() + "]";
		}
		addDetail(userid, goodsname, pricecount);
		return pricecount;
	}
	
	public boolean addDetail(int userid,String goodsnamecount,int pricecount){
		String sql = "insert into detail(userid,goodsname,time,tallprice) values(?,?,?,?)";
		Date date = new Date();
		try {
			int row = JdbcUtils.getQuerrRunner().update(sql, userid,goodsnamecount,new java.sql.Date(date.getTime()),pricecount);
			if(row>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<Detail> getDetailfromUser(int userid) {
		String sql="select * from detail where userid=?";
		try {
			List<Detail> detaillist = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Detail>(Detail.class),userid);
			return detaillist;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public boolean deleteshoplist(int userid) {
		String sql = "delete from shopping where userid=?";
		try {
			int row = JdbcUtils.getQuerrRunner().update(sql,userid);
			if(row>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		String sql = "insert into user(name,phone,password) values(?,?,?)";
		try {
			int row = JdbcUtils.getQuerrRunner().update(sql, user.getName(),user.getPhone(),user.getPassword());
			if(row>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Goods> getDiffGoods(String goodstype) {
		String sql="select * from goods where type="+ "'" + goodstype +"'";
		try {
			List<Goods> list = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Goods>(Goods.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public Goods getSingleById(int goodsid) {
		try {
			String sql = "select * from goods where id=?";
			return JdbcUtils.getQuerrRunner()
					.query(sql, 
							new BeanHandler<Goods>(Goods.class), 
							goodsid);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Goods> selectGoodsByInfo(String str) {
		String sql="select * from goods where name like '%"+ str +"%'";
		try {
			List<Goods> list = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Goods>(Goods.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}


}
