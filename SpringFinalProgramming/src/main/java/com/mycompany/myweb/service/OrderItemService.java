package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MenuDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dao.OrderItemDao;
import com.mycompany.myweb.dto.OrderItem;
//이명진
@Component
public class OrderItemService {
	
	public static final int INSERT_SUCCESS = 1;
	public static final int INSERT_FAIL = 0;
	
	public static final int UPDATE_SUCCESS = 1;
	public static final int UPDATE_FAIL = 0;
	
	public static final int DELETE_SUCCESS = 1;
	public static final int DELETE_FAIL = 0;
	
	@Autowired
	OrderItemDao orderItemtDao;
	
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	OrderDao orderDao;
	
	//1개 주문 품목 추가
	public int writeOrid(OrderItem orderitem){
		if(orderItemtDao.insertOrid(orderitem)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	
	//1개 주문 품목 리스트 찾기(1개 주문 상세 검색 할 때 쓰임)
	public OrderItem oneOrid(OrderItem orderitem){
		return orderItemtDao.selectByOrid(orderitem);
	}
	
	//1개 주문 품목 리스트 찾기(모든 품목 검색 할 때 쓰임)
	public List<OrderItem> allMidOid(int pageNo, int rowsPerPage){
		return orderItemtDao.selectByOridAll(pageNo,rowsPerPage);
	}
	
	//1개 주문 품목 고치기(고치는게 아니라, 품목을 추가 삭제로 대체)(그러므로 수정은 필요 없음)
	/*public int modifyOrid(OrderItem orderitem){
		if(orderItemtDao.updateOrid(orderitem)==1){
			return UPDATE_SUCCESS;
		}
		return UPDATE_FAIL;
	}*/
	
	//1개 주문 품목 제거
	public int removeOrid(OrderItem orderitem){
		if(orderItemtDao.deleteOrid(orderitem)==1){
			return DELETE_SUCCESS;
		}
		return DELETE_FAIL;
	}
	
	//1개 주문 품목 카운트
	public int countOrid(){
		return orderItemtDao.countOrid();
	}
}
