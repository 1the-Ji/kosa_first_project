package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.Order;
import com.mycompany.myweb.service.ExtraOrderService;

//명진 테스트
@Controller
@RequestMapping("/order")
public class Test2Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Test2Controller.class);
	
	
	@Autowired
	ExtraOrderService extraOrderService;
	
	//ExtraOrderService
	
	//1개 주문 시(매칭되는) 한 품목 사이드 상세 찾기
	/*@RequestMapping("/listTest")
	public String listTest(String pageNo,Model model,HttpSession session){
		
		Extra extra = extraOrderService.orderItemExtra(1);
		logger.info(""+extra.getXid());
		logger.info(""+extra.getXname());
		logger.info(""+extra.getXprice());
		
		return "order/listTest";
	}*/
}
