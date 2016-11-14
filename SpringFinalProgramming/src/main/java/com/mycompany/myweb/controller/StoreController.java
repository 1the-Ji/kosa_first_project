package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Store;
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
	public String login(String sid, String spw, HttpSession session, Model model){
		int result = storeService.login(sid, spw);
		
		if (result == StoreService.LOGIN_FAIL_SPW) {
			
			model.addAttribute("error", "LOGIN");
			return "store/loginForm";
			
		} else if (result == StoreService.LOGIN_FAIL_SID) {
			
			model.addAttribute("error", "LOGIN_FAIL_SID");
			return "store/loginForm";
			
		} else {
			
			session.setAttribute("login", sid);
			return "redirect:/home";
		}
		
		
	}
	
	@RequestMapping(value="/findSid", method=RequestMethod.GET)
	public String findSidForm(){
		return "store/findSidForm";
	}
	
	@RequestMapping(value="/findSid", method=RequestMethod.POST)
	public String findSid(String semail, Model model, HttpSession session){
		String sid = storeService.findSid(semail);
		if (sid == null) {
			model.addAttribute("error", "이메일 not found");
			return "store/findSidForm";
		}
		
		session.setAttribute("findSid", sid);
		return "redirect:/store/login";
	}
	
	@RequestMapping(value="/findSpw", method=RequestMethod.GET)
	public String findSpwForm(){
		return "store/findSpwForm";
	}
	
	@RequestMapping(value="/findSpw", method=RequestMethod.POST)
	public String findSpw(String sid, String semail, Model model, HttpSession session){
		String Spw = storeService.findSpw(sid, semail);
		if (Spw == null) {
			model.addAttribute("error","이메일 및 아이디가 존재 하지 않음.");
			return "store/findSpwForm";
		}
		session.setAttribute("findSpw", Spw);
		return "redirect:/store/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		return "store/joinForm";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Store store){
		try {
			int result = storeService.join(store);
			return "redirect:/store/login";
		} catch (Exception e) {
			return "store/joinForm";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String sid = (String) session.getAttribute("login");
		int result = storeService.logout(sid);
		if (result == StoreService.LOGOUT_SUCCESS) {
			session.removeAttribute("login");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/info")
	public String info(HttpSession session, Model model){
		String sid = (String) session.getAttribute("login");
		Store store = storeService.info(sid);
		model.addAttribute("store", store);
		return "store/info";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(HttpSession session){
		return "store/index";
	}
	
	

}
