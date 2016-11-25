<%@ page contentType="text/html;charset=UTF-8" %>

<div id="menuModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document" style="width:800px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>Menu List</b></h4>
      </div>
      <div class="modal-body">
			<p>	
	      		<a id="btnMenuRegForm" type="button" class="btn btn-info" href="#">메뉴 등록</a>
	      	</p>
      		<br/>
      	
	   		<table style="width:100%">
	   			<tr>
	   				<td style="text-align: center;">
		        		<div style="width:150px;height:150px;display:inline-block; margin:10px;">
		        			<img class="menuImg" width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/m5.jpg" />
		        			<br/>
		        			카페라떼 HOT
							<br/>
							3500won	
		        		</div>
		                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
		                	<img width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w5.jpg" />
		                	<br/>
		                	아메리카노 ICE
					        <br/>
					        4500won
		                </div>
		                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
		                	<img width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" />
		                	<br/>
		                	누텔라쿠키
					        <br/>
					        4500won
		                </div>
		                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
		                	<img width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/m3.jpg" />
		                	<br/>
		                	슈크림 쿠키
					        <br/>
					        2000won
		                </div>
		            	<div style="width:150px;height:150px;display:inline-block; margin:10px;">
		            		<img width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w4.jpg" />
		            		<br/>
		            		코코아 HOT
					        <br/>
					        5000won
		            	</div>
		                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
		                	<img width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w2.jpg" />
		                	<br/>
		                	자스민티 ICE
					        <br/>
					        5500won
		                </div>
		                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
		                	<img width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w4.jpg" />
		                	<br/>
		                	마시멜로라떼 HOT
					        <br/>
					        6000won
		                </div>
		                <div style="width:150px;height:150px;display:inline-block; margin:10px;">
		                	<img width="150px" height="150px" src="${pageContext.servletContext.contextPath}/resources/photo/w7.jpg" />
		                	<br/>
		                	에스프레소프랍 ICE
					        <br/>
					        5800won
		                </div>
	   				</td>
	   			</tr>
   			</table>

      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-warning">처음</button>
			<button type="button" class="btn btn-warning">1</button>
			<button type="button" class="btn btn-warning">맨끝</button>
      </div>
    </div>
  </div>
</div> 
