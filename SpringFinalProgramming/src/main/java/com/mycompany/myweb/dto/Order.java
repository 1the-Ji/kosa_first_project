package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//이명진
public class Order {
	
	private int oid;		//주문 아이디(시퀀스)
	private int ototalprice;//총 주문 금액
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date otime;		//주문 날짜
	private String howpay;
	private int user_id;	//회원 아이디
	private int sid;
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	public String getHowpay() {
		return howpay;
	}
	public void setHowpay(String howpay) {
		this.howpay = howpay;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}
