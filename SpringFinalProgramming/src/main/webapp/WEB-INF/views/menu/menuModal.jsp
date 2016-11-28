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
      		<button type="button" class="btn btn-info btn-filter" data-target="All">All</button>
			<button type="button" class="btn btn-danger btn-filter" data-target="커피">Coffee</button>
			<button type="button" class="btn btn-warning btn-filter" data-target="차">Tea</button>
			<button type="button" class="btn btn-success btn-filter" data-target="디저트">Dessert</button>
			<button type="button" class="btn btn-default btn-filter" data-target="기타">Etc</button>
		</div>
		<hr/>
     		
   		<table style="width:100%">
   			<tr>
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
	        		<%-- 
	                <div style="width:150px;height:150px;display:inline-block; margin:10px;" data-status="${menu.mgroup}">
	                	<a href="#"><img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w5.jpg" /></a>
	                	<br/>
	                	아메리카노 ICE
				        <br/>
				        4500won
	                </div>
	                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
	                	<a href="#"><img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" /></a>
	                	<br/>
	                	누텔라쿠키
				        <br/>
				        4500won
	                </div>
	                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
	                	<a href="#"><img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" /></a>
	                	<br/>
	                	슈크림 쿠키
				        <br/>
				        2000won
	                </div>
	            	<div style="width:150px;height:150px;display:inline-block; margin:10px;">
	            		<a href="#"><img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w4.jpg" /></a>
	            		<br/>
	            		코코아 HOT
				        <br/>
				        5000won
	            	</div>
	                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
	                	<a href="#"><img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w2.jpg" /></a>
	                	<br/>
	                	자스민티 ICE
				        <br/>
				        5500won
	                </div>
	                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
	                	<a href="#"><img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w4.jpg" /></a>
	                	<br/>
	                	마시멜로라떼 HOT
				        <br/>
				        6000won
	                </div>
	                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
	                	<a href="#"><img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w7.jpg" /></a>
	                	<br/>
	                	에스프레소프랍 ICE
				        <br/>
				        5800won
	                </div> 
	                --%>
   					</td>
   			</tr>
  		</table>
      </div>
      
      <div class="modal-footer">
      	<div align="center">
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
      	</div>
      	<div>
      		<c:if test="${login != null}">
      		<a id="btnMenuRegForm" type="button" class="btn btn-info" href="#">메뉴 등록</a>
      		</c:if>
      	</div>
			
      </div>
    </div>
  </div>
</div> 
