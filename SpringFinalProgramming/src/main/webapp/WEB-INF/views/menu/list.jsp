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
   		
   		<c:if test="${login!=null}">
   		<a href="register">[메뉴 등록]</a>
   		</c:if>
   		
   		<table style="width:600px">
   			<tr>
   				<td>
   					<c:forEach var="menu" items="${list}">
   					<a href="info?bno=${menu.mid}">
   					<div style="width:120px; height:130px; margin:5px; display:inline-block;
   					background-image:url(showPhoto?savedfile=${menu.msavedfile});
   					background-size: 120px 130px;">
   					</div>
   					</a>
   					</c:forEach>
   				</td>
   			</tr>
   		</table>
   		
   </body>
</html>