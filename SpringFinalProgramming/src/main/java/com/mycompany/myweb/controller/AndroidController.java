package com.mycompany.myweb.controller;


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Event;
import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.dto.Sphoto;
import com.mycompany.myweb.dto.Store;
import com.mycompany.myweb.dto.User;
import com.mycompany.myweb.service.EventService;
import com.mycompany.myweb.service.MenuService;
import com.mycompany.myweb.service.SphotoService;
import com.mycompany.myweb.service.StoreService;
import com.mycompany.myweb.service.UserService;

@Controller
public class AndroidController {

	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SphotoService sphotoService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
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
	
	/*@RequestMapping("/menuAndroid")
	public String getMenu(String sid, Model model){
		
		logger.info("menuAndroid 실행");
		if(sid.equals("store444")){
		//List<Menu> list = menuService.list(pageNo, rowsPerPage, sid);
		List<Menu> list = new ArrayList<>();
		list.add(new Menu(1, "커피", "아메리카노", "HOT", 3000, "따뜻한 아메리카노", "coffee1.png", "store444"));
		list.add(new Menu(2, "커피", "아메리카노", "ICED", 3500, "차가운 아메리카노", "coffee2.png", "store444"));
		list.add(new Menu(3, "차", "홍차", "HOT", 5000, "따뜻한 홍차", "tea1.png", "store444"));
		list.add(new Menu(4, "차", "홍차", "ICED", 5500, "차가운 홍차", "tea2.png", "store444"));
		list.add(new Menu(5, "커피", "헤이즐넛", "HOT", 5000, "따뜻한 헤이즐넛", "coffee3.png", "store444"));
		list.add(new Menu(6, "커피", "헤이즐넛", "ICED", 5500, "차가운 헤이즐넛", "coffee4.png", "store444"));
		list.add(new Menu(7, "케익", "트라미수", "없음", 7000, "티라미슈 케익", "cake1.png", "store444"));
		list.add(new Menu(8, "베이글", "치즈베이글", "없음", 6000, "치즈 베이글", "etc1.png", "store444"));
		
		model.addAttribute("list",list);
		}
		return "android/menuAndroid";
	}*/
	
	@RequestMapping(value="/menuAndroid")
	public String list(String sid, String pageNo, Model model, HttpSession session){
		
	
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = menuService.getCount();
		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Menu> list = menuService.list(intPageNo, rowsPerPage, sid);
		
		model.addAttribute("sid",sid);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "android/menuAndroid";
	} // list
	
	/*@RequestMapping("/detailMenuAndroid")
	public String getDetailMenu(int mid, Model model){
		logger.info("detailMenuAndroid 실행");
		
		if(mid == 1){
		Menu menu = new Menu(1, "커피", "아메리카노", "HOT", 3000, "따뜻한 아메리카노", "coffee1.png", "store444");
		model.addAttribute("menu", menu);
		} else if(mid == 2){
			Menu menu = new Menu(2, "커피", "아메리카노", "ICED", 3500, "차가운 아메리카노", "coffee2.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 3){
			Menu menu = new Menu(3, "차", "홍차", "HOT", 5000, "따뜻한 홍차", "tea1.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 4){
			Menu menu = new Menu(4, "차", "홍차", "ICED", 5500, "차가운 홍차", "tea2.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 5){
			Menu menu = new Menu(5, "커피", "헤이즐넛", "HOT", 5000, "따뜻한 헤이즐넛", "coffee3.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 6){
			Menu menu = new Menu(6, "커피", "헤이즐넛", "ICED", 5500, "차가운 헤이즐넛", "coffee4.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 7){
			Menu menu = new Menu(7, "케익", "트라미수", "없음", 7000, "티라미슈 케익", "cake1.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 8){
			Menu menu = new Menu(8, "베이글", "치즈베이글", "없음", 6000, "치즈 베이글", "etc1.png", "store444");
			model.addAttribute("menu", menu);
		}
		
		return "android/detailMenuAndroid";
		
	}*/
	
	@RequestMapping(value="/detailMenuAndroid")
	public String info(int mid, Model model){
		Menu menu = menuService.info(mid);
		menuService.modify(menu);
		model.addAttribute("menu", menu);
		return "android/detailMenuAndroid";
	} 
	
	@RequestMapping(value="/joinAndroid", method=RequestMethod.POST)
	public String join(User user){
			int result = userService.join(user);
			if(result == UserService.JOIN_SUCCESS) {
			logger.info("회원가입 성공");
			return "android/joinAndroid";
			} 
			logger.info("회원가입 실패");
			return "";
	}
	
	//menu test
	@RequestMapping("/getImage")
	public void getImage(String fileName, HttpServletRequest request,HttpServletResponse response){
		//직접 응답을 만들어 보내기 때문에 따로 JSP에 요청하지 않아도 된다.
		try{
			
			String mimeType = request.getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);//Content-Type 설정
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/resources/image/"+fileName);
			
			logger.info(filePath);
			
			InputStream is = new FileInputStream(filePath);
			byte[] values =new byte[1024];
			int byteNum = -1;
			while ((byteNum = is.read(values)) != -1 ) {
				os.write(values, 0, byteNum);
			}
			logger.info("android 요청" + fileName);
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
