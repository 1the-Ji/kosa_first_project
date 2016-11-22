<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />	
		<title> ex3 step6 </title>
		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css" />	
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/prefixfree.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
		
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css"> 
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
				<div style="position:relative; top:90%;" class="form-group text-center">
                 <a href="../myweb">  <button class="btn btn-success btn-login-submit">Login</button></a>
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
					<p><span><a href="${pageContext.servletContext.contextPath}/menu/list" class="btn-modal">메뉴리스트</a></span></p>
					<p></p>
					<p><span><a href="#">메뉴옵션</a></span></p>
					<p></p>
					<p></p>
				</div>
				
				<!-- 네 번째 박스 -->
				<div class="box4">
					<p></p>
					<p><span><a href="${pageContext.servletContext.contextPath}/event/list">이벤트리스트</a></span></p>
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
	</body>
</html>















