<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
	</head>

	<body>
	글쓰기
	<hr />
	<form method="post">
		<table>
			<tr >
				<td style="background-color:orange; width:70">제목:</td>
				<td ><input type="text" name="btitle" style="width: 600px" value="${freeboard.btitle}"/><br/></td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70">내용:</td>
				<td><textarea rows="10" cols="50" name="bcontent" style="width: 600px; height:200px">${freeboard.bcontent}</textarea><br/></td>
			</tr>
		</table>
		<input type="submit" value="글쓰기"/>
	</form>
</body>
</html>