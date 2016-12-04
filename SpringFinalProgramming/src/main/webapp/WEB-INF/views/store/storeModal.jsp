<%@ page contentType="text/html;charset=UTF-8" %>

<div id="storeModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>가맹점 정보</b></h4>
      </div>
      <div id="modal-body" class="modal-body">
	    <table class="table table-striped custab">
		    <thead>
		    <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new categories</a>
		        <tr>
		            <th>매장아이디</th>
		            <th>매장이메일</th>
		            <th>매장이름</th>
		            <th>지점명</th>
		            <th>매장주소</th>
		            <th>매장전화번호</th>
		            <th>매장오픈시간</th>
		            <th>매장마감시간</th>
		            <th>비콘번호</th>
		           <!--  <th>매장사진</th> -->
		            <th class="text-center">수정/삭제</th>
		        </tr>
		    </thead>
		    
		    	<tbody id="storeTbody"></tbody>
				<!-- <tr>
		            <td id="sid"></td>
		            <td id="semail"></td>
		            <td id="semail2"></td>
		            <td id="sname"></td>
		            <td id="slocal"></td>
		            <td id="saddr"></td>
		            <td id="stel"></td>
		            <td id="sopen"></td>
		            <td id="sclosed"></td>
		            <td id="abeacon"></td>
		            <td>사진1</td>
		            <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
		      	</tr>
		  -->
	       		<tr>
		             <td>store1</td>
		             <td>store1@naver.com</td>
		             <td>스타벅스</td>
		             <td>송파구청점</td>
		             <td>서울 송파구 오금로 87</td>
		             <td>0221450300</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb1</td>
		             <td>사진1</td>
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	        	 </tr>
	
	        	 <tr>
		             <td>store2</td>
		             <td>store2@gmail.com</td>
		             <td>스타벅스</td>
		             <td>잠실점</td>
		             <td>서울 송파구 올림픽로35가길 9 잠실 푸르지오 월드마크</td>
		             <td>027588652</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb2</td>	
		             <td>사진2</td>            
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	        	 </tr>
	            
	            <tr>
		             <td>store3</td>
		             <td>store3@nate.com</td>
		             <td>스타벅스</td>
		             <td>잠실역점</td>
		             <td>서울 송파구 송파대로 562 한빛프라자, 삼성웰리스 아파트</td>
		             <td>027588077</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb3</td>	
		             <td>사진3</td>            
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	             </tr> 
	             
	             <tr>
		             <td>store4</td>
		             <td>store4@nate.com</td>
		             <td>스타벅스</td>
		             <td>잠실역점</td>
		             <td>서울 송파구 송파대로 562 한빛프라자, 삼성웰리스 아파트</td>
		             <td>027588077</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb4</td>	
		             <td>사진4</td>            
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	             </tr> 
	             
	             <tr>
		             <td>store5</td>
		             <td>store5@nate.com</td>
		             <td>할리스커피</td>
		             <td>방이점</td>
		             <td>서울 송파구 오금로11길 44 동주골프연습장</td>
		             <td>024157705</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb5</td>	
		             <td>사진5</td>            
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	             </tr> 
	             
	             <tr>
		             <td>store6</td>
		             <td>store6@naver.com</td>
		             <td>드롭탑</td>
		             <td>송파가락점</td>
		             <td>서울 송파구 양재대로60길 3-5 보우빌딩</td>
		             <td>0230120702</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb6</td>	
		             <td>사진6</td>            
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	             </tr> 
	             
	             <tr>
		             <td>store7</td>
		             <td>store7@naver.com</td>
		             <td>탐앤탐스</td>
		             <td>신천역점</td>
		             <td>서울 송파구 올림픽로12길 5 정호빌딩</td>
		             <td>024204565</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb7</td>	
		             <td>사진7</td>            
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	             </tr> 
	             
	             <tr>
		             <td>store8</td>
		             <td>store8@gmail.com</td>
		             <td>투썸플레이스</td>
		             <td>롯데월드점</td>
		             <td>서울 송파구 올림픽로 240 롯데월드</td>
		             <td>024110592</td>
		             <td>09:00</td>
		             <td>23:00</td>
		             <td>sb8</td>	
		             <td>사진8</td>            
		             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	             </tr> 
	    </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">변경사항 저장</button> 
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        
      </div>
    </div>
  </div>
</div> 
