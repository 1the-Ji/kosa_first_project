<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
		</head>
		<body>
			<h1>event 등록</h1>
			<hr/>
			<form method="post">
				<table>
					<tr>
						<td>이벤트 제목 :</td>
						<td><input name="etitle"  type="text" /><br/></td>
					</tr>
					<tr>
						<td>기간 :</td>
						<td><input name="estartperiod" type="date"> ~ <input name="elastperiod" type="date"><br/></td>			
					</tr>
					<tr>
						<td>내용 :</td>
						<td><textarea name="econtents" rows="5" cols="30"></textarea></td> 
					</tr>
				</table>	
			<input type="submit" value ="등록"/>
			</form>
		</body>
	</html>