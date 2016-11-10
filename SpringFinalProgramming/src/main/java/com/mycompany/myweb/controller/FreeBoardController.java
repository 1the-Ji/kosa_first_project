package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/list")
	//보통 string타입으로 넘어오는데 int로 이클립스에서 자동으로 형변환을 하는데,
	//값이 안넘어올떄 int로 바꾸면 예외가 발생을 하기 떄문에 
	//requestParam을 통해서 defautlValue값을 지정을 해준다.
	/*public String list(@RequestParam(defaultValue="1") int pageNo, Model model){*/
	  public String list(String pageNo, Model model, HttpSession session){
		int intPageNo=1;
		if(pageNo==null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo!=null){
				intPageNo=Integer.parseInt(pageNo);
			}
		}else{
			intPageNo=Integer.parseInt(pageNo);
		}
		
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 6;
		int pagesPerGroup = 10;
		
		
		int totalBoardNo = freeBoardService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		if(groupNo == totalGroupNo){endPageNo = totalPageNo;}
		
		List<FreeBoard> list = freeBoardService.list(intPageNo, rowsPerPage);
		model.addAttribute("list", list);
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		
		return "freeboard/list";
	}
	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public String write(FreeBoard freeBoard){	
		return "freeboard/write";
		
	}
	
	//writer는 로그인 상태에서 로그인한 사람의 정보를 가져오기때문에
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String writeform(FreeBoard freeBoard, HttpSession session){
		String mid = (String)session.getAttribute("login");
		freeBoard.setBwriter(mid);
		int result = freeBoardService.write(freeBoard);
		if(result == FreeBoardService.WRITE_FAIL){
			return "freeboard/write";
		}else{
			return "redirect:/freeboard/list";
		}

	}
	
	@RequestMapping("/info")
	public String info(int bno,Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		freeBoard.setBhitcount(freeBoard.getBhitcount()+1);
		freeBoardService.modify(freeBoard);
		model.addAttribute("freeBoard", freeBoard);
		return "freeboard/info";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public String modifyForm(int bno,Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		model.addAttribute("freeBoard", freeBoard);
		return "freeboard/modify";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modify(FreeBoard freeBoard){
		FreeBoard dbFreeBoard = freeBoardService.info(freeBoard.getBno());
		freeBoard.setBhitcount(dbFreeBoard.getBhitcount());
		freeBoardService.modify(freeBoard);	
		return "redirect:/freeboard/list";
	}
	
	@RequestMapping("/remove")
	public String remove(int bno){
		freeBoardService.remove(bno); 
		return "redirect:/freeboard/list";
		
	}
}
