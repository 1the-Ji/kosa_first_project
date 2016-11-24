<%-- 

<%@ page contentType="text/html;charset=UTF-8" %>




<div id="storeModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">매장정보 확인</h4>
      </div>
      <div class="modal-body">
		<form><input type="file"일시 반드시 enctype="multipart/form-data 작성">
			
			아이디: ${store.sid} <br/>
			
			이메일: ${store.semail}<br/>
			
			카페명: ${store.sname}<br/>
								
			지점명: ${store.slocal}<br/>
			
			주소: ${store.saddr}<br/>
			
			휴대전화: ${store.stel}<br/>
						
			오픈시간: <input type="time" name="sopen" value="${store.sopen}" readonly="readonly"><br/>
			
			마감시간: <input type="time" name="sclosed" value="${store.sclosed}" readonly="readonly"><br/>
			
			비콘번호: ${store.sbeacon}<br/>
		
			매장이미지:<br/><br/>
			<c:forEach var="sphoto" items="${list}">
				<div style="width:150px; height:170px; margin:5px; background-image:url(showPhoto?savedfile=${sphoto.spic_savedfile}); background-size: 150px 170px;display:inline-block;">
    			</div> 
    			<img id="i1" width="170" height="150" src="showPhoto?savedfile=${sphoto.spic_savedfile}" onError="this.style.visibility='hidden'"  style="cursor:hand" onclick="pop(this)">
			</c:forEach>
			
			<a href="modify?sid=${store.sid}">[수정]</a>
			<a href="../index">[확인]</a>
			<a href="../index">취소</a>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">수정</button>
      </div>
    </div>
  </div>
</div> 

 --%>
 
 
 
 
 
<%@ page contentType="text/html;charset=UTF-8"%>

<div id="storeModal" class="modal fade" tabindex="-1" role="dialog">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">매장정보 확인</h4>
			      </div>
			      <div class="modal-body">    
					      <article  class="container">
					        <div class="col-md-12">
					        <div class="page-header">
					    	    <h1>회원가입 <small>Membership application</small></h1>
					        </div>
									
					        <form class="form-horizontal">
					        
					        <div class="form-group">
					          <label class="col-sm-3 control-label" for="inputSid">아이디</label>
					        <div class="col-sm-6">
					          <input class="form-control" id="inputSid" type="text" placeholder="아이디">
					        </div>
					        </div>
					        
					        <div class="form-group">
					          <label class="col-sm-3 control-label" for="inputSemail">이메일</label>
					        <div class="col-sm-6">
					          <input class="form-control" id="inputSemail" type="email" placeholder="이메일">
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
				          <div class="col-sm-6">
				            <input class="form-control" id="inputSname" type="text">
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
	 		    <button type="submit" class="btn btn-primary">Join</button>
	 		    <button type="reset" class="btn btn-danger">Cancel</i></button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		       
		</div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->

  </body>
</html>

 
 
 
 
 

