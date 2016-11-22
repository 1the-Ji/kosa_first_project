package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MenuDao;
import com.mycompany.myweb.dto.Menu;

@Component 
public class MenuService {
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> list(int pageNo, int rowsPerPage, String sid){
		
		/*if( != null){
			return menuDao.searchBySid(sid);
		}*/
		return menuDao.selectByPage(pageNo, rowsPerPage, sid);
	}
	
	//[명진]
	public List<Menu> listByMgroup(int pageNo, int rowsPerPage, String mgroup){

		return menuDao.selectByMgroup(pageNo, rowsPerPage, mgroup);
	}
	
	//[명진]
	public List<Menu> listByMname(int pageNo, int rowsPerPage, String mname){

		return menuDao.selectByMname(pageNo, rowsPerPage, mname);
	}
	
	//[명진]
	public Menu infoByMnameHot_Ice(String mname,String hot_ice){

		return menuDao.selectByMnameHot_Ice(mname,hot_ice);
	}
	
	//[명진]//지우게 될 듯
	public List<Menu> listByMid(int mid){

		return menuDao.selectByMidforList(mid);
	}
		
	public int write(Menu menu){
		menuDao.insert(menu);
		return WRITE_SUCCESS;
	}
	
	public int modify(Menu menu){
		int row = menuDao.update(menu);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int mid){
		int row = menuDao.delete(mid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}
	
	public Menu info(int mid){
		return menuDao.selectByMid(mid);
	}
	
	//[명진]
	public List<Menu> infoByMname(String mname){
		return menuDao.selectByMname(mname);
	}
	
	public int getCount(){
		return menuDao.count();
	}
}
