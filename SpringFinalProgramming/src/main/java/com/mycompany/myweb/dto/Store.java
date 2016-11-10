package com.mycompany.myweb.dto;


public class Store {
	
	private String sid;		//매장아이디(아이디)
	private String semail;	//매장이메일
	private String spw;		//매장비밀번호
	private String sname;	//매장이름
	private String slocal;	//매장 지점명
	private String saddr;	//매장 주소
	private String stel;	//매장 전화번호
	private int sopen;		//매장 오픈시간
	private int sclosed;	//매장 문닫는시간
	private String sbeacon;	//비콘 번호
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSpw() {
		return spw;
	}
	public void setSpw(String spw) {
		this.spw = spw;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSlocal() {
		return slocal;
	}
	public void setSlocal(String slocal) {
		this.slocal = slocal;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public int getSopen() {
		return sopen;
	}
	public void setSopen(int sopen) {
		this.sopen = sopen;
	}
	public int getSclosed() {
		return sclosed;
	}
	public void setSclosed(int sclosed) {
		this.sclosed = sclosed;
	}
	public String getSbeacon() {
		return sbeacon;
	}
	public void setSbeacon(String sbeacon) {
		this.sbeacon = sbeacon;
	}
	
	
}
