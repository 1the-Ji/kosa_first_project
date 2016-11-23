<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<title>  </title>
		<!-- Bootstrap  -->
			   
		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">	
		<link href="${pageContext.servletContext.contextPath}/resources/css/.css" rel="stylesheet"/>
		<link href="${pageContext.servletContext.contextPath}/resources/css/style_1.css" rel="stylesheet"/>			
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/menustyle.css" />		
		
		
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css"> 
    	
    	
    	<!-- Template CSS Files  -->
    	<link href="${pageContext.servletContext.contextPath}/resources/css/waves.css" rel="stylesheet" >
    	<link href="${pageContext.servletContext.contextPath}/resources/css/animate.css" rel="stylesheet"/>
    	
    	<!-- Google Web Fonts -->
		<link href="http://fonts.googleapis.com/css?family=Alegreya:400italic,700italic,900italic,400,700,900" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    	
    	

		<link href="${pageContext.servletContext.contextPath}/resources/css/menulist.css" rel="stylesheet"/>  		
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/waves.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/admin.js"></script>
				
		<link href="${pageContext.servletContext.contextPath}/resources/css/menulist.css" rel="stylesheet"/>				
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/menulist.js"></script>
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
					<img src="${pageContext.servletContext.contextPath}/resources/photo/background.jpg"/>
				</div>
				
			</section>
		</div>
		
		<!-- ######### MenuList Modal ########## -->
		<div id="loginModal" class="modal fade" role="dialog" >
		  <div class="modal-dialog" role="document"  style="left: 100px; position: relative;">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title"><b>MenuList</b></h4>
		      </div>
		      <div class="modal-body">
		      	
		      	<!-- Services Section Starts -->
				<section id="services" class="services">
				<!-- Container Starts -->
					<div class="container">
					<!-- Main Heading Starts -->
						<div class="text-center">
							<h2 class="wow fadeInDown">Services</h2>
							<p class="wow fadeInUp">
								It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using english.  
							</p>
						</div>
					</div>
				</section>
				<!-- Services Section Ends -->
				
				<!-- Gallery Section Starts -->
				<section id="gallery" class="gallery">
				<!-- Gallery Head Block Starts -->
					<div class="gallery-head">
						<div class="container">
							<h2 class="wow bounceInLeft">Coffee Gallery</h2>
						<!-- Gallery Filter Starts -->
							<ul id="gallery-filter" class="list-inline wow bounceInRight">
								<li>
									<a href="#" class="btn active" data-group="all">
										All
									</a>
								</li>
								<li>
									<a href="#" class="btn" data-group="커피">
										Coffee
									</a>
								</li>
								<li>
									<a href="#" class="btn" data-group="차">
										Tea
									</a>
								</li>
								<li>
									<a href="#" class="btn" data-group="디저트">
										Dessert
									</a>
								</li>
								<li>
									<a href="#" class="btn" data-group="기타">
										Etc
									</a>
								</li>
							</ul>
						<!-- Gallery Filter Ends -->
						</div>
					</div>
				<!-- Gallery Head Block Ends -->
				
				<!-- Gallery Container Starts -->
					<div class="container">
						<ul id="gallery-grid" class="row">
						<!-- Gallery Item #count Starts -->
						<c:forEach var="menu" items="${list}">
							<li class="col-md-3 col-sm-4 col-xs-6 gallery-grid" data-groups='["all", "${menu.mgroup}"]'>
								<div class="hover-content wow flipInX">
									<a href="info?mid=${menu.mid}">
										<img src="${pageContext.servletContext.contextPath}/menu/showPhoto?msavedfile=${menu.msavedfile}" alt="Gallery Image${menu.mid}" class="img-responsive">
										<div class="head-part">
											<i class="fa fa-search-plus"></i>
										</div>
										<div class="foot-part hidden-xs">
											<h5>${menu.mname} ${menu.hot_ice}</h5><br/>
											<h5>${menu.mprice} won</h5><br/>
										</div>
									</a>
								</div>
							</li>
						</c:forEach>
						<!-- Gallery Item #1 Ends -->
						</ul>
					</div>
					
					<div>
						<c:if test="${login!=null }">
		   				<a href="${pageContext.servletContext.contextPath}/menu/register">[메뉴 등록]</a>
		   				</c:if>
		   				<a href="${pageContext.servletContext.contextPath}/index">[메인ㄱㄱ]</a>
					</div>
					
					
				<!-- Gallery Container Ends -->
				</section>
			<!-- Gallery Section Ends -->
		      	
		      	
		      	
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
		
	</body>
</html>