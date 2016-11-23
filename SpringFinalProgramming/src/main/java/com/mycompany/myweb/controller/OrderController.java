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
	
	//주문전체 내역 페이지(1차 검토 완료)
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(String pageNo,Model model,HttpSession session){
		
		//총 금액 order_total의 ogtotalprice에 넣어주기
		String ogid = (String) session.getAttribute("ogid");
		int resultprice = (Integer) session.getAttribute("resultprice");
		orderService.modifyOgprice(ogid, resultprice);
				
		
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

	//주문내역 기간보기(1차 검토 완료)
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
	
	//주문내역 상세보기(1개 주문 당)(검토 필요)
	@RequestMapping(value="/detailList", method=RequestMethod.GET)
	public String detailList(String ogid, Model model, HttpSession session){
		//1주문당 (품목, 수량, 사이드, 가격) -> 구해서 같이 넘겨야 됨
		//가격은 구매가 마칠 때 총 금액 구해서 업데이트 해줘야 됨
		
		List<OrderItem> orderItems = orderItemService.allOrderItemByOgid(ogid);
		List<DetailOrder> detailOrders = new ArrayList<>();
		
		 //int resultprice = 0;
		for(int i=0;i<orderItems.size();i++){
			DetailOrder detailOrder = new DetailOrder();
			String xname = "";//1품목 모든 사이드 이름들 
			int itemOneprice = 0;//1품목 총 금액 //int itemprice = 0;
			
			Menu menu = menuService.info(orderItems.get(i).getMid());//메뉴명
			detailOrder.setMname(menu.getMname());//1품목 메뉴명 보존하기
			logger.info("품목:"+detailOrder.getMname());
			
			detailOrder.setSameItemCount(orderItems.get(i).getOrdercount());//1품목 수량 보존하기
			logger.info("수량:"+detailOrder.getSameItemCount());
			
			itemOneprice += menu.getMprice();
			
			//주문 품목에 대한 모든 사이드 찾기
			List<ExtraOrder> extraOrders = extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid());
			for(int j=0;j<extraOrders.size();j++){
				Extra extra = new Extra();
				extra =	extraService.info(extraOrders.get(j).getXid());
				xname += extra.getXname()+" ";//1품목 사이드 이름 더하기
				itemOneprice += extra.getXprice();//1품목 사이드 가격 더하기
			}
			detailOrder.setXname(xname);//더해진 사이드 이름들 보존하기
			logger.info("사이드 이름들:"+detailOrder.getXname());
			
			//1품목의 총 금액
			itemOneprice = itemOneprice*detailOrder.getSameItemCount();
			detailOrder.setSameItemPrice(itemOneprice);//1품목 총 금액 보존하기
			logger.info("가격:"+detailOrder.getSameItemPrice());
			
			detailOrder.setOghowpay(orderService.searchOne(ogid).getOghowpay());//결제 방법
			
			detailOrders.add(i,detailOrder);
			
			/*int tempitemprice = itemprice*orderItems.get(i).getOrdercount();
			detailOrder.setSameItemPrice(tempitemprice);//1주문 동일 품목(메뉴 사이드) 가격
			totalprice += tempitemprice;
			resultprice += totalprice;*/
			
			//detailOrder.setTotalprice(totalprice);//1 주문 총 가격
			
		}
		model.addAttribute("detailOrders", detailOrders);
		
		int resultprice=0;
		for(int i=0;i<detailOrders.size();i++){
				resultprice += detailOrders.get(i).getSameItemPrice();
			}
		
		//1주문 총 금액 저장 및 JSP에 보내기
		session.setAttribute("resultprice", resultprice);
		model.addAttribute("resultprice", resultprice);
		
		/*//총 금액 order_total의 ogtotalprice에 넣어주기
		orderService.modifyOgprice(ogid, resultprice);
		*/
		return "order/detailList";
	}
	
	
	
	//---------------------------------------------------------------------
	int count = 0;
	//주문하기(진행 중)(검토 필요)(중요)(여기서부터 주문의 시작!)
	@RequestMapping(value="/orderItems",method=RequestMethod.GET)
	public String orderForm(String pageNo, Model model, HttpSession session){
		int flag = (Integer) session.getAttribute("flag");
		count = flag;
		session.setAttribute("flag",1);
		
		//sid를 참조하는 mid를 통한 모든 메뉴 리스트를 model에 담아 넘겨야 함(주문 눌렀을 때 전체 보기)
		String sid = (String) session.getAttribute("login");
		
		count++;
		
		if(count==1){			
			//새로운 ogid 여기서 부터 생성되야 함
			//sid, ogid 유지되야 함
			//ogid(문자열) 만들기(sid+현재시간+랜덤 숫자)(안겹치게 하기 위해서)
			session.setAttribute("ogid",null);
			String ogid= null;
			
			long time = System.currentTimeMillis(); double random = Math.random();
			ogid = ""+sid+time+random;
			session.setAttribute("ogid", ogid);		
			
			//나중에 새로고침 계속 했을 때 쓸모없는 주문 데이터 삽입을 방지하기 위해서
			//totalprice가 0인 order_table 데이터는 지울 수 있는 코드 삽입(중요!!!)
			
			//Order_Total 테이블을 추가해야 함
			//앱에서 주문할 때 와야 하는 데이터(user_id, oghowpay)(중요!!!!!!!!!!!!!!!!!!!!)
			//위의 두 데이터는 임의의 테스트 데이터(user_id, oghowpay)로 대체
			Order order = new Order();	
			ogid = (String) session.getAttribute("ogid");	
			
			order.setOgid(ogid);
			order.setOgtotalprice(0);//우선 0으로 초기화 -> 주문이 완료되면 수정되게 함
			order.setUser_id("user1");//임의 데이터
			order.setSid(sid);
			order.setOghowpay("카드 결제");//임의 데이터
			
			orderService.addOrder(order);
		}
		

		//---------
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
		
		List<Menu> menuList = menuService.list(intPageNo, rowsPerPage, sid);
		logger.info("intPageNo : "+intPageNo);
		logger.info("rowsPerPage : "+rowsPerPage);
		
		model.addAttribute("sid",sid);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		
		model.addAttribute("menuList", menuList);
		
		return "order/orderForm1";
	}
	
	//메뉴 전체 검색(1차 검토 완료)
	@RequestMapping(value="/allMenuSearch",method=RequestMethod.GET)
	public String allMenuSearch(String pageNo, Model model,HttpSession session){
		return "redirect:/order/orderItems";
	}
	
	//메뉴 커피or티or디저트 검색 //메뉴 그룹 검색(1차 검토 완료)
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
	
	//메뉴 키워드(이름) 검색(1차 검토 완료)
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
	
	//주문하기(진행 중)(검토 필요)(중요)
	@RequestMapping(value="/orderItems2",method=RequestMethod.GET)
	public String orderForm2(String mname, Model model){
		List<Menu> menu = menuService.infoByMname(mname);
		model.addAttribute("menu", menu.get(0));
		
		return "order/orderForm2";
	}
	
	//주문하기(진행 중)(검토 필요)(중요)
	@RequestMapping(value="/orderItems2",method=RequestMethod.POST)
	public String orderItems2(
			String mname,int ordercount,String hot_ice, 
			String xname1, String xname2, String xname3,
			HttpSession session){
		
		//ordercount는 맨 나중에 order_total 수정해야
		//나중에 xname1,2,3 모두 안와도 널 포인터 익셉션 에러 안나도록 코드 수정(중요!!!)
		
		//실제 정확한 메뉴가 뭔지 알기 위해
		Menu menu = menuService.infoByMnameHot_Ice(mname, hot_ice);
		int mid = menu.getMid();
		
		//사이드 이름들에 대한 사이드들이 뭔지 찾기 위해
		Extra extra1 = extraService.infoByXname(xname1);
		Extra extra2 = extraService.infoByXname(xname2);
		Extra extra3 = extraService.infoByXname(xname3);
		int xid1 = extra1.getXid();
		int xid2 = extra2.getXid();
		int xid3 = extra3.getXid();
		
		//------------------------------------------------------------
		//ogid 얻기
		String ogid = (String) session.getAttribute("ogid");
		
		//Order_Item 테이블을 추가하고 다시 찾는 부분
		orderItemService.addOrderItem(ogid, mid, ordercount);
		OrderItem orderItem = orderItemService.searchOrderItemByOgidMid(ogid,mid);
		
		//Extra_Order 테이블을 추가하는 부분
		extraOrderService.addExtraOrder(xid1,orderItem.getOid());
		extraOrderService.addExtraOrder(xid2,orderItem.getOid());
		extraOrderService.addExtraOrder(xid3,orderItem.getOid());
		
		
		/*//Order_Total 테이블을 추가해야 함(ogid 유지해야 함)
		//앱에서 주문할 때 와야 하는 데이터(user_id, oghowpay)
		//위의 두 데이터는 임의의 테스트 데이터로 대체
		Order order = new Order();
		String sid = (String) session.getAttribute("login");
		
		//ogid 가져옴
		//ogid(문자열) 만들기(sid+현재시간+랜덤 숫자)(안겹치게 하기 위해서)
		String ogid=null;
		ogid = (String) session.getAttribute("ogid");
		
		
		logger.info("ogid: "+ogid);
		logger.info("mid: "+mid);
		logger.info("sid: "+sid);
		logger.info("ordercount: "+ordercount);
		
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
		*/
		/*if(session.getAttribute("ogid")==null){
			logger.info("여기1");
			long time = System.currentTimeMillis(); double random = Math.random();
			ogid = ""+sid+time+random;
			session.setAttribute("ogid", ogid);

			logger.info("ogid: "+ogid);
			logger.info("mid: "+mid);
			logger.info("sid: "+sid);
			logger.info("ordercount: "+ordercount);
			
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
			
		}else{
			logger.info("여기2");
			ogid = (String) session.getAttribute("ogid");
		}*/
		
		//ogid 가져옴
		//ogid(문자열) 만들기(sid+현재시간+랜덤 숫자)(안겹치게 하기 위해서)
		
		
		return "redirect:/order/orderItems";
	}
	
	//결제(미완성)
	@RequestMapping(value="/orderpay",method=RequestMethod.GET)
	public String orderpay(){
		
		return "store/index";
	}
	
}
