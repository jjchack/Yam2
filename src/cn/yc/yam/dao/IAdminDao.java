package cn.yc.yam.dao;

import java.util.List;

import cn.yc.yam.entitly.Admin;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.utils.PageBean;

public interface IAdminDao {

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
	 * 获取所有商品,查看用户购买记录
	 */
	public <T> void getAll(PageBean<T> pb,Class<T> clazz,String str);
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
