package com.mycompany.myweb.dto;

//명진 - 어쩔 수 없이 만듬
public class DetailOrder {
	private String mname;
	private int sameItemCount;
	private String xname;
	private int sameItemPrice;
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
	
}
