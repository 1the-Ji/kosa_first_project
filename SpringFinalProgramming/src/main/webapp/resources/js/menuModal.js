$(function() {
	/*
	$("#btnMenuGroup").on("click", function(){
		showPageMenuList(1, mgroup);
	});
	*/
	
	
	$("#btnMenuRegForm").on("click", function() {
		$("#menuModal").css("opacity", "0.5");
		$("#menuRegModal").modal({
			backdrop:"static",
			show:true			
		});
	});
	
	$("#menuRegModal").on("hidden.bs.modal", function () {
		$("#menuModal").css("opacity", "1");
	})
	
	
	$("#btnMenuReg").on("click", function(){
		var mid = $("#mid").val();
		var mgroup = $("#mgroup").val();
		var mname = $("#mname").val();
		var hot_ice = $("#hot_ice").val();
		var mprice = $("#mprice").val();
		var photo = $("photo").val();
		var sid = $("#sid").val();
		
		$.ajax({
			url: "menu/register",
			data: data,
			method: "post",
			success: function(data){
				if(data.result == "success"){
					alert("추가 성공");
					$("#menuRegModal").modal("hide");
					location.reload();
				} else if(data.result == "wrongData"){
					alert("입력 데이터가 올바르지 않음");
				}
			}
		})
	});
	
	
	
	$("#btnModModal").on("click", function() {
		$("#menuModal").css("opacity", "0.5");
		$("#menuModModal").modal({
			backdrop:"static",
			show:true
		});
	});
	
	$("#menuModModal").on("hidden.bs.modal", function(){
		$("#menuModal").css("opacity", "1");
	})
	
	
	$(".menuImg").on("click", function(){
		$("#menuModal").css("opacity", "0.5");
		$("#menuInfoModal").modal({
			backdrop:"static",
			show:true
		});
	});
	
	$("#menuInfoModal").on("hidden.bs.modal", function(){
		$("#menuModal").css("opacity", "1");
	})
	
});
 


function showPageMenuList(pageNo, mgroup) {
	$("#menuListTd").empty();
	$.ajax({
		url: "menu/menuList",
		data: {"pageNo": pageNo, "mgroup": mgroup},
		success: function(data){
			console.log(data);
			$("#menuListTd").empty();
			$("#menuModal .modal-footer").empty();
			for(var i=0; i<data.list.length; i++){
				var menu = data.list[i];
				console.log(menu);
				$("#menuListTd").append(
	        		'<div style="width:150px;height:150px;display:inline-block; margin:10px;"' + menu.mgroup + '>' +
	        			'<a href="javascript:showMenuInfo(' + menu.mid + ')"><img id="menuImg" width="150px" height="150px" src="menu/showPhoto?msavedfile=' + menu.msavedfile + '" /></a>' + 
	        			'<div align="center">' +
	        			menu.mname + ' ' + menu.hot_ice + 
	        			'<br/>' +
	        			menu.mprice + 'won' +
	        			'</div>' +
	        		'</div>'
				);
			}
			
			var pageNo = data.pageNo;
	        var rowsPerPage = data.rowsPerPage;
	        var pagesPerGroup = data.pagesPerGroup;
	        var totalBoardNo = data.totalBoardNo;
	        var totalPageNo = data.totalPageNo;
	        var totalGroupNo = data.totalGroupNo;
	        var groupNo = data.groupNo;
	        var startPageNo = data.startPageNo;
	        var endPageNo = data.endPageNo;
	        
	        $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(1, ' + menu.mgroup + ')">처음</a>');
        	 
	         if(groupNo>1) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + (startPageNo-1) + ', ' + menu.mgroup + ')">이전</a>');
	         }

	         for(var i=startPageNo; i<=endPageNo; i++) {
	            if(pageNo == i) {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-danger" href="javascript:showPageMenuList(' + i + ', ' + menu.mgroup + ')">' + i + '</a>');
	            } else {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + i + ', ' + menu.mgroup + ')">' + i + '</a>');
	            }
	         }

	         if(groupNo<totalGroupNo) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + (startPageNo+1) + ', ' + menu.mgroup + ')">다음</a>');
	         }

	         $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + totalPageNo + ', ' + menu.mgroup + ')">맨끝</a>');
	         
		},
		error:function(request,status,error){
	           alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	           }
	});
}