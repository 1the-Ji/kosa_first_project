package com.mycompany.myweb.controller;

import java.io.File;
import java.io.FileInputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myweb.dto.Sphoto;
import com.mycompany.myweb.dto.Store;
import com.mycompany.myweb.service.SphotoService;
import com.mycompany.myweb.service.StoreService;


@Controller
public class StoreController {
// 김정호
// 보나 20161122 - 아이디&비번찾기 추가 
	
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private SphotoService sphotoService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loginForm(){
		logger.info("login 페이지 열림");
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String login(String sid, String spw, HttpSession session, Model model){
		int result = storeService.login(sid, spw);
		logger.info("login 페이지 열림2");
		
		if (result == StoreService.LOGIN_FAIL_SPW) {
			
			model.addAttribute("error", "LOGIN_FAIL_SPW");
			logger.info("login_실패");
			return "index";
			
		} else if (result == StoreService.LOGIN_FAIL_SID) {
			
			model.addAttribute("error", "LOGIN_FAIL_SID");
			logger.info("login_실패");
			return "index";
			
		} else {
			
			session.setAttribute("login", sid);
			logger.info("login_성공");
			return "redirect:/index";
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
		return "store/resultFindSid";
	}
	
	
	@RequestMapping(value="/resultFindSid", method=RequestMethod.GET)
	public String resultFindSid(){
		return "store/resultFindSid";
	}
	
	@RequestMapping(value="/resultFindSid", method=RequestMethod.POST)
	public String resultFindSid(String findSid, Model model, HttpSession session){
		String sid = (String)session.getAttribute(findSid);
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/findSpw", method=RequestMethod.GET)
	public String findSpwForm(){
		return "store/findSpwForm";
	}
	
	@RequestMapping(value="/findSpw", method=RequestMethod.POST)
	public String findSpw(String sid, String semail, Model model, HttpSession session){
		String spw = storeService.findSpw(sid, semail);
		if (spw == null) {
			model.addAttribute("error","이메일 및 아이디가 존재 하지 않음.");
			return "store/findSpwForm";
		}
		session.setAttribute("findSpw", spw);
		return "store/resultFindSpw";
	}
	
	@RequestMapping(value="/findResultSpw", method=RequestMethod.GET)
	public String findResultSpw(){
		return "store/findResultSpw";
	}
	
	@RequestMapping(value="/findResultSpw", method=RequestMethod.POST)
	public String findResultSpw(String findSpw, Model model, HttpSession session){
		String spw = (String) session.getAttribute(findSpw);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		logger.info("joinForm 진입 성공");
		return "store/joinForm";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Store store,Sphoto sphoto, HttpSession session){
		try {
			int result = storeService.join(store);
			
			/*=========sphoto=============================*/
			String sid = store.getSid();
			sphoto.setSid(sid);
			logger.info("sphoto: "+sphoto.getPhoto().toString() );
			
			for(MultipartFile photo: sphoto.getPhoto()){
					String savedfile = new Date().getTime()+photo.getOriginalFilename();
					String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
					
					photo.transferTo(new File(realpath));
					sphoto.setSpic_savedfile(savedfile);
					
					logger.info(realpath);
					
					sphoto.setSpic_mimetype(photo.getContentType());
					
					int result2 = sphotoService.write(sphoto);
				
			}
			/*=========sphoto=============================*/
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
	
	@RequestMapping("/store/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request,HttpServletResponse response){//이미지 다운로드 받기 위해 메소드 작성
						//보기를 원하는 파일명
		try{
			String fileName = savedfile;
			
			String mimeType = request.getServletContext().getMimeType(savedfile);
			response.setContentType(mimeType);//Content-Type 설정
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/"+fileName);
			InputStream is = new FileInputStream(filePath);
			byte[] values =new byte[1024];
			int byteNum = -1;
			while ((byteNum = is.read(values)) != -1 ) {
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//post로 받는다
	@RequestMapping(value="/store/info", method=RequestMethod.GET)
	public String info(HttpSession session, Model model){
		logger.info("storemodifyForm정보");
		String sid = (String) session.getAttribute("login");
		
		Store store = storeService.info(sid);
		model.addAttribute("store", store);
		
		//===================sphoto=========================
		
		List<Sphoto> list = sphotoService.info(sid);
		model.addAttribute("list", list);
		logger.info(""+store.getSid());
		//===================sphoto=========================
		return "store/info";
	}
	
	@RequestMapping(value="/store/modify", method=RequestMethod.GET)
	public String modifyForm(HttpSession session, Model model){
		logger.info("modifyForm정보");
		String sid = (String) session.getAttribute("login");
		
		Store store = storeService.info(sid);
		model.addAttribute("store", store);
		
		//===================sphoto=========================
		
		List<Sphoto> list = sphotoService.info(sid);
		model.addAttribute("list", list);
		logger.info(""+store.getSid());
		//===================sphoto=========================
		return "store/modify";
	}
	
	@RequestMapping(value="/store/modify", method=RequestMethod.POST)
	public String modify(HttpSession session, Store store, Sphoto sphoto){
		int row = storeService.modify(store);
		logger.info("row => "+row);
		try{
		/*=========sphoto=============================*/
		String sid = (String)session.getAttribute("login");
		sphoto.setSid(sid);
		
		/*for(MultipartFile photo: sphoto.getPhoto()){
				String savedfile = new Date().getTime()+photo.getOriginalFilename();
				String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
				
				photo.transferTo(new File(realpath));
				sphoto.setSpic_savedfile(savedfile);
				
				logger.info("realpath => "+realpath);
				
				sphoto.setSpic_mimetype(photo.getContentType());
				
				int result2 = sphotoService.modify(sphoto);
				logger.info("result2 => "+result2);
				
				logger.info("photo spic_id : "+ sphoto.getSpic_id());
			
		}*/
		/*=========sphoto=============================*/
		return "redirect:/store/info";
	} catch (Exception e) {
		logger.info("join 실패"+e.getMessage());
		return "store/modify";
	}
		
	}
	
	
	@RequestMapping("/withdraw")
	public String withdraw(HttpSession session){
		return "store/index";
	}
}
