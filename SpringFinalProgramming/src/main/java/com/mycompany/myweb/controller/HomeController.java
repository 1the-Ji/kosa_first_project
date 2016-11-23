package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/")
	public String index(){
		logger.info("index실행");
		return "/index";
	}
	
	@RequestMapping("/index")
	public String home(HttpSession session){//명진 수정
		int flag = 0;//명진 수정
		session.setAttribute("flag", flag);//명진 수정
		logger.info("home실행");
		return "store/index";
	}
}
