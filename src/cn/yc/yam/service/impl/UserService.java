package cn.yc.yam.service.impl;

import java.util.List;

import cn.yc.yam.dao.IUserDao;
import cn.yc.yam.dao.impl.UserDao;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.Shopping;
import cn.yc.yam.entitly.User;
import cn.yc.yam.service.IUserService;

public class UserService implements IUserService{

	private static IUserDao dao = new UserDao();
	@Override
	public User findByNameAndPwd(User user) {
		return dao.findByNameAndPwd(user);
	}

	@Override
	public List<Shopping> getShopping(int userid) {
		return dao.getShopping(userid);
	}

	@Override
	public boolean addShopping(Shopping shop) {
		return dao.addShopping(shop);
	}

	@Override
	public boolean deletShopping(int shoppingid) {
		return dao.deletShopping(shoppingid);
	}

	@Override
	public int settlement(int userid, List<Shopping> list) {
		return dao.settlement(userid, list);
	}

	@Override
	public boolean deleteshoplist(int userid) {
		return dao.deleteshoplist(userid);
	}

	@Override
	public boolean addDetail(int userid, String goodsnamecount, int pricecount) {
		return dao.addDetail(userid, goodsnamecount, pricecount);
	}

	@Override
	public List<Detail> getDetailfromUser(int userid) {
		return dao.getDetailfromUser(userid);
	}

	@Override
	public boolean register(User user) {
		return dao.register(user);
	}

	@Override
	public List<Goods> getDiffGoods(String goodstype) {
		return dao.getDiffGoods(goodstype);
	}

	@Override
	public Goods getSingleById(int goodsid) {
		return dao.getSingleById(goodsid);
	}

	@Override
	public List<Goods> selectGoodsByInfo(String str) {
		return dao.selectGoodsByInfo(str);
	}

}
