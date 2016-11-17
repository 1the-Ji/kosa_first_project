<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
   </head>
   <body>
   		<h2>메뉴 게시판</h2>
   		<hr/>
   		
   		<a href="${pageContext.servletContext.contextPath}/menu/register">[메뉴 등록]</a>
   		
   		
   		<table style="width:600px">
   			<tr>
   				<td>
   					<c:forEach var="menu" items="${list}">
   					<a href="info?mid=${menu.mid}">
	   					<div style="width:120px; height:130px; margin:5px; display:inline-block;
	   					background-image:url(showPhoto?savedfile=${menu.msavedfile});">
	   					</div>
	   					<div>
	   						<table style="width: 120px">
		   						<tr style="text-align:center;">${menu.mname} ${menu.hot_ice}</tr>
		   						<tr style="text-align:center;color:red">${menu.mprice}</tr>
		   					</table>
	   					</div>
   						
   					</a>
   					</c:forEach>
   				</td>
   			</tr>
   		</table>
   		
   		<div style="width: 600px">
			<a href="list?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1 }">
			<a href="list?pageNo=${startPageNo-1 }">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo }">
			 <a href="list?pageNo=${i}" 
			 	<c:if test="${pageNo==i }">style="color:red"</c:if>
			 >${i}</a>
			</c:forEach>
			 
			<c:if test="${groupNo<totalGroupNo }">
			<a href="list?pageNo=${endPageNo+1 }">[다음]</a>
			</c:if>
			<a href="list?pageNo=${totalPageNo }">[맨끝]</a>
		</div>
   </body>
</html>