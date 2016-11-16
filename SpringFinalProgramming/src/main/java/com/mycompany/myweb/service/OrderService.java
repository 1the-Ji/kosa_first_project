package com.mycompany.myweb.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dto.EventMenu;
import com.mycompany.myweb.dto.Order;

@Component
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;

//----------------------------------------------------
	public static final int WRITE_SUCCESS=0;
	public static final int WRITE_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int REMOVE_SUCCESS=0;
	public static final int REMOVE_FAIL=0;
		
	Logger logo = Logger.getLogger(OrderService.class);
	
	//주문 추가
	public int write(Order order){
		int row = orderDao.insert(order);
		
		return WRITE_SUCCESS;
	}
	
	
	//주문 제거
	public int remove(int oid){
		int row = orderDao.delete(oid);
		if(row ==0){
			logo.info("삭제할 내용이 없습니다");
			return REMOVE_FAIL;
		}
		return REMOVE_SUCCESS;
	}
	
	//명진 수정
	//주문 전체 조회 (시간으로 조회해야함 ->수정중)
	public List<Order> list(int pageNo, int rowsPerPage){
		return orderDao.selectByPage(pageNo,rowsPerPage);
	} 
	
	//주문 카운트(명진)
	public int getCount(){
		return orderDao.count();
	}
}
