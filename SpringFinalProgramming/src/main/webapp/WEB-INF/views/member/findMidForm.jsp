<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
	</head>

	<body>
	아이디 찾기
	<hr/>
	<!-- action을 지정하지않으면 현재 경로로 요청을 하게됨 -->
	<form method="post">
		이메일:<input type="email" name="memail"/>${error}<br/>
		<input type = "submit" value="찾기"/>
	</form>
	</body>
</html>