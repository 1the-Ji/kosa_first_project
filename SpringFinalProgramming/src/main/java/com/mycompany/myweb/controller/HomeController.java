package com.mycompany.myweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
<<<<<<< HEAD
=======
	
>>>>>>> 9e9e320c84b3e0b1177fac65eb9d8db81d381b2a
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/")
	public String index(){
		logger.info("index실행");
		return "/index";
	}
}
