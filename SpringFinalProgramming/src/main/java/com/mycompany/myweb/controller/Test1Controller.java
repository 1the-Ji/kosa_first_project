package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Extra;

//명진 테스트
@Controller
@RequestMapping("/order")
public class Test1Controller {
	
	//OrderService & OrderItemService
	//
	@RequestMapping("/orderList")
	public String orderList(String pageNo,Model model,HttpSession session){
		//oid, user_id, otime, ototalprice, howpay
		
		/*Extra extra = extraOrderService.orderItemExtra(1);
		logger.info(""+extra.getXid());
		logger.info(""+extra.getXname());
		logger.info(""+extra.getXprice());*/
		
		return "order/orderList";
	}
	
	
	
	
	
	
	
	//1개 주문 품목 당 총 가격 구하기(메뉴+사이드)
	
	//1개 주문 총 가격 구하기(주문 상세보기의 총가격 에 쓰임)

	//1개 주문에 대해 같은 이름과 사이드를 갖는 품목의 이름들을 담는 것

	//1개 주문에 대해 같은 이름과 사이드를 갖는 품목을 카운트 하는 것
	
	//1개 주문에 대해 같은 이름과 사이드를 갖는 사이드이름을 반환 하는 것
	
	//1개 주문에 대해 같은 이름과 사이드를 갖는 사이드를 반환 하는 것
	
	//1개 주문 같은 품목(이름,사이드)당 합한 가격
	
	//1개 주문 품목 추가
	
	//1개 주문 품목 리스트 찾기
	
	//1개 주문 품목 리스트 찾기
	
	//1개 주문 품목 제거
	
	//1개 주문 품목 카운트
}
