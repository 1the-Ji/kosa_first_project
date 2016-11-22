package com.mycompany.myweb.dto;

//명진 - 어쩔 수 없이 만듬
public class DetailOrder {//1품목에 대한
	private String mname;//메뉴명
	private int sameItemCount;//수량
	private String xname;//사이드 이름들
	private int sameItemPrice;//가격
	private String oghowpay;//결제방식
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getSameItemCount() {
		return sameItemCount;
	}
	public void setSameItemCount(int sameItemCount) {
		this.sameItemCount = sameItemCount;
	}
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
	}
	public int getSameItemPrice() {
		return sameItemPrice;
	}
	public void setSameItemPrice(int sameItemPrice) {
		this.sameItemPrice = sameItemPrice;
	}
	public String getOghowpay() {
		return oghowpay;
	}
	public void setOghowpay(String oghowpay) {
		this.oghowpay = oghowpay;
	}
	
	
	
}
