package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.ExtraDao;
import com.mycompany.myweb.dao.ExtraOrderDao;
import com.mycompany.myweb.dao.MenuDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dao.OrderItemDao;
import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.dto.Order;
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
	
	@Autowired
	ExtraOrderDao extraOrderDao;
	
	@Autowired
	ExtraDao extraDao;
	
	
	//1개 주문 품목 당 총 가격 구하기(메뉴+사이드)
	//MenuDao의 selectByMid(mid)쓰임
	//ExtraOrderDao의 selectByXidOid(extraorder)쓰임
	public int sumOnePrice(int mid, int xid){
		Menu menu = menuDao.selectByMid(mid);//어떤 메뉴인지
		Extra extra = extraOrderDao.selectByXid(xid);//어떤 사이드인지
		
		return menu.getMprice()+extra.getXprice();//하나의 품목에 대한 총 가격이며 주문 상세보기 - 가격 부분에 이용
		
	}
	
	//1개 주문 총 가격 구하기(주문 상세보기의 총가격 에 쓰임)
	public Order sumAllPrice(int oid, int mid, int xid){
		Order order = orderDao.selectByOid(oid);
		List<OrderItem> list = orderItemtDao.selectByOid(oid);
		int resultAllPrice = 0;
		
		for(int i=0;i<list.size();i++){
			Menu menu = menuDao.selectByMid(list.get(i).getMid());//어떤 메뉴인지
			Extra extra = extraDao.selectByXid(extraOrderDao.selectByOrid(list.get(i).getOrid()));
			resultAllPrice += menu.getMprice()+extra.getXprice();
		}
		order.setOtotalprice(resultAllPrice);
		return order;
		//하나의 품목에 대한 총 가격이 담긴 order 리턴
		//order가 뭐하면 int로 변환하면 됨
	}
	
	//1개 주문에 대해 같은 이름과 사이드를 갖는 품목을 카운트 하는 것(아메리카노 시럼추가 2개, 카페모카 샷추가 1개 이런식)
	public int countItem(){
		int countItem = 0;
		
		return countItem;
	}
	
	//1개 주문 품목 추가(MenuDao의 selectByMid(mid)쓰임)()
	public int writeOrid(OrderItem orderitem){
		if(orderItemtDao.insertOrid(orderitem)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	
	//1개 주문 품목 리스트 찾기(1개 주문 상세 검색 할 때 쓰임)
	public OrderItem oneOrid(int orid){
		return orderItemtDao.selectByOrid(orid);
	}
	
	//1개 주문 품목 리스트 찾기(모든 품목 검색 할 때 쓰임)
	public List<OrderItem> allMidOid(int pageNo, int rowsPerPage, int oid){
		return orderItemtDao.selectByOidAll(pageNo,rowsPerPage,oid);
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
