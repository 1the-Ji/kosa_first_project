<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
	        <!-- Left Sidebar -->
	        <aside id="leftsidebar" class="sidebar">
	            <!-- Menu -->
	            <div class="menu">
	                <ul class="list">
	                    <li class="header">MAIN NAVIGATION</li>
	                    <li>
	                        <a href="index">
	                        	<i class="material-icons">home</i>
	                            <span>Home</span>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0);" class="menu-toggle">
	                            <i class="material-icons">swap_calls</i>
	                            <span>매장</span>
	                        </a>
	                        <ul class="ml-menu">
	                            <li>
	                                <a target="iframe" href="${pageContext.servletContext.contextPath}/store/info">매장 정보 보기</a>
	                            </li>
	                            <li>
	                                <a target="iframe" href="${pageContext.servletContext.contextPath}/sphoto/write">사진 첨부하기</a>
	                            </li>
	                            <li>
	                                <a target="iframe" href="${pageContext.servletContext.contextPath}/store/logout"">로그아웃</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0);" class="menu-toggle">
	                            <i class="material-icons">swap_calls</i>
	                            <span>메뉴</span>
	                        </a>
	                        <ul class="ml-menu">
	                            <li>
	                                <a target="iframe" href="${pageContext.servletContext.contextPath}/menu/list">메뉴리스트</a>
	                            </li>
	                            <li>
	                                <a href="#">메뉴 옵션</a>
	                            </li>
	                        </ul>
	                    </li> 
	                    <li>
	                        <a href="javascript:void(0);" class="menu-toggle">
	                            <i class="material-icons">swap_calls</i>
	                            <span>이벤트</span>
	                        </a>
	                        <ul class="ml-menu">
	                            <li>
	                                <a target="iframe" href="${pageContext.servletContext.contextPath}/event/list">이벤트 리스트</a>
	                            </li>
	                            <li>
	                                <a href="#">이벤트 리스트2</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0);" class="menu-toggle">
	                            <i class="material-icons">swap_calls</i>
	                            <span>주문</span>
	                        </a>
	                        <ul class="ml-menu">
	                            <li>
	                                <a target="iframe" href="${pageContext.servletContext.contextPath}/order/list">주문 리스트</a>
	                            </li>
	                            <li>
	                                <a target="iframe" href="${pageContext.servletContext.contextPath}/order/orderItems">주문하기</a>
	                            </li>
	                        </ul>
	                    </li>   
	                </ul>
	            </div>
	        </aside>
	</body>
</html>