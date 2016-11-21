<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--이명진--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">

		function getSelectValue1(frm)
		{
 			frm.xname1.value = frm.xnameBox1.options[frm.xnameBox1.selectedIndex].text;
 			frm.optionValue.value = frm.xnameBox1.options[frm.xnameBox1.selectedIndex].value;
		}
		function getSelectValue2(frm)
		{
 			frm.xname2.value = frm.xnameBox2.options[frm.xnameBox2.selectedIndex].text;
 			frm.optionValue.value = frm.xnameBox2.options[frm.xnameBox2.selectedIndex].value;
		}
		function getSelectValue3(frm)
		{
 			frm.xname3.value = frm.xnameBox3.options[frm.xnameBox3.selectedIndex].text;
 			frm.optionValue.value = frm.xnameBox3.options[frm.xnameBox3.selectedIndex].value;
		}
		
		</script>
	</head>
	<body>
		주문 하기2
		<hr/>
		<c:forEach var="menuList" items="${menulist}" begin="1" end="1">
 			<p>${menuList.mname}</p>
 			<hr/>
 			${menuList.msavedfile}&nbsp;&nbsp;${menuList.mname}
 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;가격 나와야 함
 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form action="">
  													Quantity (between 1 and 5):
  													<input type="number" name="ordercount" min="1" max="5">
  													<input type="submit">
												</form>
 			
		</c:forEach>
		
		<form method="post">
		
			핫or아이스: <input type="radio" name="hot_ice" value="HOT" checked> HOT &nbsp;&nbsp;
  					<input type="radio" name="hot_ice" value="ICE"> ICE <br/><br/>
  						
			사이즈: <input type="text" name="xname1">
				<select name="xnameBox1"  onChange="getSelectValue1(this.form);">
						<option selected value="option1">Midium</option>
						<option value="option2">Small</option>
						<option value="option3">Large</option>						
				</select><br/><br/>
							
			시럽: <input type="text" name="xname2">
				<select name="xnameBox2"  onChange="getSelectValue2(this.form);">
						<option selected value="option1">설탕 시럽</option>
						<option value="option2">초코 시럽</option>
						<option value="option3">딸기 시럽</option>			
				</select><br/><br/>
			샷: <input type="text" name="xname3">
				<select name="xnameBox3"  onChange="getSelectValue3(this.form);">
						<option selected value="option1">샷 추가1</option>
						<option value="option2">샷 추가2</option>
						<option value="option3">샷 추가3</option>					
				</select><br/><br/>		
			
			
			<input type="submit" value="담기"/>&nbsp;&nbsp;
			<input type="button" onclick="alert('Hello World!')" value="바로 주문">
		</form>
	</body>
</html>