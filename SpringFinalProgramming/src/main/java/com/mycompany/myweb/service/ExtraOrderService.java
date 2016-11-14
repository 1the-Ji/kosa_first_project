package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.ExtraDao;
import com.mycompany.myweb.dao.ExtraOrderDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dto.ExtraOrder;
import com.mycompany.myweb.dto.OrderItem;
//이명진
@Component
public class ExtraOrderService {
	
	public static final int INSERT_SUCCESS = 1;
	public static final int INSERT_FAIL = 0;
	
	public static final int UPDATE_SUCCESS = 1;
	public static final int UPDATE_FAIL = 0;
	
	public static final int DELETE_SUCCESS = 1;
	public static final int DELETE_FAIL = 0;
	
	@Autowired
	ExtraOrderDao extraOrderDao;
	
	@Autowired
	ExtraDao extraDao;
	
	@Autowired
	OrderDao orderDao;
	
	//한 주문 시 한 품목 추가
	public int writeXidOid(ExtraOrder extraorder){
		if(extraOrderDao.insertXidOid(extraorder)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	//한 주문 시 한 품목 찾기(1개 품목 상세 검색)
	public ExtraOrder oneXidOid(ExtraOrder extraorder){
		return extraOrderDao.selectByXidOid(extraorder);
	}
	//한 주문 시 한 품목 고치기
	/*public int modifyXidOid(OrderReceipt orderreceipt){
		if(orderReceiptDao.update(orderreceipt)==1){
			return UPDATE_SUCCESS;
		}
		return UPDATE_FAIL;
	}*/
	
	//한 주문 시 한 품목 제거
	public int removeXidOid(ExtraOrder extraorder){
		if(extraOrderDao.deleteXidOid(extraorder)==1){
			return DELETE_SUCCESS;
		}
		return DELETE_FAIL;
	}
}
