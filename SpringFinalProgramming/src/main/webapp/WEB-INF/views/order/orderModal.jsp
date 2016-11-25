<%@ page contentType="text/html;charset=UTF-8" %>

<div id="orderModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>주문 내역 전체 보기</b></h4>
      </div>
      <div class="modal-body">

		<div class="wrapper" align="center">
			<form action = "/myweb/order/termList" accept-charset="utf-8" name = "termList" method = "post"> 
	           <fieldset style = "width:350"><br>
	                    조회 날짜 : <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date1" step = "1">
	                    ~ <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date2" step = "1">
	                    <input id="termList" type = "submit" onclick="termList()" value = "검색"/>
	                    <input type = "reset" value = "리셋"/>
	            </fieldset>
	    	</form>
	    	
	        <table id="acrylic">
	            <thead>
	                <tr>
	                    <th>주문번호</th>
	                    <th>아이디</th>
	                    <th>주문시간</th>
	                    <th>총 가격</th>
	                    <th>결제 방식</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<%--테스트 데이터 --%>
	            		<tr>
	                    	<td class="detailList" data-label="주문번호"><a type="button" class="btn btn-primary" href="#">주문번호1</a></td>
	                    	<td data-label="아이디">user1</td>
	                    	<td data-label="주문시간">2016-11-26</td>
	                    	<td data-label="총 가격">23000</td>
	                    	<td data-label="결제 방식">현금결제</td>
	                	</tr>
	                	<tr>
	                    	<td class="detailList" data-label="주문번호"><a type="button" class="btn btn-primary" href="#">주문번호2</a></td>
	                    	<td data-label="아이디">user2</td>
	                    	<td data-label="주문시간">2016-11-28</td>
	                    	<td data-label="총 가격">30000</td>
	                    	<td data-label="결제 방식">카드결제</td>
	                	</tr>
	            	<c:forEach var="orderList" items="${list}">
	                	<tr>
	                    	<td class="detailList" data-label="주문번호"><a  type="button" class="btn btn-primary" href="#">${orderList.ogid}</a></td>
	                    	<td data-label="아이디">${orderList.user_id}</td>
	                    	<td data-label="주문시간">${orderList.ogtime}</td>
	                    	<td data-label="총 가격">${orderList.ogtotalprice}</td>
	                    	<td data-label="결제 방식">${orderList.oghowpay}</td>
	                	</tr>
	                </c:forEach>
	            </tbody>
	        </table>
    	</div>
		<a id="orderForm1" type="button" class="btn btn-primary" href="#">주문하기</a>
      </div>
      <div class="modal-footer">

      	<a type="button" class="btn btn-primary" href="list?pageNo=1">처음</a>
      	
		<c:if test="${groupNo>1 }">
			<a type="button" class="btn btn-primary" href="list?pageNo=${startPageNo-1}">이전</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
			<a type="button" class="btn btn-primary" href="list?pageNo=${i}" <c:if test="${pageNo==i}">style="color:red"</c:if>>${i}</a>
		</c:forEach> 
		 
		<c:if test="${groupNo<totalGroupNo }">
			<a type="button" class="btn btn-primary" href="list?pageNo=${endPageNo+1 }">다음</a>
		</c:if>
		
		<a type="button" class="btn btn-primary" href="list?pageNo=${totalPageNo }">맨끝</a>  

      </div>
    </div>
  </div>
</div> 
