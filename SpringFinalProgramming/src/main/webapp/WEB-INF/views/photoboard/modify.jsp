<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
	</head>

	<body>
	글 수정
	<hr />
	<form method="post" enctype="multipart/form-data"> <%-- input type="file"일시 반드시 enctype="multipart/form-data 작성 --%>
		<input type="hidden" name="bno" value="${photoBoard.bno}"/>
		<table>
			<tr>
				<td style="background-color:orange; width:70">제목</td>
				<td ><input type="text" name="btitle" style="width: 600px" value="${photoBoard.btitle}"/><br/></td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70">내용</td>
				<td><textarea rows="10" cols="50" name="bcontent" style="width: 600px; height:200px">${photoBoard.bcontent}</textarea><br/></td>
			</tr>
			<tr>
				<td rowspan=2 style="background-color:orange; width:70">사진</td>
				<td><input type="file" name="photo"></td>
			</tr>
			<tr>	
				<td>기존파일 : ${photoBoard.savedfile}</td>
			</tr>
		</table>
		<input type="submit" value="글수정"/>
	</form>
</body>
	
</html>