<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--                  MIME Type     -->
<!--                  대분류/소분류    -->

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<link href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    	<!-- Custom styles for this template -->
    	<link href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css" rel="stylesheet">
    	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
    	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  		
	</head>

	<body>
	  <div class="jumbotron">
        <h1>Spring Final Programming</h1>
        <p class="lead">Java, SQl, JDBC, HTML5, CSS3, JavaScript, JQuery, AJAX, JSP, Spring</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">많이 배웠네~~ㅎㅎ</a></p>
      </div>
		<%-- SpringFinalProgramming
		<hr/> <!-- 수평선 -->	
		<!-- 상대 경로를 지정 할 수 있음 /myapp/삭제 가능 -->
		<!-- 절대 경로 설정 -->
		<!-- 첫번째 방법 -->
		1. 
		<c:if test="${login == null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a>
		</c:if>
		<c:if test="${login != null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a>
		</c:if>
		</br>
		<!-- 두번쨰 방법 -->
		2. 
		<a href="${pageContext.servletContext.contextPath}/freeboard/list">일반 게시판</a><br/>     <!-- 표현언어(EL) -->
		3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/> --%>
		
	</body>
</html>







