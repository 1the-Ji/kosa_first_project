<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 보나 20161116 --%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      
       <%--<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">--%>
       <link href="${pageContext.servletContext.contextPath}/resources/css/menulist.css" rel="stylesheet"/> 
       <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/menulist.js"></script>  
      
      	<%-- <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"/>
		<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css"/>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css"/>	
		<link href="${pageContext.servletContext.contextPath}/resources/css/style_1.css" rel="stylesheet"/>	
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css" />	
		
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css"> 
    	<link href="${pageContext.servletContext.contextPath}/resources/css/waves.css" rel="stylesheet" />
    	<link href="${pageContext.servletContext.contextPath}/resources/css/animate.css" rel="stylesheet"/>

		 		
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/waves.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/admin.js"></script>
		--%>	
						
		
   </head>
   <body>
   <%-- 
   		<div class="wrap">
			<!-- nav 영역을 호출할 버튼  -->
			<a class="btnMenu" href="#"><i class="fa fa-navicon"></i> </a>
			<!-- 실제 카테고리 메뉴가 들어갈 nav 영역 -->
			<nav>
				<h1><img src="resources/photo/logo.png" /></h1>
				<ul id="gnb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Store</a></li>
					<li><a href="#">Menu</a></li>
					<li><a href="#">Event</a></li>
					<li><a href="#">Order</a></li>
				</ul>
				<div style="position:relative; top:80%;" class="form-group text-center">
                 <a id="btnLogin" href="#"><button class="btn btn-success btn-login-submit">Login</button></a>
                </div>
			</nav>
			
			<!-- 3개의 컨텐츠 박스가 들어갈 section 영역 -->
			<section>			
				<!-- 첫 번째 박스 -->
				<div style="background-image:${pageContext.servletContext.contextPath}/resources/photo/background.jpg" class="box1">				 
				</div>
				
			</section>
		</div> --%>
   		
   		<!-- ######### Menu Modal ########## -->
   	
		<div id="menuModal" class="modal fade" role="dialog" >
		  <div class="modal-dialog" role="document"  style="left: 100px; position: relative;">
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
	   					<img src="${pageContext.servletContext.contextPath}/menu/showPhoto?msavedfile=${menu.msavedfile}"
	   					style="width:120px; height:130px;"/> <br/>
	   					${menu.mname} ${menu.hot_ice}<br/>
		   				${menu.mprice}<br/>
	   					</div>
   					</a>
   					</c:forEach>				
		      </div>
		      <div class="modal-footer">
		      	<a href="list?pageNo=1">[처음]</a>
				<c:if test="${groupNo>1 }">
				<a href="list?pageNo=${startPageNo-1}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				 <a href="list?pageNo=${i}" 
				 	<c:if test="${pageNo==i}">style="color:red"</c:if>>
				 ${i}</a>
				</c:forEach> 
				 
				<c:if test="${groupNo<totalGroupNo }">
				<a href="list?pageNo=${endPageNo+1 }">[다음]</a>
				</c:if>
				<a href="list?pageNo=${totalPageNo }">[맨끝]</a>
		        <!-- 
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button> 
		        -->
		      </div>
		    </div>
		  </div>
		</div>  

		<!-- ################### -->
   		

   </body>
</html>