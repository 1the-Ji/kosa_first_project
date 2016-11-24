<%@ page contentType="text/html;charset=UTF-8" %>

<div id="orderModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Event</b></h4>
      </div>
      <div class="modal-body">
		<form action = "/myweb/order/termList" accept-charset="utf-8" name = "termList" method = "post"> 
		          <fieldset style = "width:350">
		         	<legend>조회 기간</legend>
		                 <br>
		                   시작 날짜 입력<br>
		                   <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date1" step = "1">
		                   <br><br>
		                   끄읕 날짜 입력<br>
		                   <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date2" step = "1">
		                   <br><br>
		                   <input type = "submit" value = "검색"/>
		                   <input type = "reset" value = "리셋"/><br><br>
		           </fieldset>
		   </form>
		
		
		<table class="table table-bordered">
			<tr class="success">
				<th style="border: 1px solid black;">번호</th>
				<th style="border: 1px solid black;">사용자</th>
				<th style="border: 1px solid black;">시간</th>
				<th style="border: 1px solid black;">가격</th>
				<th style="border: 1px solid black;">결제 내용</th>
			</tr>
			<c:forEach var="orderList" items="${list}">
				<tr class="info">
					<th style="border: 1px solid black;">
						<a href="detailList?ogid=${orderList.ogid}" data-rel="dialog">${orderList.ogid}</a>
					</th>
					<th style="border: 1px solid black;">${orderList.user_id}</th>
					<th style="border: 1px solid black;">${orderList.ogtime}</th>
					<th style="border: 1px solid black;">${orderList.ogtotalprice}</th>
					<th style="border: 1px solid black;">${orderList.oghowpay}</th>
				</tr>
			</c:forEach>
		
		</table>
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
