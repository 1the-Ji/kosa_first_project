package com.mycompany.myweb.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Event {
	private int eid;
	//@DateTimeFormat(pattern="yyyy-MM-dd")//이명진
	private Date estartperiod;
	//@DateTimeFormat(pattern="yyyy-MM-dd")//이명진
	private Date elastperiod;
	private String econtents;
	private String esavedfile;
	private String emimetype;
	private int sid;
	private int mid;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Date getEstartperiod() {
		return estartperiod;
	}
	public void setEstartperiod(Date estartperiod) {
		this.estartperiod = estartperiod;
	}
	public Date getElastperiod() {
		return elastperiod;
	}
	public void setElastperiod(Date elastperiod) {
		this.elastperiod = elastperiod;
	}
	public String getEcontents() {
		return econtents;
	}
	public void setEcontents(String econtents) {
		this.econtents = econtents;
	}
	public String getEsavedfile() {
		return esavedfile;
	}
	public void setEsavedfile(String esavedfile) {
		this.esavedfile = esavedfile;
	}
	public String getEmimetype() {
		return emimetype;
	}
	public void setEmimetype(String emimetype) {
		this.emimetype = emimetype;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
	
}
