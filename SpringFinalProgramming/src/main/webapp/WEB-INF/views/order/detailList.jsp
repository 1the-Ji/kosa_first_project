<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--이명진 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1개 주문 내역 상세 보기</title>
</head>
<body>
	1개 주문 내역 상세 보기
	<hr />

	<table
		style="border-collapse: collapse; border: 1px solid black; width: 600px">
		<tr style="background-color: #00D8FF">
			<th style="border: 1px solid black;">번호</th>
			<th style="border: 1px solid black;">제목</th>
			<th style="border: 1px solid black;">글쓴이</th>
			<th style="border: 1px solid black;">조회수</th>
			<th style="border: 1px solid black;">날짜</th>
		</tr>


		<c:forEach var="freeBoard" items="${list}">
			<tr>
				<th style="border: 1px solid black;">${freeBoard.bno }</th>
				<th style="border: 1px solid black;"><a
					href="info?bno=${freeBoard.bno }">${freeBoard.btitle }</a></th>
				<th style="border: 1px solid black;">${freeBoard.bwriter }</th>
				<th style="border: 1px solid black;">${freeBoard.bhitcount }</th>
				<th style="border: 1px solid black;">${freeBoard.bdate }</th>
			</tr>
		</c:forEach>
	</table>

	<!-- <a href="#" >1&nbsp;</a>
	<a href="#" >2&nbsp;</a>
	<a href="#" style="color:red">3&nbsp;</a>
	<a href="#" >4&nbsp;</a>
	<a href="#" >5&nbsp;</a> -->

	<div style="width: 600px">
		<a href="list?pageNo=1">[처음]</a>
		<c:if test="${groupNo>1 }">
			<a href="list?pageNo=${startPageNo-1 }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo }">
			<a href="list?pageNo=${i}"
				<c:if test="${pageNo==i }">style="color:red"</c:if>>${i}</a>
		</c:forEach>

		<c:if test="${groupNo<totalGroupNo }">
			<a href="list?pageNo=${endPageNo+1 }">[다음]</a>
		</c:if>
		<a href="list?pageNo=${totalPageNo }">[맨끝]</a>
	</div>

</body>
</html>