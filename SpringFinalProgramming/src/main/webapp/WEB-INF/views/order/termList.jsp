<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--이명진 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 기간 내역 보기</title>
</head>
<body>
	주문 기간 내역 보기
	<hr />
	<form action="/order/termList">
		<fieldset>
			<legend>조회 기간</legend>
			<label for="term">조회 기간</label> 
			<input id="term1" type="date">	&nbsp;~&nbsp;	
			<input id="term2" type="date">
			<input type="submit" value="기간 조회">
		</fieldset>
	</form>


	<table style="border-collapse: collapse; border: 1px solid black; width: 600px">
		<tr style="background-color: #00D8FF">
			<th style="border: 1px solid black;">번호</th>
			<th style="border: 1px solid black;">사용자</th>
			<th style="border: 1px solid black;">시간</th>
			<th style="border: 1px solid black;">가격</th>
			<th style="border: 1px solid black;">결제 내용</th>
		</tr>


		<c:forEach var="orderList" items="${list}">
			<tr>
				<th style="border: 1px solid black;">${orderList.oid }</th>
				<th style="border: 1px solid black;"><a href="detailList?oid=${orderList.oid }">${orderList.user_id }</a></th>
				<th style="border: 1px solid black;">${orderList.otime }</th>
				<th style="border: 1px solid black;">${orderList.ototalprice }</th>
				<th style="border: 1px solid black;">${orderList.howpay }</th>
			</tr>
		</c:forEach>
	</table>


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