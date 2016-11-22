<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--이명진--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">

		function getSelectValue(frm)
		{
 			frm.sname.value = frm.snameBox.options[frm.snameBox.selectedIndex].text;
 			frm.optionValue.value = frm.snameBox.options[frm.snameBox.selectedIndex].value;
		}
		</script>
	</head>
	<body>
		주문 하기1
		<hr/>
		[검색]&nbsp;&nbsp;&nbsp;
		<a href="allMenuSearch">전체</a>&nbsp;&nbsp;&nbsp;
		<a href="someMenuSearchMgroup?mgroup=커피">커피</a>&nbsp;&nbsp;&nbsp;
		<a href="someMenuSearchMgroup?mgroup=차">차</a>&nbsp;&nbsp;&nbsp;
		<a href="someMenuSearchMgroup?mgroup=디저트">기타</a><br/><br/><br/>
		
		<form method="post" action="/myweb/order/someMenuSearchMname">
			메뉴단어검색: <input type="text" name="mname" value="아메리카노">&nbsp;&nbsp;&nbsp;
					   <input type="submit" value="검색"/>
		</form><br/><br/><br/>
		
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px">
		<tr style="background-color: #00D8FF">
			<th style="border: 1px solid black;">메뉴 번호</th>
			<th style="border: 1px solid black;">메뉴 사진</th>
			<th style="border: 1px solid black;">메뉴 이름</th>
		</tr>


		<c:forEach var="menuList" items="${list}">
			<tr>
				<th style="border: 1px solid black;">${menuList.mid}</th>
				<th style="border: 1px solid black;">${menuList.msavedfile}</th>
				<th style="border: 1px solid black;"><a href="orderItems2?mid=${menuList.mid}">${menuList.mname}</a></th>
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