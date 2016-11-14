package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.ExtraDao;
import com.mycompany.myweb.dao.ExtraOrderDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dao.OrderItemDao;
import com.mycompany.myweb.dto.Extra;
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
	
	@Autowired
	OrderItemDao orderItemDao;
	
	//한 주문 시(매칭되는) 한 품목 사이드 상세 찾기
		public Extra orderItemExtra(int orid, ExtraOrder extraorder){
			int xid = extraOrderDao.selectByOrid(orderItemDao.selectByOrid(orid).getOrid());
			Extra extra = extraDao.selectByXid(xid);
		
			return extra;
		}
	
	/*//한 주문 시 한 품목 사이드 상세 찾기
	public ExtraOrder oneXidOid(ExtraOrder extraorder){
		return extraOrderDao.selectByXidOrid(extraorder);
	}*/
	
	//1개 주문 시 한 품목 사이드 추가(ExtraDao의 selectByXid(xid)쓰임)
	public int writeXidOid(ExtraOrder extraorder,int xid){
		
		//Extra extra = extraDao.selectByXid(xid);
		
		if(extraOrderDao.insertXidOrid(extraorder)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	
	
	
	//1개 주문 시 한 품목 사이드 고치기
	/*public int modifyXidOid(OrderReceipt orderreceipt){
		if(orderReceiptDao.update(orderreceipt)==1){
			return UPDATE_SUCCESS;
		}
		return UPDATE_FAIL;
	}*/
	
	//1개 주문 시 한 품목 사이드 제거
	public int removeXidOid(ExtraOrder extraorder){
		if(extraOrderDao.deleteXidOrid(extraorder)==1){
			return DELETE_SUCCESS;
		}
		return DELETE_FAIL;
	}
}
