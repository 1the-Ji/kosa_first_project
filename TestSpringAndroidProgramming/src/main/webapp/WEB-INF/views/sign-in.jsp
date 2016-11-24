<%@ page contentType="text/html;charset=UTF-8"%>
﻿<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>로그인</title>

	    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
    <style>
    .custab{
    border: 1px solid #ccc;
    padding: 5px;
    margin: 5% 0;
    box-shadow: 3px 3px 2px #ccc;
    transition: 0.5s;
    }
.custab:hover{
    box-shadow: 3px 3px 0px transparent;
    transition: 0.5s;
    }
    
    </style>
</head>

<body >
<div class="container">
  <div class="row col-md-6 col-md-offset-2 custyle">
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

</body>

</html>