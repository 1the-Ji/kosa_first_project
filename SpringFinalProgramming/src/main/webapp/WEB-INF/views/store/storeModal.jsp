<%@ page contentType="text/html;charset=UTF-8" %>

<div id="storeModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">매장정보 확인</h4>
      </div>
      <div class="modal-body">
		<form><%-- input type="file"일시 반드시 enctype="multipart/form-data 작성 --%>
			
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
				<%-- <div style="width:150px; height:170px; margin:5px; background-image:url(showPhoto?savedfile=${sphoto.spic_savedfile}); background-size: 150px 170px;display:inline-block;">
    			</div> --%> 
    			<img id="i1" width="170" height="150" src="showPhoto?savedfile=${sphoto.spic_savedfile}" onError="this.style.visibility='hidden'"  style="cursor:hand" onclick="pop(this)">
			</c:forEach>
			
			<%-- <a href="modify?sid=${store.sid}">[수정]</a>
			<a href="../index">[확인]</a>
			<a href="../index">취소</a> --%>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">수정</button>
      </div>
    </div>
  </div>
</div> 
