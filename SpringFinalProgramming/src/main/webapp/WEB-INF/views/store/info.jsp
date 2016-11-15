<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		매장정보
		<hr/>
		<form method="post">
			아 이 디:${store.sid} <br/>
			
			이메일:<input type="text" name="semail" value="${store.semail}"/> <br/>
			
			비밀번호:<input type="password" name="spw" value="${store.spw}"/> <br/>
			
			비밀번호 다시 입력:<input type="password" name="respw"/> <br/>
			
			이    름:<input type="text" name="sname" value="${store.sname} "/><br/>
	
			지점명:<input type="text" name="slocal" value="${store.slocal}"/> <br/>
			
			매장주소:<input type="text" name="saddr" value="${store.saddr}"/> <br/>

			매장번호:<input type="text" name="stel" value="${store.stel}"/> <br/>
			
			매장open:<input type="text" name="sopen" value="${store.sopen}"/> <br/>
			
			매장close:<input type="text" name="sclosed" value="${store.sclosed}"/> <br/>
			
			비콘번호:<input type="text" name="sbeacon" value="${store.sbeacon}"/> <br/>
			
			<input type="submit" value="내용수정"/>
		</form>
	</body>
</html>