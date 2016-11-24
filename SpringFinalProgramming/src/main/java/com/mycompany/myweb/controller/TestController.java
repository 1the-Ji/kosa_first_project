package com.mycompany.myweb.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Event;
import com.mycompany.myweb.dto.Sphoto;
import com.mycompany.myweb.dto.Store;
import com.mycompany.myweb.service.EventService;
import com.mycompany.myweb.service.SphotoService;
import com.mycompany.myweb.service.StoreService;

@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SphotoService sphotoService;
	
	@RequestMapping("/eventAndroid")
	public String getEvent(int sbeacon, Model model){
		Store store = storeService.findStore(sbeacon);

		String sid = store.getSid();
		
		List<Event> eventList = eventService.getEventList(sid);
		
		model.addAttribute("store", store);		
		
		model.addAttribute("list", eventList);
		
		logger.info("android 요청");
		logger.info("kjh sid : " + sid);
		
		return "android/eventAndroid";
	}
	
	@RequestMapping("/storeAndroid")
	public String getStore(String sid, Model model){
		Store store = storeService.info(sid);

		model.addAttribute("store", store);		
		
		logger.info("android 요청");
		
		return "android/storeAndroid";
	}
	
	@RequestMapping("/sphotoAndroid")
	public String getSphoto(String sid, Model model){
		
		//===================sphoto=========================
		List<Sphoto> list = sphotoService.info(sid);
		model.addAttribute("list", list);
		//===================sphoto=========================
		
		return "android/sphotoAndroid";
	}
}
