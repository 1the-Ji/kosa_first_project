<%@ page contentType="text/html;charset=UTF-8" %>

  
 <%--이명진 --%>
 	<script type="text/javascript">
  		function getSelectValue1(frm)
  		{
 				frm.xname1.value = frm.xnameBox1.options[frm.xnameBox1.selectedIndex].text;
 				frm.optionValue.value = frm.xnameBox1.options[frm.xnameBox1.selectedIndex].value;
  		}
  		function getSelectValue2(frm)
  		{
 				frm.xname2.value = frm.xnameBox2.options[frm.xnameBox2.selectedIndex].text;
 				frm.optionValue.value = frm.xnameBox2.options[frm.xnameBox2.selectedIndex].value;
  		}
  		function getSelectValue3(frm)
  		{
 				frm.xname3.value = frm.xnameBox3.options[frm.xnameBox3.selectedIndex].text;
 				frm.optionValue.value = frm.xnameBox3.options[frm.xnameBox3.selectedIndex].value;
  		}
 	</script>
 	
 <div id="orderForm2Modal" class="modal fade" tabindex="-1" role="dialog">
   <div class="modal-dialog" role="document">
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title"><b>주문 2차 화면</b></h4>
       </div>
       <div class="modal-body">
 	<%--여기부터 --%>
 			<c:set var="mname" value="${requestScope.menu.mname}" scope="session" /> 
  			<c:out value="${requestScope.menu.mname}"/> <br/>
   			<c:out value="${requestScope.menu.msavedfile}"/>&nbsp;&nbsp;
  		<form method="post">
  			수량 : <input type="number" name="ordercount" min="1" max="5"><br/><br/>
  			
  			핫or아이스: <input type="radio" name="hot_ice" value="HOT" checked> HOT &nbsp;&nbsp;
  			
  			<input type="submit" value="담기"/>&nbsp;&nbsp;
  			<input type="button" onclick="alert('결제 기능 추가 예정')" value="바로 주문">
 
 		</form>	<c:out value="${requestScope.menu.mname}"/> <br/>
 	
 	<%--여기까지 --%>
 	
     </div>
     </div>
   </div>
 </div> 