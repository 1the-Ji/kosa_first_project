<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:800px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h1 class="modal-title" align="center"><b>Menu List</b></h1>
       
      </div>
      <div class="modal-body" align="center">
      	<div class="btn-group">
      		<button onclick="btnMenuList('전체')" type="button" class="btn btn-info btn-filter">All</button>
			<button onclick="btnMenuList('커피')" type="button" class="btn btn-info btn-filter">Coffee</button>
			<button onclick="btnMenuList('차')" type="button" class="btn btn-info btn-filter">Tea</button>
			<button onclick="btnMenuList('디저트')" type="button" class="btn btn-info btn-filter">Dessert</button>
			<button onclick="btnMenuList('기타')" type="button" class="btn btn-info btn-filter">Etc</button>
		</div>
		<hr/>
     		
   		<table id="menuListBody" style="width:100%">
   			
   			<%--<tr>
   				 <c:forEach var="menu" items="${list}">
	   				<td style="text-align: center;">
		        		<div style="width:150px;height:150px;display:inline-block; margin:10px;" data-status="${menu.mgroup}">
		        			<a href="javascript:showMenuInfo(${menu.mid})"><img width="150px" height="150px" src="showPhoto?msavedfile=${menu.msavedfile}" /></a>
		        			<br/>
		        			${menu.mname} ${menu.hot_ice}
							<br/>
							${menu.mprice}won	
		        		</div>
		        </c:forEach>
	        		
   					</td>
   			</tr> --%>
  		</table>
      </div>
      
      <div class="modal-footer">
      	<%-- <div align="center">
      		<a href="list?pageNo=1"><button type="button" class="btn btn-warning">처음</button></a>
			
			<c:if test="${groupNo>1 }">
				<a href="list?pageNo=${startPageNo-1}"><button type="button" class="btn btn-warning">이전</button></a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				<a href="list?pageNo=${i}">
					<c:if test="${pageNo==i}">style="color:red"</c:if>
				 	<button type="button" class="btn btn-danger">${i}</button>
			 	</a>
			</c:forEach> 
			
			<c:if test="${groupNo<totalGroupNo }">
				<a href="list?pageNo=${endPageNo+1 }"><button type="button" class="btn btn-warning">다음</button></a>
			</c:if>
			
			<a href="list?pageNo=${totalPageNo }"><button type="button" class="btn btn-warning">[맨끝]</button></a>
      	</div> --%>
      	<%-- <div>
      		<c:if test="${login != null}">
      		<a id="btnMenuRegForm" type="button" class="btn btn-info" href="#">메뉴 등록</a>
      		</c:if>
      	</div> --%>
			
      </div>
    </div>
  </div>
</div> 
