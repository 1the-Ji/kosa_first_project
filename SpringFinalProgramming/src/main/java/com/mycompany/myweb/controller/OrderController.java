package com.mycompany.myweb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.DetailOrder;
import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.ExtraOrder;
import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.dto.Order;
import com.mycompany.myweb.dto.OrderItem;
import com.mycompany.myweb.service.ExtraOrderService;
import com.mycompany.myweb.service.ExtraService;
import com.mycompany.myweb.service.MenuService;
import com.mycompany.myweb.service.OrderItemService;
import com.mycompany.myweb.service.OrderService;
import com.mycompany.myweb.service.StoreService;

//이명진
@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	ExtraOrderService extraOrderService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	ExtraService extraService;
	
	@Autowired
	StoreService storeService;
	
	//주문전체 내역 페이지
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(String pageNo,Model model,HttpSession session){
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		}else{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		int totalBoardNo = orderService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage+((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup+((totalPageNo%pagesPerGroup!=0)?1:0);
		int groupNo = (intPageNo-1)/pagesPerGroup+1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Order> list = orderService.listAll(intPageNo, rowsPerPage);
		
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		
		model.addAttribute("list", list);
		
		return "order/list";
	}

	//주문내역 기간보기
	@RequestMapping(value="/termList", method=RequestMethod.POST)
	public String termList(String date1, String date2, String pageNo, Model model, HttpSession session) throws ParseException{
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date term1 = transFormat.parse(date1);
		Date term2 = transFormat.parse(date2);
		
		logger.info(""+term1);
		logger.info(""+term2);
		
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		}else{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		int totalBoardNo = orderService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage+((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup+((totalPageNo%pagesPerGroup!=0)?1:0);
		int groupNo = (intPageNo-1)/pagesPerGroup+1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Order> list = orderService.listTerm(intPageNo, rowsPerPage, term1, term2);
		
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("list", list);
			
		return "order/termList";
	}
	
	//주문내역 상세보기(1개 주문 당)
	@RequestMapping(value="/detailList", method=RequestMethod.GET)
	public String detailList(String ogid, Model model){
		//1주문당 (품목, 수량, 사이드, 가격) -> 구해서 같이 넘겨야 됨
		List<OrderItem> orderItems = orderItemService.allOrderItemByOgid(ogid);
		List<DetailOrder> detailOrders = new ArrayList<>();
		
		int totalprice = 0 ;
		for(int i=0;i<orderItems.size();i++){
			DetailOrder detailOrder = new DetailOrder();
			String xname = ""; int itemprice = 0;
			
			Menu menu = menuService.info(orderItems.get(i).getMid());
			detailOrder.setMname(menu.getMname());//품목
			logger.info("품목:"+detailOrder.getMname());
			detailOrder.setSameItemCount(orderItems.get(i).getOrdercount());//수량
			logger.info("수량:"+detailOrder.getSameItemCount());
			itemprice += menu.getMprice();
			
			//주문 품목에 대한 모든 사이드 찾기
			List<ExtraOrder> extraOrders = extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid());
			logger.info("extraOrders.size(): "+extraOrders.size());
			
			for(int j=0;j<extraOrders.size();j++){
				Extra extra = extraService.info(extraOrders.get(j).getXid());
				xname += extra.getXname()+" ";
				itemprice += extra.getXprice();
			}
			detailOrder.setXname(xname);//사이드 이름들
			logger.info("사이드 이름들:"+detailOrder.getXname());
			
			
			int tempitemprice = itemprice*orderItems.get(i).getOrdercount();
			detailOrder.setSameItemPrice(tempitemprice);//1주문 동일 품목(메뉴 사이드) 가격
			totalprice += tempitemprice;
			logger.info("가격:"+detailOrder.getSameItemPrice());
			
			detailOrder.setTotalprice(totalprice);//1 주문 총가격
			detailOrder.setOghowpay(orderService.searchOne(ogid).getOghowpay());//결제 방법
			detailOrders.add(i,detailOrder);
		}
		
		model.addAttribute("detailOrders", detailOrders);
		
		
		
		return "order/detailList";
	}
	
	//주문하기(진행 중)
	@RequestMapping(value="/orderItems",method=RequestMethod.GET)
	public String orderForm(String pageNo, Model model,HttpSession session){
		//sid를 참조하는 mid를 통한 모든 메뉴 리스트를 model에 담아 넘겨야 함(주문 눌렀을 때 전체 보기)
		String sid = (String) session.getAttribute("login");
		
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = menuService.getCount();
		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Menu> list = menuService.list(intPageNo, rowsPerPage, sid);
		
		model.addAttribute("sid",sid);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "order/orderForm1";
	}
	
	
	//-------------------------------------------------------------------------------
	
	//메뉴 전체 검색
	@RequestMapping(value="/allMenuSearch",method=RequestMethod.GET)
	public String allMenuSearch(String pageNo, Model model,HttpSession session){
		return "redirect:/order/orderItems";
	}
	
	//메뉴 커피or티or디저트 검색 //메뉴 그룹 검색
	@RequestMapping(value="/someMenuSearchMgroup",method=RequestMethod.GET)
	public String someMenuSearchMgroup(String pageNo, Model model,HttpSession session, String mgroup){
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = menuService.getCount();
		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Menu> list = menuService.listByMgroup(intPageNo, rowsPerPage, mgroup);
		
		model.addAttribute("mgroup",mgroup);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "order/orderSearchMgroup";
	}
	
	//메뉴 키워드(이름) 검색
	@RequestMapping(value="/someMenuSearchMname",method=RequestMethod.POST)
	public String someMenuSearchMname(String pageNo, Model model,HttpSession session, String mname){
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
			
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = menuService.getCount();
		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Menu> list = menuService.listByMname(intPageNo, rowsPerPage, mname);
		
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "order/orderSearchMname";
	}
		
	
	//주문하기(진행 중)
	@RequestMapping(value="/orderItems2",method=RequestMethod.GET)
	public String orderForm2(String mname, Model model){
		List<Menu> menu = menuService.infoByMname(mname);
		model.addAttribute("menu", menu.get(0));
		
		return "order/orderForm2";
	}
	
	//주문하기(진행 중)
	@RequestMapping(value="/orderItems2",method=RequestMethod.POST)
	public String orderItems2(String mname,
			int ordercount,String hot_ice, 
			String xname1, String xname2, String xname3,HttpSession session){
		//ordercount는 맨 나중에 order_total 수정해야
		
		//logger.info("mname: "+mname);
		//logger.info("ordercount: "+ordercount);
		//logger.info("hot_ice: "+hot_ice);
		//logger.info("xname1: "+xname1);
		//logger.info("xname2: "+xname2);
		//logger.info("xname3: "+xname3);
		
		Menu menu = menuService.infoByMnameHot_Ice(mname, hot_ice);
		int mid = menu.getMid();
		logger.info("mid: "+mid);
		Extra extra1 = extraService.infoByXname(xname1);
		Extra extra2 = extraService.infoByXname(xname2);
		Extra extra3 = extraService.infoByXname(xname3);
		int xid1 = extra1.getXid();
		int xid2 = extra2.getXid();
		int xid3 = extra3.getXid();
		
		
		//Order_Total 테이블을 추가해야 함(ogid 유지해야 함)
		//앱에서 주문할 때 와야 하는 데이터(user_id, oghowpay)
		//위의 두 데이터는 임의의 테스트 데이터로 대체
		Order order = new Order();
		String sid = (String) session.getAttribute("login");
		//ogid(문자열) 만들기(sid+현재시간+랜덤 숫자)(안겹치게 하기 위해서)
		String ogid=null;
		if(session.getAttribute("ogid")==null){
			long time = System.currentTimeMillis(); double random = Math.random();
			ogid = ""+sid+time+random;
			session.setAttribute("ogid", ogid);
			//
			order.setOgid(ogid);
			order.setOgtotalprice(0);//우선 0으로 초기화 -> 주문이 완료되면 수정되게 함
			order.setUser_id("user1");
			order.setSid(sid);
			order.setOghowpay("카드 결제");
			orderService.addOrder(order);
			//logger.info("ogtotalprice : "+order.getOgtotalprice());
			//logger.info("ogtime : "+order.getOgtime());
			//logger.info("user_id : "+order.getUser_id());
			//logger.info("sid : "+order.getSid());
			//logger.info("oghowpay : "+order.getOghowpay());
			
			//
			logger.info("여기까지 옴1");
			logger.info("ogid : "+ogid);
			logger.info("mid : "+mid);
			logger.info("ordercount: "+ordercount);
		}else{
			ogid = (String) session.getAttribute("ogid");
		}
		
		
		//Order_Item 테이블을 추가해야 함
		orderItemService.addOrderItem(ogid, mid, ordercount);
		logger.info("여기까지 옴2");
		OrderItem orderItem = orderItemService.searchOrderItemByOgidMid(ogid,mid);
		
		
		//Extra_Order 테이블을 추가해야 함
		extraOrderService.addExtraOrder(xid1,orderItem.getOid());
		extraOrderService.addExtraOrder(xid2,orderItem.getOid());
		extraOrderService.addExtraOrder(xid3,orderItem.getOid());
		logger.info("여기까지 옴3");
		
		return "redirect:/order/orderItems";
	}
	
	//결제
	@RequestMapping(value="/orderpay",method=RequestMethod.GET)
	public String orderpay(){
		
		return "redirect:/order/list";
	}
	
}
