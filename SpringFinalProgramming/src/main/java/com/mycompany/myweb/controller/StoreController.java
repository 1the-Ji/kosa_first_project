package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Store;
import com.mycompany.myweb.service.SphotoService;
import com.mycompany.myweb.service.StoreService;


@Controller
public class StoreController {
//김정호
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private SphotoService sphotoService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loginForm(){
		logger.info("login 페이지 열림");
		return "/index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String login(String sid, String spw, HttpSession session, Model model){
		int result = storeService.login(sid, spw);
		logger.info("login 페이지 열림2");
		
		if (result == StoreService.LOGIN_FAIL_SPW) {
			
			model.addAttribute("error", "LOGIN");
			logger.info("login_실패");
			return "/index";
			
		} else if (result == StoreService.LOGIN_FAIL_SID) {
			
			model.addAttribute("error", "LOGIN_FAIL_SID");
			logger.info("login_실패");
			return "/index";
			
		} else {
			
			session.setAttribute("login", sid);
			logger.info("login_성공");
			return "/store/index";
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
		logger.info("joinForm 진입 성공");
		return "store/joinForm";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Store store){
		try {
			int result = storeService.join(store);
			logger.info("join 성공");
			return "redirect:/";
		} catch (Exception e) {
			logger.info("join 실패"+e.getMessage());
			return "store/joinForm";
		}
		
	}
	
	@RequestMapping("/store/logout")
	public String logout(HttpSession session){
		String sid = (String) session.getAttribute("login");
		int result = storeService.logout(sid);
		if (result == StoreService.LOGOUT_SUCCESS) {
			session.removeAttribute("login");
		}
		return "redirect:/";
	}
	
	/*@RequestMapping(value="/store/info", method=RequestMethod.GET)
	public String info(HttpSession session, Model model){
		String sid = (String) session.getAttribute("login");
		logger.info("storeinfo정보");
		Store store = storeService.info(sid);
		model.addAttribute("store", store);
		return "store/info";
	}*/
	
	@RequestMapping(value="/store/modify", method=RequestMethod.GET)
	public String modifyForm(HttpSession session, Model model){
		logger.info("storemodifyForm정보");
		String sid = (String) session.getAttribute("login");
		Store store = storeService.info(sid);
		model.addAttribute("store", store);
		return "/store/modify";
	}
	
	@RequestMapping(value="/store/modify", method=RequestMethod.POST)
	public String modify(Store store){
		
		logger.info("storemodify정보");
		Store dbStore = storeService.info(store.getSid());
		storeService.modify(dbStore);
		return "redirect:/store/modify";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(HttpSession session){
		return "store/index";
	}
	
	

}
