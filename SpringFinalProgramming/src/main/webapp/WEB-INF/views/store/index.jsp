<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		<h1>매장</h1>
		<hr/>
		1. <a href="${pageContext.servletContext.contextPath}/store/modify"> 매장정보보기</a> <br/>
		2. <a href="${pageContext.servletContext.contextPath}/store/logout"> 로그아웃</a> <br/>
		3. <a href="${pageContext.servletContext.contextPath}/sphoto/write"> 사진 첨부하기</a> <br/><br/>
		<h1>메뉴</h1>
		<hr/>
		1. <a href="${pageContext.servletContext.contextPath}/menu/list">메뉴리스트</a> <br/>
	
		<h1>이벤트</h1>
		<hr/>
		1. <a href="${pageContext.servletContext.contextPath}/event/list">이벤트리스트</a> <br/>
		
	</body>
</html>