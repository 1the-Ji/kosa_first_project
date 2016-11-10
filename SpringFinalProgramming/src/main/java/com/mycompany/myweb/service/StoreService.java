package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myweb.dao.StoreDao;
import com.mycompany.myweb.dto.Store;

public class StoreService {
	
	//1111 스토어 서비스 kjh
	
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS=0;
	public static final int LOGIN_FAIL_MID=1;
	public static final int LOGIN_FAIL_MPASSWORD=2;	

	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int WITHDRAW_SUCCESS=0;
	public static final int WITHDRAW_FAIL=1;
	
	@Autowired
	private StoreDao storeDao;
	
	public int join(Store store){
		storeDao.insert(store);
		return JOIN_SUCCESS;
	}
	
	public int login(String sid, String spw){
		
		Store store = storeDao.selectBySid(sid);
		if (store == null) {
			return LOGIN_FAIL_MID;
		} 
		
		if(store.getSpw().equals(spw) == false){
			//디비에 있는 비밀번호와 다름.
			return LOGIN_FAIL_MPASSWORD;
		}
		
		return LOGIN_SUCCESS;
	}
	
	public int logout(String sid){
		//회원 로그아웃
		return LOGOUT_SUCCESS;
	}
	
	public boolean isMid(String sid){
		//기존 회원 아이디 있는지 체크
		Store store = storeDao.selectBySid(sid);
		if (store==null) {
			return false;
		}//기존 회원 아이디가 없다.
		return true;
	}	

}
