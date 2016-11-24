<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--이명진 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/lmj1.css">
	
<title>주문 기간 내역 보기</title>
</head>
<body>
	주문 기간 내역 보기
	<hr />
	<div class="wrapper" align="center">
		<form action = "/myweb/order/termList" accept-charset="utf-8" name = "termList" method = "post"> 
           <fieldset style = "width:350"><br>
                    조회 날짜 : <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date1" step = "1">
                    ~ <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date2" step = "1">
                    <input type = "submit" value = "검색"/>
                    <input type = "reset" value = "리셋"/>
            </fieldset>
    	</form>
    	
        <table id="acrylic">
            <thead>
                <tr>
                    <th>주문번호</th>
                    <th>고객아이디</th>
                    <th>주문시간</th>
                    <th>총 가격</th>
                    <th>결제 방식</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="orderList" items="${list}">
                	<tr>
                    	<td data-label="주문번호"><a href="detailList?ogid=${orderList.ogid}">${orderList.ogid}</a></td>
                    	<td data-label="고객아이디">${orderList.user_id}</td>
                    	<td data-label="주문시간">${orderList.ogtime}</td>
                    	<td data-label="총 가격">${orderList.ogtotalprice}</td>
                    	<td data-label="결제 방식">${orderList.oghowpay}</td>
                	</tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
  
	<div class="container" align="center">
		<ul class="pagination">
			<li><a href="list?pageNo=1">««</a></li>
			<c:if test="${groupNo>1 }">
				<li><a href="list?pageNo=${startPageNo-1 }">«</a></li>
			</c:if>
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo }">
				<li><a href="list?pageNo=${i}"
					<c:if test="${pageNo==i }">style="color:red"</c:if>>${i}</a></li>
			</c:forEach>
	
			<c:if test="${groupNo<totalGroupNo }">
				<li><a href="list?pageNo=${endPageNo+1 }">»</a></li>
			</c:if>
			<li><a href="list?pageNo=${totalPageNo }">»»</a></li>
		</ul>
	</div>

</body>
</html>