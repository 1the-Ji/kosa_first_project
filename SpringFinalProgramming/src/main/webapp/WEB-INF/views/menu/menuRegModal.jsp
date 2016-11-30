<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuRegModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:600px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Menu Register</b></h4>
      </div>
      <div class="modal-body">
      	<form class="form-horizontal" method="post" enctype="multipart/form-data">
			<fieldset>
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="mgroup">분류</label>  
				  <div class="col-md-4">
				  	<select name="mgroup">
   						<option selected>커피</option>
   						<option>차</option>
   						<option>디저트</option>
   						<option>기타</option>
   					</select>
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="mname">메뉴이름</label>  
				  <div class="col-md-4">
				  	<input name="netmask" type="text" placeholder="예: 아메리카노" class="form-control input-md" required="">
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="hot_ice">핫/아이스</label>  
				  <div class="col-md-4">
				  	<input type="radio" name="hot_ice" checked value="HOT"> HOT
	   				<input type="radio" name="hot_ice" value="ICE"> ICE
	   				<input type="radio" name="hot_ice" value=" "> 없음
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="mprice">가격</label>  
				  <div class="col-md-4">
				  	<input name="mprice" type="text" placeholder="예: 2500" class="form-control input-md">원
				  </div>
				</div>
				
				<!-- Textarea -->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="mcontents">설명</label>
				  <div class="col-md-4">                     
				    <textarea class="form-control" placeholder="예: 따뜻한 아메리카노입니다." name="mcontents"></textarea>
				  </div>
				</div>
				
				<!-- Textarea -->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="photo">사진</label>
				  <div class="col-md-4">                     
				    <input type="file" name="photo" /></textarea>
				  </div>
				</div>
			</fieldset>
		</form>
      </div>
       
      <div class="modal-footer">
	      <button class="btnMenuReg" type="button" class="btn btn-default">등록</button>
	      <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div> 
