<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>MenuList</b></h4>
      </div>
      <div class="modal-body">
      	<p>	<h6>
      		<c:if test="${login!=null}">
	   		<a href="${pageContext.servletContext.contextPath}/menu/register">[메뉴 등록]</a>
	   		</c:if>
	   		<a href="${pageContext.servletContext.contextPath}/index">[메인ㄱㄱ]</a>
	   		</h6>
   		</p>
   		
		<c:forEach var="menu" items="${list}">
			<a href="info?mid=${menu.mid}">
				<div style="width:130px; height:160px; margin:5px; display:inline-block;"><br/>
					<img src="${pageContext.servletContext.contextPath}/menu/showPhoto?msavedfile=${menu.msavedfile}" style="width:120px; height:130px;"/> 
					<br/> 
					${menu.mname} ${menu.hot_ice}
					<br/>
	  				${menu.mprice}
	  				<br/>
 				</div>
			</a>
		</c:forEach>	
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
		
        <!-- 
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button> 
        -->
      </div>
    </div>
  </div>
</div> 
