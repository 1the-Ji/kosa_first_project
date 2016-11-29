<%@ page contentType="text/html;charset=UTF-8" %>

<%--2016-11-28(월)--%>
<%--작성자: 이윤주--%>

<div id="joinModal" class="modal fade" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document" style="width:800px">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><h2>회원가입 <small>Membership application</small></h2></h4>
	
	      </div>
	      <div class="modal-body">
	      
	      <article  class="container">
	        <form class="form-horizontal">
	        
	        <div class="form-group">
	          <label class="col-sm-3 control-label" for="inputSid">아이디</label>
	        <div class="col-sm-6">
	          <input class="form-control" id="inputSid" type="text" placeholder="아이디">
	        </div>
	        </div>
	        
	        <div class="form-group">
	          	<label class="col-sm-3 control-label" for="inputSemail">이메일</label>
		        <div class="col-md-9">
		          <input id="inputSemail" type="text" placeholder="이메일">@<input id="inputSemail2" type="text">
		          <select id="selectSemail" style="width:100px;margin-right:10px">
					     <option value="naver.com">naver.com</option>
					     <option value="hanmail.net">hanmail.net</option>
					     <option value="hotmail.com">hotmail.com</option>
					     <option value="nate.com">nate.com</option>
					     <option value="yahoo.co.kr">yahoo.co.kr</option>
					     <option value="empas.com">empas.com</option>
					     <option value="dreamwiz.com">dreamwiz.com</option>
					     <option value="freechal.com">freechal.com</option>
					     <option value="lycos.co.kr">lycos.co.kr</option>
					     <option value="korea.com">korea.com</option>
					     <option value="gmail.com">gmail.com</option>
					     <option value="hanmir.com">hanmir.com</option>
					     <option value="paran.com">paran.com</option>
					     <option value="" selected>직접입력</option>
					</select>
		        </div>

	        </div>
	        
	        <div class="form-group">
	          <label class="col-sm-3 control-label" for="inputSpw">비밀번호</label>
	        <div class="col-sm-6">
	          <input class="form-control" id="inputSpw" type="password" placeholder="비밀번호">
	        <p class="help-block">숫자, 특수문자 포함 8자 이상</p>
	        </div>
	        </div>
	        
	         <div class="form-group">
	              <label class="col-sm-3 control-label" for="inputSpwCheck">비밀번호 확인</label>
	             <div class="col-sm-6">
	              <input class="form-control" id="inputSPwCheck" type="password" placeholder="비밀번호 확인">
	                <p class="help-block">비밀번호를 한번 더 입력해주세요.</p>
	             </div>
	          </div>
	          
 	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="inputSname">카페명</label>
	          <div class="col-md-9">
	            <input id="inputSname" placeholder="카페명" type="text">
	            <select id="selectSname">
					<option valeu="스타벅스">스타벅스</option>
					<option value="탐앤탐스">탐앤탐스</option>
					<option value="할리스 커피">할리스 커피</option>
					<option value="투썸플레이스">투썸플레이스</option>					
					<option value="커핀그루나루">커핀그루나루</option>		
					<option value="카페베네">카페베네</option>
					<option value="드롭탑">드롭탑</option>
					<option value="파스쿠찌">파스쿠찌</option>
					<option value="엔제리너스">엔제리너스</option>					
					<option value="커피빈">커피빈</option>	
					<option value="이디야">이디야</option>		
					<option value="" selected>직접입력</option>					
				</select><br/>
	          </div>
	        </div> 
	      
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="inputSlocal">지점명</label>
	          <div class="col-sm-6">
	            <input class="form-control" id="inputSlocal" type="text" >
	          </div>
	        </div>
	        
	        
	        
	        
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="inputStel">대표전화</label>
	        <div class="col-sm-6">
	           <input type="tel" class="form-control" id="inputNumber" placeholder="- 없이 입력해 주세요" />
              	  </div>
               </div>
               
            <div class="form-group">
	            <label class="col-sm-3 control-label" for="inputSopen">오픈시간</label>
	          <div class="col-sm-6">
	            <input class="form-control" id="inputSopen" type="time" >
	          </div>
	        </div>
	        
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="inputSclosed">마감시간</label>
	          <div class="col-sm-6">
	            <input class="form-control" id="inputSclosed" type="time" >
	          </div>
	        </div>
	        
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="inputSbeacon">비콘번호</label>
	          <div class="col-sm-6">
	            <input class="form-control" id="inputSbeacon" type="text" >
	          </div>
	        </div>
	        
	       <div class="form-group">
	          	<label class="col-sm-3 control-label" for="inputSphoto">사진첨부</label>
		       <div class="col-md-9">
		          <input id="inputSphoto" type="file" multiple="multiple">  
       			</div>
	        </div>
	       
	        <div class="form-group">
	              <label class="col-sm-3 control-label" for="inputAgree">약관 동의</label>
	            <div class="col-sm-6" data-toggle="buttons">
	              <label class="btn btn-warning active">
	                <input id="agree" type="checkbox" autocomplete="off" chacked>
	                  <span class="fa fa-check"></span>
	              </label>
	              <a href="#">이용약관</a> 에 동의 합니다.
	            </div>
	          </div>
	     
	        </form>
	          <hr>
	        </div>
	      </article>

	      
	      <div class="modal-footer"> 
	        <button class="btn btn-primary" type="submit">Join</button>
	        <button class="btn btn-danger" type="reset" >Cancel</button>
	        <button class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

