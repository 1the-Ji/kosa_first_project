<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 보나: 20161122 store 아이디/비번찾기 전체수정 --%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		아이디 찾기
		<hr/>
		<form method="post"><%--action=~ 이 없으면 현재 넘어간 요청경로로 다시 이동하다.--%>
			비밀번호: ${findSpw} 
			<input type="submit" value="submit로그인"/>
			<a href="../myweb"> <input type="button" value="button로그인"/> </a>
		</form>
	</body>
</html>