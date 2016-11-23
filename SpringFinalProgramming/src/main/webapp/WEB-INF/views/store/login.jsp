<%@ page contentType="text/html;charset=UTF-8"%>
﻿<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	    <title>로그인</title>
	    <!-- CSS -->
		    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
		    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">
		    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
	    	<link href="${pageContext.servletContext.contextPath}/resources/css/waves.css" rel="stylesheet" >
	    	<link href="${pageContext.servletContext.contextPath}/resources/css/animate.css" rel="stylesheet"/>
		    <link href="${pageContext.servletContext.contextPath}/resources/css/style_1.css" rel="stylesheet"/> 
	    <!-- CSS END -->
	    
		<!-- SCRIPT -->
		    <!-- Jquery Core Js -->
		    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
		    <!-- Waves Effect Plugin Js -->
		    <script src="${pageContext.servletContext.contextPath}/resources/js/waves.js"></script>
		    <!-- Custom Js -->
		    <script src="${pageContext.servletContext.contextPath}/resources/js/admin.js"></script>
	    <!-- SCRIPT END -->
	</head>
	
	<body class="login-page">
	    <div class="login-box">
	        <div class="logo">
	            <a href="javascript:void(0);">Admin<b>BSB</b></a>
	            <small>Admin BootStrap Based - Material Design</small>
	        </div>
	        <div class="card">
	            <div class="body">
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
	        </div>
	    </div>  
	</body>
</html>
