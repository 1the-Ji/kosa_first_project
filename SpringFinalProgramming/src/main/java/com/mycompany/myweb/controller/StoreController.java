package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.service.SphotoService;
import com.mycompany.myweb.service.StoreService;

public class StoreController {
//김정호
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private SphotoService sphotoService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(){
		return "store/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model){
		return "";
	}
	
	

}
