<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<!-- Bootstrap core CSS -->
    	<link href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    	<!-- Custom styles for this template -->
   		<link href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css" rel="stylesheet">
    	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
    	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  		
	</head>

	<body>
	로그인
	<hr/>
	<!-- action을 지정하지않으면 현재 경로로 요청을 하게됨 -->
	<form method="post">
		아이디:<input type="text" name="mid" value="${findMid}"/>
		<c:if test="${error == 'LOGIN_FAIL_MID'}">*아이디가 존재하지 않음</c:if>
		<br/>
		
		패스워드:<input type="password" name="mpassword"/>
		<c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}"> *패스워드가 틀림</c:if>
		<br/>
		
		<input type = "submit" value="로그인"/>
	</form>
	<!-- 상대경로 -->
	<a href="join">회원가입</a><br>     <!-- 절대 경로일 경우 <a href="${pageContext.servletContext.contextPath}/member/join"></a><br/>    -->
	<a href="findMid">아이디 찾기</a><br>
	비밀번호 찾기
	</body>
	
</html>