package com.mycompany.myweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.Order;
import com.mycompany.myweb.service.ExtraOrderService;
import com.mycompany.myweb.service.OrderItemService;
import com.mycompany.myweb.service.OrderService;

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
	
	//주문내역 페이지
	@RequestMapping("/list")
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
		
		List<Order> list = orderService.list(intPageNo, rowsPerPage);
		
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
	
	//주문내역 상세보기(1개 주문 당)
	@RequestMapping(value="/detailList", method=RequestMethod.GET)
	public String detailList(int oid, Model model){
		//주문내역 상세보기 service&dao 만들어야 함
		//1주문당
		//품목, 수량, 사이드, 가격 -> 구해서 같이 넘겨야 됨
		Map<Integer,String> mnameSameItem = orderItemService.mnameSameItem(oid);
		Map<Integer,Integer> countSameItem = orderItemService.countSameItem(oid);
		Map<Integer,String> xnameSameItem = orderItemService.xnameSameItem(oid);
		Map<Integer,Integer> sumSameItem = orderItemService.sumSameItem(oid);
		
		model.addAttribute("mnameSameItem", mnameSameItem);
		model.addAttribute("countSameItem", countSameItem);
		model.addAttribute("xnameSameItem", xnameSameItem);
		model.addAttribute("sumSameItem", sumSameItem);
		
		
		return "order/detailList";
	}//여기까지 함
	
	//주문내역 기간보기
	@RequestMapping(value="/termList", method=RequestMethod.POST)
	public String termList(Date term1, Date term2, Model model){
		model.addAttribute("term1", term1);
		model.addAttribute("term2", term2);
		
		return "order/termList";
	}
	
}
