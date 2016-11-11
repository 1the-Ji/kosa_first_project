package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MenuDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dao.OrderReceiptDao;
import com.mycompany.myweb.dto.OrderReceipt;
//이명진
@Component
public class OrderReceiptService {
	
	public static final int INSERT_SUCCESS = 1;
	public static final int INSERT_FAIL = 0;
	
	public static final int UPDATE_SUCCESS = 1;
	public static final int UPDATE_FAIL = 0;
	
	public static final int DELETE_SUCCESS = 1;
	public static final int DELETE_FAIL = 0;
	
	@Autowired
	OrderReceiptDao orderReceiptDao;
	
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	OrderDao orderDao;
	
	//최종 주문 리스트(영수증) 추가
	public int writeMidOid(OrderReceipt orderreceipt){
		if(orderReceiptDao.insertMidOid(orderreceipt)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	
	//최종 주문 리스트(영수증) 찾기(1개 주문 상세 검색)
	public OrderReceipt oneMidOid(OrderReceipt orderreceipt){
		return orderReceiptDao.selectByMidOid(orderreceipt);
	}
	
	//최종 주문 리스트(영수증) 찾기(모든 주문 검색)
	public List<OrderReceipt> allMidOid(int pageNo, int rowsPerPage){
		return orderReceiptDao.selectByMidOidAll(pageNo,rowsPerPage);
	}
	
	//최종 주문 리스트(영수증) 고치기
	public int modifyMidOid(OrderReceipt orderreceipt){
		if(orderReceiptDao.updateMidOid(orderreceipt)==1){
			return UPDATE_SUCCESS;
		}
		return UPDATE_FAIL;
	}
	
	//최종 주문 리스트(영수증) 제거
	public int removeMidOid(OrderReceipt orderreceipt){
		if(orderReceiptDao.deleteMidOid(orderreceipt)==1){
			return DELETE_SUCCESS;
		}
		return DELETE_FAIL;
	}
	
	//최종 주문 리스트(영수증) 카운트
	public int countMidOid(){
		return orderReceiptDao.countMidOid();
	}
}
