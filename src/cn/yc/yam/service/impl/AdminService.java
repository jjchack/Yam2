package cn.yc.yam.service.impl;

import java.util.List;

import cn.yc.yam.dao.IAdminDao;
import cn.yc.yam.dao.impl.AdminDao;
import cn.yc.yam.entitly.Admin;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.User;
import cn.yc.yam.service.IAdminService;
import cn.yc.yam.utils.PageBean;

public class AdminService implements IAdminService{

	private static IAdminDao dao = new AdminDao();
	@Override
	public Admin findByNameAndPwd(Admin admin) {
		return dao.findByNameAndPwd(admin);
	}

	@Override
	public boolean modifyPwd(Admin admin) {
		return dao.modifyPwd(admin);
	}

	@Override
	public boolean upGoods(Goods goods) {
		return dao.upGoods(goods);
	}


	@Override
	public boolean deletGoods(int id) {
		return dao.deletGoods(id);
	}

	@Override
	public int getTotalCount(String str) {
		return dao.getTotalCount(str);
	}

	@Override
	public void getAllDetail(PageBean<Detail> pb) {
		dao.getAll(pb, Detail.class, "detail");
	}

	@Override
	public void getAllGoods(PageBean<Goods> pb) {
		dao.getAll(pb, Goods.class, "goods");
	}

	@Override
	public void getAllUser(PageBean<User> pb) {
		// TODO Auto-generated method stub
		dao.getAll(pb, User.class, "user");
	}

	@Override
	public List<Goods> getIndexBigImg() {
		return dao.getIndexBigImg();
	}

	@Override
	public List<Goods> getIndexSmallImg() {
		return dao.getIndexSmallImg();
	}

}
