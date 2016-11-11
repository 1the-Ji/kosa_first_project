package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MenuDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dao.OrderReceiptDao;
//이명진
@Component
public class OrderReceiptService {
	
	public static final int INSERT_SUCCESS = 1;
	public static final int INSERT_FAIL = 0;
	
	public static final int UPDATE_SUCCESS = 1;
	public static final int PUDATE_FAIL = 0;
	
	public static final int DELETE_SUCCESS = 1;
	public static final int DELETE_FAIL = 0;
	
	@Autowired
	OrderReceiptDao orderReceiptDao;
	
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	OrderDao orderDao;
	
	//최종 주문 리스트(영수증) 삽입
	
	//최종 주문 리스트(영수증) 검색
	
	//최종 주문 리스트(영수증) 수정
	
	//최종 주문 리스트(영수증) 삭제
	
}
