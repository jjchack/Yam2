package cn.yc.yam.dao;

import java.util.List;

import cn.yc.yam.entitly.Admin;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.utils.PageBean;

public interface IAdminDao {

	/*
	 * ��¼
	 */
	Admin findByNameAndPwd(Admin admin);
	/*
	 * �޸�����
	 */
	boolean modifyPwd(Admin admin);
	/*
	 * �ϴ���Ʒ
	 */
	boolean upGoods(Goods goods);
	/*
	 * ��ȡ������Ʒ,�鿴�û������¼
	 */
	public <T> void getAll(PageBean<T> pb,Class<T> clazz,String str);
	/*
	 * ɾ����Ʒ
	 */
	boolean deletGoods(int id);
	public int getTotalCount(String str);
	/*
	 * ��ѯ��������ҳ��ͼ
	 */
	List<Goods> getIndexBigImg();
	/*
	 * ��ȡ����Сͼ
	 */
	List<Goods> getIndexSmallImg();
}
