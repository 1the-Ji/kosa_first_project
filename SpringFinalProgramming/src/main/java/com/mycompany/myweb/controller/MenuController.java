package com.mycompany.myweb.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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

import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.service.MenuService;
// 메뉴관련코드작성자: 보나 (20161107~)


// 일반적인 페이징처리 메뉴 리스트
@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/list")
	public String list(String pageNo, Model model, HttpSession session){
		
		String sid = (String) session.getAttribute("login");
	
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
		
		return "menu/menuList";
	} // list
	 
	
	// 페이징+그룹핑 기능 리스트
	@RequestMapping(value="/menuList")
	public String mgroupList(String mgroup, String pageNo, Model model, HttpSession session){
		logger.info("메뉴리스트 그룹+페이징 컨트롤러");
		String sid = (String) session.getAttribute("login");
		if(mgroup.equals("전체")) mgroup = null;
		
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
		logger.info("before model addAttribute");
		List<Menu> list = menuService.listPageMgroup(intPageNo, rowsPerPage, sid, mgroup);
		
		model.addAttribute("sid",sid);
		model.addAttribute("mgroup", mgroup);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		logger.info(sid, mgroup);
		return "menu/menuList";
	
	} // menuList
	
	
	@RequestMapping(value = "/menu/register", method=RequestMethod.GET)
	public String registerForm(HttpSession session){
		return "menu/menuRegForm";
	} 
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String register(HttpSession session, Menu menu){
		logger.info("메뉴등록");
		try {
			String sid = (String)session.getAttribute("login");
			menu.setSid(sid);
			logger.info(""+sid);
			String msavedfile = new Date().getTime() + menu.getPhoto().getOriginalFilename();
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + msavedfile);
			logger.info(realpath);
			menu.getPhoto().transferTo(new File(realpath));
			menu.setMsavedfile(msavedfile);
			menu.setMmimetype(menu.getPhoto().getContentType());
			
			int result = menuService.write(menu);
			logger.info(""+result);
			return "menu/menuList";		
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			return "menu/menuRegForm";
		}
	} // register
	
	
	@RequestMapping("/showPhoto")
	public void showPhoto(String msavedfile, HttpServletRequest request, HttpServletResponse response){
		try{
			String fileName = msavedfile;
			String mimeType = request.getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/" + fileName);
			InputStream is = new FileInputStream(filePath);
			
			byte[] values = new byte[1024];
			int byteNum = -1;
			while((byteNum = is.read(values)) != -1){
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	} // showPhoto 
	
	@RequestMapping(value="/info")
	public String info(int mid, Model model){
		Menu menu = menuService.info(mid);
		menuService.modify(menu);
		model.addAttribute("menu", menu);
		return "menu/menuInfoModal";
	} // info
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int mid, Model model){
		Menu menu = menuService.info(mid);
		model.addAttribute("menu", menu);
		return "menu/menuModModal";
	} // modifyForm
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Menu menu, HttpSession session, Model model){
		
		try{
			// String sid = (String)session.getAttribute("login");
			// menu.setSid(sid);
			
			String msavedfile = new Date().getTime() + menu.getPhoto().getOriginalFilename();
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + msavedfile);
			logger.info("realpath : "+realpath);
			menu.getPhoto().transferTo(new File(realpath));
			menu.setMsavedfile(msavedfile);
			menu.setMmimetype(menu.getPhoto().getContentType());
			menuService.modify(menu);
		}catch(Exception e){}
		return "/menu/menuModal";
	} //modify
	
	@RequestMapping("/remove")
	public String remove(int mid){
		menuService.remove(mid);
		return "/menu/menuModal";
	}

} // class
