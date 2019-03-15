package cn.yc.yam.dao;

import java.util.List;

import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.Shopping;
import cn.yc.yam.entitly.User;

public interface IUserDao {
	/*
	 * 登录
	 */
	User findByNameAndPwd(User user);
	
	/*
	 * 获取购物车
	 */
	List<Shopping> getShopping(int userid);
	/*
	 * 加入购物车同时加入数据库
	 */
	boolean addShopping(Shopping shop);
	
	/*
	 * 删除购物车内容
	 */
	boolean deletShopping(int shoppingid);
	/*
	 * 结算并清空购物车并加入清单
	 */
	int settlement(int userid,List<Shopping> list);
	/*
	 * 清空购物车
	 */
	boolean deleteshoplist(int userid);
	/*
	 * 把购物车内容加入清单
	 */
	boolean addDetail(int userid,String goodsnamecount,int pricecount);
	/*
	 * 查看清单
	 */
	List<Detail> getDetailfromUser(int userid);
	/*
	 * 注册
	 */
	boolean register(User user);
	/*
	 * 根据用户点击获取不同类型商品
	 */
	List<Goods> getDiffGoods(String goodstype);
	/*
	 * 通过goods id获取商品详细资料
	 * 
	 */
	Goods getSingleById(int goodsid);
	/**
	 * 模糊查询
	 */
	List<Goods> selectGoodsByInfo(String str);
}
