package cn.yc.yam.service;


import java.util.List;

import cn.yc.yam.entitly.Admin;
import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.User;
import cn.yc.yam.utils.PageBean;

public interface IAdminService {

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
	 * ��ȡ������Ʒ,�鿴�û������¼,�鿴�û�
	 */
	public void getAllDetail(PageBean<Detail> pb);
	public void getAllGoods(PageBean<Goods> pb);
	public void getAllUser(PageBean<User> pb);
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
