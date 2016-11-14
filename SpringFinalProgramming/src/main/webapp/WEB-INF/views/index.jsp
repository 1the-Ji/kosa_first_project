<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="utf-8">
  </head>	
	
  <body>
   <!-- action을 지정하지않으면 현재 경로로 요청을 하게됨 -->
	<form method="post">
		아이디:<input type="text" name="mid"/>
		<br/>
		
		패스워드:<input type="password" name="mpassword"/>
		<br/>
		
		<input type = "submit" value="로그인"/>
	</form>
	
	<a href="join">회원가입</a><br>    
	<a href="findMid">아이디 찾기</a><br>
	<a href="findMpassword">비밀번호 찾기</a></br>
  </body>
</html>
