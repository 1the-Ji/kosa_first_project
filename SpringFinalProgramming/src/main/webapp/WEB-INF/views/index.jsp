<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<title> ex3 step6 </title>
			   
		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">	
		<link href="${pageContext.servletContext.contextPath}/resources/css/style_1.css" rel="stylesheet"/>		
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css" />	
		
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css"> 
    	<link href="${pageContext.servletContext.contextPath}/resources/css/waves.css" rel="stylesheet" >
    	<link href="${pageContext.servletContext.contextPath}/resources/css/animate.css" rel="stylesheet"/>

		<link href="${pageContext.servletContext.contextPath}/resources/css/index.css" rel="stylesheet"/>  		
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/waves.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/admin.js"></script>
				
		<link href="${pageContext.servletContext.contextPath}/resources/css/index.css" rel="stylesheet"/>				
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/index.js"></script>
	</head> 
	<body>
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
				<div class="box1 on">
					<p></p>
					<p><span>Play & Dolls</span></p>
					<p></p>
					<p><strong>Vogue Kids</strong></p>
					<p></p>
					<p><span>Clothes</span></p>
					<p></p>
				</div>
				
				<!-- 두 번째 박스 -->
				<div class="box2">
					<p><strong>Vogue Homme</strong></p>
					<p></p>
					<p>	
						<em><a href="#"><i class="fa fa-twitter"></i></a></em>
						<em><a href="#"><i class="fa fa-facebook"></i></a></em>
						<em><a href="#"><i class="fa fa-envelope"></i></a></em>
					</p>
					<p></p>
					<p></p>
					<p><span>Travis Crown</span></p>
					<p><span><a href="${pageContext.servletContext.contextPath}/store/info">매장정보보기</a></span></p>
					<p></p>
					<p><span>Best Qualified  Goods</span></p>
					<p></p>
					<p><span><a href="${pageContext.servletContext.contextPath}/sphoto/write">사진첨부하기</a></span></p>
				</div>
				
				<!-- 세 번째 박스 -->
				<div class="box3">
					<p><span>tremendous</span></p>
					<p></p>
					<p><strong>Vogue Girl</strong></p>
					<p></p>
					<p></p>
					<p></p>
					<p><span><a href="${pageContext.servletContext.contextPath}/menu/list">메뉴리스트</a></span></p>
					<p></p>
					<p><span><a href="#">메뉴옵션</a></span></p>
					<p></p>
					<p></p>
				</div>
				
				<!-- 네 번째 박스 -->
				<div class="box4">
					<p></p>
					<p><span><a id="btnEvent" href="#">이벤트리스트</a></span></p>
					<p></p>
					<p><strong>Vogue Kids</strong></p>
					<p></p>
					<p><span><a href="#">이벤트등록</a></span></p>
					<p></p>
				</div>
				
				<!-- 다섯 번째 박스 -->
				<div class="box5">
					<p><strong>Vogue Homme</strong></p>
					<p></p>
					<p>	
						<em><a href="#"><i class="fa fa-twitter"></i></a></em>
						<em><a href="#"><i class="fa fa-facebook"></i></a></em>
						<em><a href="#"><i class="fa fa-envelope"></i></a></em>
					</p>
					<p></p>
					<p></p>
					<p><span><a href="${pageContext.servletContext.contextPath}/order/orderItems">주문하기</a></span></p>
					<p><a href="${pageContext.servletContext.contextPath}/order/list">주문리스트</a></p>
					<p></p>
					<p><span>Best Qualified  Goods</span></p>
					<p></p>
					<p><span>sport</span></p>
				</div>
			</section>
		</div>
		
		<!-- ######### Login Modal ########## -->
		<div id="loginModal" class="modal fade" tabindex="-1" role="dialog" >
		  <div class="modal-dialog" role="document"  style="left: 100px; position: relative;">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Admin<b>BSB</b></h4>
		      </div>
		      <div class="modal-body">
				<form id="sign_in" method="POST">
				    <div class="msg">Sign in to start your session</div>
				    <div class="input-group">
				        <span class="input-group-addon">
				            <i class="material-icons">person</i>
				        </span>
				        <div class="form-line">
				            <input type="text" class="form-control" name="sid" placeholder="Username" required autofocus>
				        </div>
				    </div>
				    <div class="input-group">
				        <span class="input-group-addon">
				            <i class="material-icons">lock</i>
				        </span>
				        <div class="form-line">
				            <input type="password" class="form-control" name="spw" placeholder="Password" required>
				        </div>
				    </div>
				    <div class="row">
				        <div class="col-xs-8 p-t-5">
				            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
				            <label for="rememberme">Remember Me</label>
				        </div>
				        <div class="col-xs-4">
				            <button class="btn btn-block bg-pink waves-effect" type="submit">SIGN IN</button>
				        </div>
				    </div>
				    <div class="row m-t-15 m-b--20">
				        <div class="col-xs-6">
				            <a href="join">Register Now!</a>
				        </div>
				        <div class="col-xs-6 align-right">
				          <a href="findSid">Forgot ID</a> / <a href="findSpw">Password</a>
				        </div>
				    </div>
				</form>
		      </div>
		      <div class="modal-footer">
		        <!-- 
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button> 
		        -->
		      </div>
		    </div>
		  </div>
		</div>   
		<!-- ################### -->  	
		<!-- ######### Event Modal ########## -->	
		<div id="eventModal" class="modal fade" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Modal title</h4>
		      </div>
		      <div class="modal-body">
		        <div class="container">
				  <div  class="row col-md-6 col-md-offset-2 custyle">
				    <table class="table table-striped custab">
					    <thead>
					    <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new categories</a>
					        <tr>
					            <th>No.</th>
					            <th>Title</th>
					            <th>time</th>
					            <th>content</th>
					            <th class="text-center">Action</th>
					        </tr>
					    </thead>
				         <tr>
				             <td>1</td>
				             <td>News</td>
				             <td>News Cate</td>
				             <td>new content</td>
				             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
				         </tr>
				         <tr>
				             <td>2</td>
				             <td>Products</td>
				             <td>Main Products</td>
				             <td>new content</td>
				             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
				         </tr>
				         <tr>
				             <td>3</td>
				             <td>Blogs</td>
				             <td>Parent Blogs</td>
				             <td>new content</td>
				             <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
				         </tr>
				    </table>
				    </div>
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- ################### -->  
			
	</body>
</html>















