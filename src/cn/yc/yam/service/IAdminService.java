package cn.yc.yam.service;


import java.util.List;

import cn.yc.yam.entitly.Admin;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.User;
import cn.yc.yam.utils.PageBean;

public interface IAdminService {

	/*
	 * 登录
	 */
	Admin findByNameAndPwd(Admin admin);
	/*
	 * 修改密码
	 */
	boolean modifyPwd(Admin admin);
	/*
	 * 上传商品
	 */
	boolean upGoods(Goods goods);
	/*
	 * 获取所有商品,查看用户购买记录,查看用户
	 */
	public void getAllDetail(PageBean<Detail> pb);
	public void getAllGoods(PageBean<Goods> pb);
	public void getAllUser(PageBean<User> pb);
	/*
	 * 删除商品
	 */
	boolean deletGoods(int id);
	public int getTotalCount(String str);
	/*
	 * 查询并更新首页大图
	 */
	List<Goods> getIndexBigImg();
	/*
	 * 获取四类小图
	 */
	List<Goods> getIndexSmallImg();
}
