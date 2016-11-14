<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		매장
		<hr/>
		1. <a href="${pageContext.servletContext.contextPath}/store/info"> 매장 정보 보기</a> <br/>
		2. <a href="${pageContext.servletContext.contextPath}/store/logout"> 로그아웃</a> <br/>
	</body>
</html>