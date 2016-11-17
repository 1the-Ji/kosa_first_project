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
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	  
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/list")
	public String list(Model model, HttpSession session){
		logger.info("service list 실행1");
		String sid = (String) session.getAttribute("login");
		List<Event> list = eventService.getList(sid);
		model.addAttribute("eventList",list);
		logger.info("service list 실행2");
		return "event/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(){
		logger.info("eventForm 실행");
		return "event/registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerForm(Event event, HttpSession session){
		logger.info("event 등록 성공");
		String sid = (String)session.getAttribute("login");
		event.setSid(sid);
		int result = eventService.write(event);
		if(result == EventService.WRITE_FAIL){
			return "event/registerForm";
		}else{
			/*
		    photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());//저장할 파일 originalfilename 얻기
			
			String savedfile = new Date().getTime()+photoBoard.getPhoto().getOriginalFilename();
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);//저장할 파일의 절대 파일 시스템 경로를 얻는다.
			//C:\Users\Administrator\workspace\.metadata\...\SpringFinalProgramming\...
			
			photoBoard.getPhoto().transferTo(new File(realpath));//클라이언트에서 저장한 파일을 해당 경로(realpath)에 저장 실제 파일을 저장
			photoBoard.setSavedfile(savedfile);
			
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());//저장할 파일의 mime type 얻어냄.
			 */			
			return "redirect:/event/list";
		}
		
	}
	@RequestMapping(value="/info")
	public String info(int eid, Model model){
		logger.info("이벤트 세부정보 form실행");
		Event event = eventService.info(eid);
		model.addAttribute("event",event);
		return "event/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(int eid, Model model){
		logger.info("이벤트 수정폼 form실행");
		Event event = eventService.info(eid);
		model.addAttribute("event",event);
		 return "event/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Event event){
		eventService.modify(event);
		return "redirect:/event/list";
	}
	
}

