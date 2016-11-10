package com.mycompany.myweb.dto;

import java.util.Date;

/*import org.springframework.format.annotation.DateTimeFormat;*/

public class Order {
	
	//1109김정호
	private int oid;		//주문 아이디(시퀀스)
	private int oordercount;	//갯수
	private int ototalprice;//총 주문 금액
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date otime;		//주문 날짜
	private int xid;		//엑스트라 아이디
	private int mid;		//메뉴 아이디
	private int user_id;	//회원 아이디
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getOordercount() {
		return oordercount;
	}
	public void setOordercount(int oordercount) {
		this.oordercount = oordercount;
	}
	public int getOtotalprice() {
		return ototalprice;
	}
	public void setOtotalprice(int ototalprice) {
		this.ototalprice = ototalprice;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public int getXid() {
		return xid;
	}
	public void setXid(int xid) {
		this.xid = xid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
