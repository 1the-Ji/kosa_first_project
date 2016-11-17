package com.mycompany.myweb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Event;
import com.mycompany.myweb.service.EventService;

@Controller
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	  
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/event/list")
	public String list(Model model, HttpSession session){
		logger.info("service list 실행1");
		String sid = (String) session.getAttribute("login");
		List<Event> list = eventService.getList(sid);
		model.addAttribute("eventList",list);
		logger.info("service list 실행2");
		return "event/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm(){
		return "event/registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(){
		return "redirect:/event/list";
	}
}
