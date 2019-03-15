package cn.yc.yam.entitly;

import java.util.Date;

public class Detail {
	private int id;
	private int userid;
	private String goodsname_num;
	private Date time;
	private int tallprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getGoodsname_num() {
		return goodsname_num;
	}
	public void setGoodsname_num(String goodsname_num) {
		this.goodsname_num = goodsname_num;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getTallprice() {
		return tallprice;
	}
	public void setTallprice(int tallprice) {
		this.tallprice = tallprice;
	}
	
	
}
