<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--이명진 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1개 주문 내역 상세 보기</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/lmj1.css">
	
</head>
<body>
	1개 주문 내역 상세 보기
	<hr />
	<div class="wrapper" align="center">
        <table id="acrylic">
            <thead>
                <tr>
                    <th>품목</th>
                    <th>수량</th>
                    <th>사이드</th>
                    <th>가격</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="detailOrders" items="${detailOrders}">
                	<tr>
                    	<td data-label="주문번호">${detailOrders.mname}</a></td>
                    	<td data-label="고객아이디">${detailOrders.sameItemCount}</td>
                    	<td data-label="주문시간">${detailOrders.xname}</td>
                    	<td data-label="총 가격">${detailOrders.sameItemPrice}</td>
                	</tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
		총 가격 : <c:out value="${requestScope.resultprice}"/> <br/>
		<c:forEach var="detailOrders" items="${detailOrders}" begin="1" end="1">
 			<p>결제방법 : ${detailOrders.oghowpay}</p>
		</c:forEach>

</body>
</html>