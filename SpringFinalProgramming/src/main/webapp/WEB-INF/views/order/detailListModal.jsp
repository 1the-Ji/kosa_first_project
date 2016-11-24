<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--이명진 --%>
<div id="detailListModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title"><b>1개 주문 내역 상세 보기</b></h4>
       </div>
       <div class="modal-body">
 		<%--여기부터 --%>
 		<div class="wrapper" align="center">
 		
         <table id="acrylic">
             <thead>
                 <tr>
                     <th>품목</th>
                     <th>수량</th>
                     <th>사이드</th>
                     <th>가격</th>
                 </tr>
             </thead>
             <tbody>
             	<%--테스트 데이터 --%>
             		<tr>
                     	<td data-label="제품명">아메리카노</td>
                     	<td data-label="수량">2</td>
                     	<td data-label="사이드">아이스 샷추가 설탕시럽</td>
                     	<td data-label="가격">11000</td>
                 	</tr>
                 	<tr>
                     	<td data-label="제품명">카페모카</td>
                     	<td data-label="수량">2</td>
                     	<td data-label="사이드">아이스 샷추가 설탕시럽</td>
                     	<td data-label="가격">13000</td>
                 	</tr>
             	<c:forEach var="detailOrders" items="${detailOrders}">
                 	<tr>
                     	<td data-label="제품명">${detailOrders.mname}</a></td>
                     	<td data-label="수량">${detailOrders.sameItemCount}</td>
                     	<td data-label="사이드">${detailOrders.xname}</td>
                     	<td data-label="가격">${detailOrders.sameItemPrice}</td>
                 	</tr>
                 </c:forEach>
             </tbody>
         </table>
     </div>
 		
       <%--뒤로가기 다이얼로그 위한 버튼 필요--%>
 
 		<%--pagination--%>
       <div class="modal-footer">
       	<a type="button" class="btn btn-primary" href="list?pageNo=1">처음</a>
       	
 		<c:if test="${groupNo>1 }">
 			<a type="button" class="btn btn-primary" href="list?pageNo=${startPageNo-1}">이전</a>
 		</c:if>
 		
 		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
 			<a type="button" class="btn btn-primary" href="list?pageNo=${i}" <c:if test="${pageNo==i}">style="color:red"</c:if>>${i}</a>
 		</c:forEach> 
 		 
 		<c:if test="${groupNo<totalGroupNo }">
 			<a type="button" class="btn btn-primary" href="list?pageNo=${endPageNo1 }">다음</a>
 		</c:if>
 		
 		<a type="button" class="btn btn-primary" href="list?pageNo=${totalPageNo }">맨끝</a>  
       </div>
       
       <%--여기까지 --%>
 
 
       </div>
       
       
     
     </div>
   </div>
 </div>