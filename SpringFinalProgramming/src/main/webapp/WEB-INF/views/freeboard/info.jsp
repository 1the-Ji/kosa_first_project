<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 문서 유형 스타일 -->
<html>
<!-- root tag or root element -->
<head>
<meta charset="UTF-8">
</head>
  
<body>
	상세내용
	</hr>
	<table style="border: 1px solid black">
		<tr style="border: 1px solid black">
			<td style="background-color:orange; width:70; border: 1px solid black">제목</td>
			<td style="border: 1px solid black"><pre>${freeBoard.btitle}</pre></td>
		</tr>
		<tr style="border: 1px solid black">
			<td style="background-color:orange; width:70; border: 1px solid black">내용</td>
			<td style="border: 1px solid black"><pre>${freeBoard.bcontent}</pre></td>
		</tr>
		<tr style="border: 1px solid black">
			<td style="background-color:orange; width:70; border: 1px solid black">글쓴이</td>
			<td style="border: 1px solid black"><pre>${freeBoard.bwriter}</pre></td>
		</tr>
		<tr style="border: 1px solid black">
			<td style="background-color:orange; width:70; border: 1px solid black">조회수</td>
			<td style="border: 1px solid black"><pre>${freeBoard.bhitcount}</pre></td>
		</tr>
		<tr style="border: 1px solid black">
			<td style="background-color:orange; width:70; border: 1px solid black">날짜</td>
			<td style="border: 1px solid black"><pre>${freeBoard.bdate}</pre></td>
		</tr>
	</table>
	
	<div>
		<c:if test="${login==freeBoard.bwriter}">
		<a href="modify?bno=${freeBoard.bno}">[수정]</a>
		<a href="remove?bno=${freeBoard.bno}">[삭제]</a>
		</c:if>
		<a href="list">[목록]</a>
		
	</div>
</body>

</html>