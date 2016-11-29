<%@ page contentType="text/html;charset=UTF-8" %>

<div id="storeModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>가맹점 정보</b></h4>
      </div>
      <div class="modal-body">
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
		            <th class="text-center">수정/삭제</th>
		        </tr>
		    </thead>
	         <tr>
	             <td>store1</td>
	             <td>store1@naver.com</td>
	             <td>스타벅스</td>
	             <td>가락시장점</td>
	             <td>송파구 가락동 79</td>
	             <td>0233912232</td>
	             <td>09:00</td>
	             <td>23:00</td>
	             <td>sb1</td>
	             <td>사진1</td>
	             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	         </tr>
	         <tr>
	             <td>store2</td>
	             <td>store2@naver.com</td>
	             <td>이디야</td>
	             <td>가락시장점</td>
	             <td>송파구 가락동 80</td>
	             <td>0233912233</td>
	             <td>09:00</td>
	             <td>23:00</td>
	             <td>sb2</td>	
	             <td>사진2</td>            
	             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
	         </tr>
	         <tr>
	             <td>store3</td>
	             <td>store3@naver.com</td>
	             <td>자스</td>
	             <td>가락시장점</td>
	             <td>송파구 가락동 81</td>
	             <td>0233912234</td>
	             <td>09:00</td>
	             <td>23:00</td>
	             <td>sb3</td>	
	             <td>사진3</td>            
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
