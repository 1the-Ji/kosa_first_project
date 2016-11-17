package com.mycompany.myweb.dto;

//이명진
public class OrderItem {
	private int orid;//OrderItem 테이블 아이디
	private int oid;//주문 아이디
	private int mid;//메뉴 아이디
	
	
	public int getOrid() {
		return orid;
	}
	public void setOrid(int orid) {
		this.orid = orid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
}
