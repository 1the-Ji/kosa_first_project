package com.mycompany.myweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Store;
import com.mycompany.myweb.service.StoreService;

@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/testBeacon")
	public String getBeacon(int sbeacon, Model model){
		Store store = storeService.findStore(sbeacon);
		model.addAttribute("store", store);
		
		logger.info("android 요청");
		
		return "beaconList";
	}
}
