<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css" rel="stylesheet"  >
		<script src="${pageContext.servletContext.contextPath}/resources/js/event.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js" type="text/javascript"></script>
	</head>

	<body>
		<a id="btnRegEvent" href=#><button>test</button></a>
		 <div id="eventRegister" class="modal fade" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Modal title</h4>
		      </div>
		      <div class="modal-body">
				 <div  class="row" >
				    <div class="col-md-8">
				     <form class="form-horizontal" method="post" name="signup" id="signup" enctype="multipart/form-data" >        
				        <div class="form-group">
				          <label class="control-label col-sm-3">이벤트 제목<span class="text-danger">*</span></label>
				          <div class="col-md-8 col-sm-9">
				            <input type="text" class="form-control" name="mem_name" id="mem_name" placeholder="이벤트 제목 입력" value="">
				          </div>
				        </div>
				        
				        <div class="form-group">
				          <label class="control-label col-sm-3">기간 <span class="text-danger">*</span></label>
				          <div class="col-md-5 col-sm-8">
				            <input id="date" type="date" class="form-control" name="contactnum2" id="contactnum2" placeholder="내용 입력" value="">~
				            <input id="date" type="date" class="form-control" name="contactnum2" id="contactnum2" placeholder="내용 입력" value="">
				          </div>
				        </div>
				        <div class="form-group">
				          <label class="control-label col-sm-3">내용</label>
				          <div class="col-md-5 col-sm-8">
				            <input type="text" class="form-control" name="contactnum2" id="contactnum2" placeholder="내용 입력" value="">
				          </div>
				        </div>
				        <div class="form-group">
				          <label class="control-label col-sm-3">사진</label>
				          <div class="col-md-5 col-sm-8">
				            <div class="input-group"> <span class="input-group-addon" id="file_upload"><i class="glyphicon glyphicon-upload"></i></span>
				              <input type="file" name="file_nm" id="file_nm" class="form-control upload" placeholder="" aria-describedby="file_upload">
				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-xs-offset-3 col-xs-10">
				            <input name="Submit" type="submit" value="Sign Up" class="btn btn-primary">
				          </div>
				        </div>
				      </form>
				    </div>
				</div>
			 </div>
			      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	</body>
</html>