package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.service.OrderService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/")
	public String index(HttpSession session){
		logger.info("맨처음");
		logger.info("ogid : "+session.getAttribute("ogid"));
		
		/*
		String ogid = null; int resultprice = 0;
		if((String) session.getAttribute("ogid")!=null){
			if((Integer) session.getAttribute("resultprice")==null){
				session.setAttribute("ogid",null);
				System.out.println("정상적으로 주문을 수행하세요.");
			}else{
				//총 금액 order_total의 ogtotalprice에 넣어주기
				ogid = (String) session.getAttribute("ogid");
				logger.info("ogid: "+ogid);
					
				resultprice = (Integer) session.getAttribute("resultprice");
				if(resultprice != 0){
					orderService.modifyOgprice(ogid, resultprice);
					
				}
				System.out.println("정상적으로 주문을 완료하세요.");
			}
		}else{
			double randomValue = Math.random();
			int intValue = (int) (randomValue*1000)+1;
			
			ogid = "";
			ogid = (String)session.getAttribute("login")+System.currentTimeMillis()+intValue;
			session.setAttribute("ogid", ogid);
		}*/
		return "index";
	}
	
	/*	
	@RequestMapping("/index")
	public String home(HttpSession session){//명진 수정
		int flag = 0;//명진 수정
		session.setAttribute("flag", flag);//명진 수정
		logger.info("home실행");
		return "store/index";
	}*/
}
