package com.mycompany.myweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String index() {
		logger.info("index() 실행");
		return "/index"; //views에 있는 index.jsp를 찾는다
	}
	
	@RequestMapping("/home")
	public String home() {
		logger.info("home() 실행");
		return "/home"; //views에 있는 home.jsp를 찾는다
	}
	
}
