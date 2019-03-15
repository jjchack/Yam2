package cn.yc.yam.dao;

import java.util.List;

import cn.yc.yam.entitly.Detail;
import cn.yc.yam.entitly.Goods;
import cn.yc.yam.entitly.Shopping;
import cn.yc.yam.entitly.User;

public interface IUserDao {
	/*
	 * ��¼
	 */
	User findByNameAndPwd(User user);
	
	/*
	 * ��ȡ���ﳵ
	 */
	List<Shopping> getShopping(int userid);
	/*
	 * ���빺�ﳵͬʱ�������ݿ�
	 */
	boolean addShopping(Shopping shop);
	
	/*
	 * ɾ�����ﳵ����
	 */
	boolean deletShopping(int shoppingid);
	/*
	 * ���㲢��չ��ﳵ�������嵥
	 */
	int settlement(int userid,List<Shopping> list);
	/*
	 * ��չ��ﳵ
	 */
	boolean deleteshoplist(int userid);
	/*
	 * �ѹ��ﳵ���ݼ����嵥
	 */
	boolean addDetail(int userid,String goodsnamecount,int pricecount);
	/*
	 * �鿴�嵥
	 */
	List<Detail> getDetailfromUser(int userid);
	/*
	 * ע��
	 */
	boolean register(User user);
	/*
	 * �����û������ȡ��ͬ������Ʒ
	 */
	List<Goods> getDiffGoods(String goodstype);
	/*
	 * ͨ��goods id��ȡ��Ʒ��ϸ����
	 * 
	 */
	Goods getSingleById(int goodsid);
	/**
	 * ģ����ѯ
	 */
	List<Goods> selectGoodsByInfo(String str);
}
