<%@ page contentType="text/html;charset=UTF-8" %>


<%--이명진 --%>
<%--중요 --%>

<div id="detailListModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:1000px;">
     <div class="modal-content" style="height:700px">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title"><b>1개 주문 내역 상세 보기</b></h4>
       </div>
       <div class="modal-body">
 		<%--여기부터 --%>
 		<div class="wrapper" align="center" style="overflow-y:scroll;">
 		
         <table id="acrylic" style="width:900px">
             <thead>
                 <tr>
                     <th>품목</th>
                     <th>핫_아이스</th>
                     <th>수량</th>
                     <th>사이드</th>
                     <th>가격</th>
                 </tr>
             </thead>
             <tbody id="detailTbody">
             </tbody>
         </table>
     </div>
 		<%--pagination--%>
       <div class="modal-footer" style="text-align: left;">
       </div>
       
       <%--여기까지 --%>
 
 
       </div>
       
       
     
     </div>
   </div>
 </div>