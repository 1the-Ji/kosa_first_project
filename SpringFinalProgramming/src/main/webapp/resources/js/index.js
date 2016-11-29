$(function() {
	$("#btnLogin").on("click", function() {
		$("#loginModal").modal("show");
	});
	
	$("#btnStore").on("click", function () {
		$("#storeModal").modal("show");
	});
	
	$("#btnMenu").on("click", function menuList(data) {
		showPageMenuList(1);
	});
	
	$("#btnEvent").on("click", function() {
		eventList();
	});
	
	$("#btnOrder").on("click", function() {
		showPageList(1);
	});
});


function showPageList(pageNo) {
	$.ajax({
      url: "order/list",
      data: {"pageNo":pageNo},
      success: function(data) {
         $("#orderTbody").empty();
         $("#orderModal .modal-footer").empty();
         for(var i=0; i<data.list.length; i++) {
            var order = data.list[i];
            $("#orderTbody").append(
               '<tr>' +
                   '<td class="detailList" data-label="주문번호"><a type="button" class="btn btn-primary" href="javascript:detailOrderList(\'' + order.ogid + '\')">' + order.ogid.substring(4, 7) + order.ogid.substring(11, 14) +'</a></td>' +
                   '<td data-label="아이디">' + order.user_id + '</td>' +
                   '<td data-label="주문시간">' + order.ogtime + '</td>' +
                   '<td data-label="총 가격">' + order.ogtotalprice + '</td>' +
                   '<td data-label="결제 방식">' + order.oghowpay + '</td>' +
                   '</tr>'
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
         
         $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(1)">처음</a>');
         
         if(groupNo>1) {
            $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + (startPageNo-1) + ')">이전</a>');
         }
         
         for(var i=startPageNo; i<=endPageNo; i++) {
            if(pageNo == i) {
               $("#orderModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageList(' + i + ')">' + i + '</a>');
            } else {
               $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + i + ')">' + i + '</a>');
            }
         }
         
         if(groupNo<totalGroupNo) {
            $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + (startPageNo+1) + ')">다음</a>');
         }
         
         
         $("#orderModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:showPageList(' + totalPageNo + ')">맨끝</a>');
         
         
         $("#orderModal").modal("show");
      }
   });

};




function showMenuList(pageNo, mgroup){
	$("#menuListBody").empty();
	$.ajax({
		url: "menu/menuList",
		data: {"pageNo": pageNo, "mgroup": mgroup},
		success: function(data){
			$("#menuListBody").empty();
			$("#menuModal .modal-footer").empty();
			for(var i=0; i<data.list.length; i++){
				var menu = data.list[i];
				$("menuTbody").append(
					'<tr>' +
						'<td style="text-align: center;">' +
			        		'<div style="width:150px;height:150px;display:inline-block; margin:10px;" ${menu.mgroup}">' +
			        			'<a href="javascript:showMenuInfo(' + menu.mid + ')"><img width="150px" height="150px" src="showPhoto?msavedfile=' + menu.msavedfile + '" /></a>' + 
			        			'<br/>' +
			        			menu.mname + ' ' + menu.hot_ice + 
								'<br/>' +
								menu.mprice + 'won' +	
			        		'</div>' +
						'</td>' +
					'</tr>' 
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
	        
	        $("##menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageList(1)">처음</a>');

	         if(groupNo>1) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageList(' + (startPageNo-1) + ')">이전</a>');
	         }

	         for(var i=startPageNo; i<=endPageNo; i++) {
	            if(pageNo == i) {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-danger" href="javascript:showPageList(' + i + ')">' + i + '</a>');
	            } else {
	               $("#menuModal .modal-footer").append('<a type="button" class="btn btn-danger" href="javascript:showPageList(' + i + ')">' + i + '</a>');
	            }
	         }

	         if(groupNo<totalGroupNo) {
	            $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageList(' + (startPageNo+1) + ')">다음</a>');
	         }


	         $("#menuModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:showPageList(' + totalPageNo + ')">맨끝</a>');


	         $("#menuModal").modal("show");
		}
	});
}



