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

function detailOrderList(ogid){
	console.log("여기 옴");
	$("#orderModal").css("opacity","0.5");
	$.ajax({
	      url: "order/detailList",
	      data: {"ogid": ogid},
	      success: function(data) {
	    	  $("#detailTbody").empty();
	          $("#detailListModal .modal-footer").empty();
	         for(var i=0; i<data.detailList.length; i++) {
	            var detail = data.detailList[i];
	            $("#detailTbody").append(
	            	   '<tr>' +
	                   	'<td data-label="제품명">' + detail.mname + '</td>' +
	                   	'<td data-label="수량">' + detail.sameItemCount + '</td>' +
	                   	'<td data-label="사이드">' + detail.xname + '</td>' +
	                   	'<td data-label="가격">' + detail.sameItemPrice + '</td>' +
	                   '</tr>'
	               );
	            
	         }
	         
	         var resultprice = data.resultprice;
	         var oghowpay = data.oghowpay;
	         
	         
	         $("#detailListModal .modal-footer").append('총 가격 : <p class="btn btn-primary">'+resultprice+'</p>');
	         $("#detailListModal .modal-footer").append('총 가격 : <p class="btn btn-primary">'+oghowpay+'</p>');
	         
	         
	         $("#detailListModal").modal({
	 			backdrop:"static",
				show:true
			});
	      }
	   });
	$("#detailListModal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
};

$(function() {
	$("#btnNewOrder").on("click", function() {
		orderMenuList("전체");
		$("#orderModal").css("opacity","0.5");
		$("#orderForm1Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
});

$(function() {
	$(".orderForm2").on("click", function() {
		$("#orderModal").css("opacity","0.5");
		$("#orderForm1Modal").css("opacity","0.7");
		$("#orderForm2Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#orderForm2Modal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	});
});


function orderMenuList(mgroup) {
	$("#menuTbody").empty();
	$.ajax({
		url: "order/menuList",
		data: {"mgroup": mgroup},
		success: function(data) {
			for(var i=0; i<data.length; i++) {
				var menu = data[i];
				$("#menuTbody").append(
	         		'<tr>' + 
	             	'<td style="width:120px" data-label="메뉴번호">' + menu.mid + '</td>' + 
	             	'<td style="width:120px" data-label="메뉴사진"><img src="menu/showPhoto?msavedfile=' + menu.msavedfile + '" width="50px" height="50px"/></td>' + 
	             	'<td class="orderForm2" data-label="메뉴이름"><a  type="button" class="btn btn-primary" href="#">' + menu.mname + '</a></td>' +
	             	'<td class="orderForm2" data-label="메뉴이름"><input  type="number" value="0"/></td>' +
	             	'</tr>'
             	);
			}
		}
	});
};

var activeEl = 2;
$(function() {
    var items = $('.btn-nav');
    $( items[activeEl] ).addClass('active');
    $( ".btn-nav" ).click(function() {
        $( items[activeEl] ).removeClass('active');
        $( this ).addClass('active');
        activeEl = $( ".btn-nav" ).index( this );
    });
});





