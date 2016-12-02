$(function() {	
	
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
		
		console.info("메뉴입력후등록클릭");

		var mgroup = $("#menuRegModal #mgroup").val();
		var mname = $("#menuRegModal #mname").val();
		var hot_ice = $("#menuRegModal input:radio[name=hot_ice]:checked").val();
		//var rel = parseInt($('.doAction:checked').attr('rel'));
		var mprice = $("#menuRegModal #mprice").val();
		var mcontents = $("#menuRegModal #mcontents").val();
		var photo = $("#menuRegModal #photo")[0];
		
		console.log(mgroup);
		console.log(mname);
		console.log(hot_ice);
		console.log(mprice);
		console.log(mcontents);
		console.log(photo.files[0]);
		
		var data = new FormData();
		data.append("mgroup", mgroup);
		data.append("mname", mname);
		data.append("hot_ice", hot_ice);
		data.append("mprice", mprice);
		data.append("mcontents", mcontents);
		
		console.log(mgroup);
		console.log(mname);
		console.log(hot_ice);
		console.log(mprice);
		console.log(mcontents);
		
		if(photo.files.length != 0) {
			data.append("photo", photo.files[0]);
		}
		
		console.log(photo.files[0]);
		
		$.ajax({
			url: "menu/register",
			method: "post",
			data: data,
			cache: false,
			processData:false,
			contentType: false,
			success: function(data){
				if(data.result == "success"){
					console.log("메뉴등록 성공");
					$("#menuRegModal").modal("hide");
					showPageMenuList(1, mgroup);
				} else {
					console.log("메뉴등록 실패");
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
		data: {"pageNo": pageNo, "keyword": mgroup},
		success: function(data){
			console.log("menuListJS success 처리중 중간");
			$("#menuListTd").empty();
			$("#menuModal .modal-footer").empty();
			for(var i=0; i<data.list.length; i++){
				var menu = data.list[i];
				console.log(menu);
				$("#menuListTd").append(
					//<div style="width:150px;height:150px;display:inline-block; margin:10px;"' + menu.mgroup + '>' +
	        		'<div style="width:150px; height:150px; display:inline-block; margin:10px;">' +
	        			'<a href="javascript:showMenuInfo(' + menu.mid + ')"><img id="menuImg" width="150px" height="150px" src="menu/showPhoto?msavedfile=' + menu.msavedfile + '" /></a>' + 
	        			'<div align="center">' +
	        			menu.mname + ' ' + menu.hot_ice + 
	        			'<br/>' +
	        			menu.mprice + 'won' +
	        			'</div>' +
	        		'</div>'
				);
			}
						
			var mgroup = data.mgroup;
			var pageNo = data.pageNo;
			var rowsPerPage = data.rowsPerPage;
			var pagesPerGroup = data.pagesPerGroup;
			var totalBoardNo = data.totalBoardNo;
			var totalPageNo = data.totalPageNo;
			var totalGroupNo = data.totalGroupNo;
			var groupNo = data.groupNo;
			var startPageNo = data.startPageNo;
			var endPageNo = data.endPageNo;
			var keyword = data.keyword;
	        
	        $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(1, \'' + keyword + '\')">처음</a>');
        	 
	         if(groupNo>1) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + (startPageNo-1) + ', \'' + keyword + '\')">이전</a>');
	         }

	         for(var i=startPageNo; i<=endPageNo; i++) {
	            if(pageNo == i) {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-danger" href="javascript:showPageMenuList(' + i + ', \'' + keyword + '\')">' + i + '</a>');
	            } else {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + i + ', \'' + keyword + '\')">' + i + '</a>');
	            }
	         }

	         if(groupNo<totalGroupNo) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + (startPageNo+1) + ', \'' + keyword + '\')">다음</a>');
	         }

	         $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageMenuList(' + totalPageNo + ', \'' + keyword + '\')">맨끝</a>');
	         
		},
		error:function(request,status,error){
	           alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	});
}

function showMenuInfo(mid, aa){
	$.ajax({
		url: "menu/info",
		data: {"mid": mid},
		success: function(data){
			$("#menuInfoModal .panel-body").empty();
			$("#menuModal .modal-footer").empty();
			$("#menuInfoModal .panel-body").append(
					'<div class="thumbnail">' +
						'<a href="javascript:showMenuInfo(' + menu.mid + ')><img style="width:300; height:400px" src="menu/showPhoto?msavedfile=' + menu.msavedfile + '"/></a>' +
					'</div>' +
					'<div class="icerik-bilgi">' +
   						'<h2>' + menu.mname + menu.hot_ice + '</h2>' +
   						'<p></p>' +
   						'<div>' +
   							'가격:' + menu.mprice +
   						'</div>' +
   						'<div>'+
   							menu.mcontents +
   						'</div>' +
   					'</div>'	
			);
			
			$("#menuModal .modal-footer").append(
					'<div>' +
						'<button type="button" class="btn btn-primary">' +
							'수정' +
						'</button>' +
					'</div>' +
					'<div>' +
						'<button type="button" class="btn btn-info">' +
							'삭제' +
						'</button>' +
					'</div>'
			);
			$("#menuModal").css("opacity", "0.5");
			$("#menuInfoModal").modal({
				backdrop: "static",
				show: true
			});
		}
	});
	
	$("#menuInfoModal").on('hidden.bs.modal',function(){
		$("#menuModal").css("opacity","1");
	});

}