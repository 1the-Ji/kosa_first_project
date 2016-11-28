<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuRegModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:800px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Menu Register</b></h4>
      </div>
      <div class="modal-body">
      	<form method="post" enctype="multipart/form-data">
	   		<table id = "acrylic">
	   			<tr>
	   				<thead>
	   					<td style="width:70px">분류</td>
	   				</thead>
	   				<tbody>
		   				<td>
		   					<select name="mgroup">
		   						<option selected>커피</option>
		   						<option>차</option>
		   						<option>디저트</option>
		   						<option>기타</option>
		   					</select>
		   				</td>
	   				</tbody>
	   			</tr>
	   			<tr>
	   				<thead>
	   					<td style="width:70px">분류</td>
	   				</thead>
	   				<td><input type="text" name="mname" style="width:200px;"></td>
	   			</tr>
	   			<tr>
	   				<thead>
	   					<td style="width:70px">Hot/Ice</td>
	   				</thead>
	   				<tbody>
	   					<td>
	   					<input type="radio" name="hot_ice" checked value="HOT"> HOT
	   					<input type="radio" name="hot_ice" value="ICE"> ICE
	   					<input type="radio" name="hot_ice" value=" "> 없음
	   				</td>
	   				</tbody>
	   			</tr>
	   			<tr>
	   				<thead>
	   					<td style="width:70px">가격</td>
	   				</thead>
	   				<tbody>
	   					<td><input type="text" name="mprice" style="width:100px;"></td>
	   				</tbody>
	   			</tr>
	   			<tr>
	   				<thead>
	   					<td style="width:70px">설명</td>
	   				</thead>
	   				<tbody>
	   					<td><input type="text" name="mcontents" style="width:600px; height:300px"></td>
	   				</tbody>
	   			</tr>
	   			<tr>
					<thead>
	   					<td style="width:70px">사진</td>
	   				</thead>
					<tbody>
						<td><input type="file" name="photo"/></td>
					</tbody>
				</tr>
	   		</table>
		 </form>
      </div>
      <div class="modal-footer">
	      <button class="btnMenuReg" type="button" class="btn btn-default">등록</button>
	      <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div> 
