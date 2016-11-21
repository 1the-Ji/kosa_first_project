package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderTime {
	@DateTimeFormat(pattern="yyyy-MM-dd-HH-mm-ss")
	private Date time1;//주문 날짜(중요!)
	
	@DateTimeFormat(pattern="yyyy-MM-dd-HH-mm-ss")
	private Date ogtime;//주문 날짜(중요!)
	
	@DateTimeFormat(pattern="yyyy-MM-dd-HH-mm-ss")
	private Date time2;//주문 날짜(중요!)

	public Date getTime1() {
		return time1;
	}

	public void setTime1(Date time1) {
		this.time1 = time1;
	}

	public Date getOgtime() {
		return ogtime;
	}

	public void setOgtime(Date ogtime) {
		this.ogtime = ogtime;
	}

	public Date getTime2() {
		return time2;
	}

	public void setTime2(Date time2) {
		this.time2 = time2;
	}
	
}
