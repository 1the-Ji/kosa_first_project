<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 문서 유형 스타일 -->
<html>
<!-- root tag or root element -->
<head>
<meta charset="UTF-8">
<style type = "text/css">
	a{
		text-decoration:none;
		color:black;
	}
	a:HOVER{
		color:green;
	}

</style>
</head>

<body>
	자유게시판
	</hr>
	
	<c:if test="${login != null}">
		<a href="write">[글쓰기]</a>
	</c:if>
	
	<table style="border-collapse: collapse; border: 1px solid black; width: 800px; bo">

		<tr style="background-color: #ffcc00; border: 1px solid black">
			<td style="border: 1px solid black">번호</td>
			<td style="border: 1px solid black">제목</td>
			<td style="border: 1px solid black">글쓴이</td>
			<td style="border: 1px solid black">조회수</td>
			<td style="border: 1px solid black">날짜</td>
		</tr>
		<c:forEach var="freeBoard" items='${list}'>
			<!-- ${freeboard} : list를 request에서 찾아라 -->
			<tr style="border: 1px solid black">
				<td style="border: 1px solid black">${freeBoard.bno}</td>
				<td style="border: 1px solid black">
					<a href="info?bno=${freeBoard.bno}">
						${freeBoard.btitle}
					</a>
				</td>
				<td style="border: 1px solid black">${freeBoard.bwriter}</td>
				<td style="border: 1px solid black">${freeBoard.bhitcount}</td>
				<td style="border: 1px solid black">${freeBoard.bdate}</td>
			</tr>
		</c:forEach>
	</table>

	 <div style="width: 800px; text-align: center">
		<a href="list?pageNo=1">[처음]&nbsp</a>
		<c:if test="${groupNo>1}">
			<a href="list?pageNo=${startPageNo-1}">[이전]&nbsp</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
			<a href="list?pageNo=${i}" 
				<c:if test="${pageNo==i}">Stlye="color:red"</c:if>
			>${i}&nbsp</a>
		</c:forEach>
		
		<c:if test="${groupNo<totalGroupNo}">
			<a href="list?pageNo=${endPageNo+1}">[다음]&nbsp</a>
		</c:if>
		<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
	</div> 
</body>

</html>