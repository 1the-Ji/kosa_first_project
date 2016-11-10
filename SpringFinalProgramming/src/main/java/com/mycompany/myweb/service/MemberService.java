package com.mycompany.myweb.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService {
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
//---------------------------------------------	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
//--------------------------------------------------
	public static final int WIRHDRAW_SUCCESS = 0;
	public static final int WIRHDRAW_FAIL = 1;
//--------------------------------------------------
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL = 1;
	//--------------------------------------------------
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;	
	
	@Autowired
	private MemberDao memberDao;
	
	//정상실행 or 예외이면 반환값을 void로 설정
		public int join(Member member){
			memberDao.insert(member);
			return JOIN_SUCCESS;
		}
		//session을 쓴이유 : 로그인 정보를 저장하기 위해서
		public int login(String mid, String mpassword){
			Member member = memberDao.selectByMid(mid);
			if(member==null){return LOGIN_FAIL_MID;}
			if(member.getMpassword().equals(mpassword)==false){return LOGIN_FAIL_MPASSWORD;}
			return LOGIN_SUCCESS;
			
		}
		
		//어떤 회원을 logout을 할것인가에 대한 것이 session에 담겨있기 떄문에 그냥 임시적으로 ,mid로 설정
		public int logout(String mid){
			return LOGOUT_SUCCESS;
		}
		
		public String findMPassword(String mid, String memail){
			Member member = memberDao.selectByMid(mid);
			if(member==null){return null;}
			if(member.getMemail().equals(memail)==false){return null;}
			return member.getMpassword();
		}
		
		public String findMid(String memail){
			return memberDao.selectByMemail(memail);
			
			
		}
		
		public Member info(String mid, String mpassword){
			Member member = memberDao.selectByMid(mid);
			if(member.getMpassword().equals(mpassword)==false){return null;}
			return member;
		}
		
		
		public int modify(Member member){
			Member dbmember = memberDao.selectByMid(member.getMid());
			if(dbmember.getMpassword().equals(member.getMpassword())==false){return MODIFY_FAIL;} 		
			int row = memberDao.update(member);
			if(row!=1){return MODIFY_FAIL;}
			return MODIFY_SUCCESS;
		}
		
		public int withdraw(String mid, String mpassword){
			Member member = memberDao.selectByMid(mid);
			if(member.getMpassword().equals(mpassword)==false){return WIRHDRAW_FAIL;}
			memberDao.delete(mid);
			logout(mid);

			return WIRHDRAW_SUCCESS;
		}
		
		public boolean isMid(String mid){
			Member member = memberDao.selectByMid(mid);
			if(member==null){return false;}
			
			return true;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*	
	//정상실행 or 예외이면 반환값을 void로 설정
	public int join(Member member){
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
	//session을 쓴이유 : 로그인 정보를 저장하기 위해서
	public int login(String mid, String mpassword,HttpSession session){
		Member member = memberDao.selectByMid(mid);
		if(member==null){return LOGIN_FAIL_MID;}
		if(member.getMpassword().equals(mpassword)==false){return LOGIN_FAIL_MPASSWORD;}
		session.setAttribute("login", mid); // session.setAttribute => 세션을 저장을 할때 쓰임 ->login이라는 이름으로 mid를 저장
		return LOGIN_SUCCESS;
		
	}
	
	public int logout(HttpSession session){
		session.removeAttribute("login");
		return LOGOUT_SUCCESS;
	}
	
	public String findMPassword(String mid, String memail){
		Member member = memberDao.selectByMid(mid);
		if(member==null){return null;}
		if(member.getMemail().equals(memail)==false){return null;}
		return member.getMpassword();
	}
	
	public String findMid(String memail){
		return memberDao.selectByMemail(memail);
		
		
	}
	
	public Member info(String mpassword, HttpSession session){
		String mid = (String)session.getAttribute("mid");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword)==false){return null;}
		return member;
	}
	
	
	public int modify(Member member){
		
		Member dbmember = memberDao.selectByMid(member.getMid());
		if(dbmember.getMpassword().equals(member.getMpassword())==false){return MODIFY_FAIL;} 		
		int row = memberDao.update(member);
		if(row!=1){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
		
	}
	
	public int withdraw(String mpassword, HttpSession session){
		String mid = (String)session.getAttribute("login"); //session은 object타입으로 리턴을 하기때문에 형변환을 해줘야한다.
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword)==false){return WIRHDRAW_FAIL;}
		memberDao.delete(mid);
		logout(session);

		return WIRHDRAW_SUCCESS;
	}
	
	public boolean isMid(String mid){
		Member member = memberDao.selectByMid(mid);
		if(member==null){return false;}
		
		return true;
	}
	*/
	
}
