package com.mycompany.myweb.dto;

public class Sphoto {
	
	private int spic_id;			//sphoto id(시퀀스)
	private String spic_savedfile;	//매장 사진 세이브 파일
	private String spic_mimetype;	//매장 사진 확장자
	private int sid;				//매장 아이디(시퀀스)
	
	public int getSpic_id() {
		return spic_id;
	}
	public void setSpic_id(int spic_id) {
		this.spic_id = spic_id;
	}
	public String getSpic_savedfile() {
		return spic_savedfile;
	}
	public void setSpic_savedfile(String spic_savedfile) {
		this.spic_savedfile = spic_savedfile;
	}
	public String getSpic_mimetype() {
		return spic_mimetype;
	}
	public void setSpic_mimetype(String spic_mimetype) {
		this.spic_mimetype = spic_mimetype;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}
