<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--2016-11-16(수)--%>
<%--작성자: 이윤주--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		회원정보 수정
		<hr/>
		<form method="post" enctype="multipart/form-data"><%-- input type="file"일시 반드시 enctype="multipart/form-data 작성 --%>
			아이디: <input type="text" name="sid" value="${store.sid}">
			<input type ="button" href="checkSid">중복체크</a><br/>
			이메일: <input type="email" name="semail" value="${store.semail}"><br/>
			<%-- <select name="semail">
						<option selected>직접 입력</option>
						<option>@naver.com</option>
						<option>@daum.net</option>
						<option>@hotmail.com</option>
						<option>@nate.com</option>					
						<option>@yahoo.co.kr</option>		
						<option>@paran.com</option>
						<option>@empas.com</option>
						<option>@dreamwiz.com</option>
						<option>@freechal.com</option>					
						<option>@lycos.co.kr</option>	
						<option>@korea.com</option>
						<option>@gmail.com</option>
						<option>@hanmir.com</option>								
					</select> --%>
					
			비밀번호: <input type="password" name="spw"  value="${store.spw}"><br/>
			비밀번호  확인: <input type="password" name="spw"  value="${store.spw}"><br/>
			카페명: <input type="text" name="sname" value="${store.sname}"><br/> 
			<%-- <select name="sname">
						<option selected>직접 입력</option>
						<option>스타벅스</option>
						<option>탐앤탐스</option>
						<option>할리스 커피</option>
						<option>투썸플레이스</option>					
						<option>커핀그루나루</option>		
						<option>카페베네</option>
						<option>드롭탑</option>
						<option>파스쿠찌</option>
						<option>엔제리너스</option>					
						<option>커피빈</option>	
						<option>이디야</option>							
					</select> --%>
					
					
			지점명: <input type="text" name="slocal"  value="${store.slocal}"><br/>
			주소: <input type="text" name="saddr"  value="${store.saddr}"><br/>
			휴대전화:<select name="stel" required>
			<option value=SKT>SKT</option>
			<option value=KT>KT</option>
			<option vlaue=U+>U+</option>
			</select>
			<input type="tel" name="stel" value="${store.stel}" placeholder="-뺴고 숫자만 입력" required><br/>		
			오픈시간: <input type="time" name="sopen" value="${store.sopen}"><br/>
			마감시간: <input type="time" name="sclosed" value="${store.sclosed}"><br/>
			비콘번호: <input type="text" name="sbeacon" value="${store.sbeacon}"><br/>
			사진첨부: <input type = "file" name="sphoto" value="${sphoto.spic_savedfile}"><br/>
			<input type="submit" value="수정"/>
			<input type="reset" value="취소"/>
			<input type="button" value="탈퇴"/>
		</form>
	</body>
</html>