<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuModal" class="modal fade" role="dialog" >
  <div class="modal-dialog" style="width:900px; height:600px;" tabindex="-1" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>MenuList</b></h4>
      </div>
      <div class="modal-body">
      	<p>	
      		<a id="btnMenuRegForm" type="button" class="btn btn-default" href="#">메뉴 등록</a>
      		<%-- 
      		<c:if test="${login!=null}">
	   		<a type="button" id="menuRegForm" class="btn btn-default" href="${pageContext.servletContext.contextPath}/menu/register">메뉴 등록</a>
	   		</c:if> --%>
   		</p>
   		
   		<br/>
   		
   		<div class="container">
            <div class="row">
        		<div class="col-md-4 col-sm-6 col-xs-8">
        			<img id="menuImg" class="img-responsive" src="${pageContext.servletContext.contextPath}/resources/photo/m5.jpg" />
        			<br/>
        			카페라떼 HOT
					<br/>
					3500won	
        		</div>
                <div class="col-md-4 col-sm-6 col-xs-8">
                	<img class="img-responsive" src="${pageContext.servletContext.contextPath}/resources/photo/w5.jpg" />
                	<br/>
                	아메리카노 ICE
			        <br/>
			        4500won
                </div>
                <div class="col-md-4 col-sm-6 col-xs-8">
                	<img class="img-responsive" src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" />
                	<br/>
                	누텔라쿠키
			        <br/>
			        4500won
                </div>
                <div class="col-md-4 col-sm-6 col-xs-8">
                	<img class="img-responsive" src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" />
                	<br/>
                	슈크림 쿠키
			        <br/>
			        2000won
                </div>
            	<div class="col-md-4 col-sm-6 col-xs-8">
            		<img class="img-responsive" src="${pageContext.servletContext.contextPath}/resources/photo/w4.jpg" />
            		코코아 HOT
			        <br/>
			        5000won
            	</div>
                <div class="col-md-4 col-sm-6 col-xs-8">
                	<img class="img-responsive" src="${pageContext.servletContext.contextPath}/resources/photo/w2.jpg" />
                	자스민티 ICE
			        <br/>
			        5500won
                </div>
            </div>
        </div>
   	  </div>
  <%--  		
   		<!-- <div class="row"> -->
		<table style="position: center">
			<tr style="width: 800px; hegith: 250px">
				<td>
					<tr style="height: 220px">
						<td>
							<a href="#">
		          				<img src="${pageContext.servletContext.contextPath}/resources/photo/m5.jpg" class="img-thumbnail">
		      				</a>
						</td>
						<td>
							<a href="#">
					        	<img src="${pageContext.servletContext.contextPath}/resources/photo/w5.jpg" class="img-thumbnail">
					        </a>
						</td>
						<td>
							<a href="#">
					            <img src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" class="img-thumbnail">
					        </a>
						</td>
					</tr>
					
					<tr style="height: 30px">
						<td>
							카페라떼 HOT
					        <br/>
					        3500won
						</td>
						<td>
							아메리카노 ICE
					        <br/>
					        4500won
						</td>
						<td>
							누텔라쿠키
					        <br/>
					        4500won
						</td>
					</tr>
				</td>
			</tr>
			
			<tr style="width: 800px; hegith: 250px">
				<td>
					<tr style="height: 220px">
						<td>
							<a href="#">
		          				<img src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" class="img-thumbnail">
		      				</a>
						</td>
						<td>
							<a href="#">
					        	<img src="${pageContext.servletContext.contextPath}/resources/photo/w4.jpg" class="img-thumbnail">
					        </a>
						</td>
						<td>
							<a href="#">
					            <img src="${pageContext.servletContext.contextPath}/resources/photo/w2.jpg" class="img-thumbnail">
					        </a>
						</td>
					</tr>
					
					<tr style="height: 30px">
						<td>
							슈크림 쿠키
					        <br/>
					        2000won
						</td>
						<td>
							코코아 HOT
					        <br/>
					        5000won
						</td>
						<td>
							자스민티 ICE
					        <br/>
					        5500won
						</td>
					</tr>
				</td>
			</tr>
					
		</table>
		 
		Ajax통신 시 사진 data처리
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
	--%>
		
	  

      <div class="modal-footer">
	      <button type="button" class="btn btn-default">처음</button>
	      <button type="button" class="btn btn-default">1</button>
	      <button type="button" class="btn btn-default">맨끝</button>
      
<%-- 
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
--%>
        <!-- 
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button> 
        -->
      </div>
    </div>
  </div>
</div> 
