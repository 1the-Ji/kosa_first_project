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

}

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
	         if(detail==null){
	        	 var resultprice = 0;
		         var oghowpay = "카드 결제";
	         }else{
	        	 var resultprice = data.resultprice;
		         var oghowpay = detail.oghowpay; 
	         }
	         
	         
	         $("#detailListModal .modal-footer").append('총 가격 : <p class="btn btn-primary">'+resultprice+'</p>&nbsp;&nbsp;');
	         $("#detailListModal .modal-footer").append('결제방식 : <p class="btn btn-primary">'+oghowpay+'</p>&nbsp;&nbsp;');
	         $("#detailListModal .modal-footer").append('주문수정 : <input id="modifyOrderForm" onclick="modifyOrderForm(\''+ogid+'\')" class="btn btn-info" type="submit" value="수정하기"/>');
	         
	         
	         $("#detailListModal").modal({
	 			backdrop:"static",
				show:true
			});
	      }
	   });
	$("#detailListModal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function termList(pageNo) {
	var term1 = $("#datepicker1").val();
	var term2 = $("#datepicker2").val();
	
	$.ajax({
      url: "order/termList",
      data: {"term1":term1,"term2":term2,"pageNo":pageNo},
      success: function(data) {
    	 console.log("성공");
         $("#termTbody").empty();
         $("#termListModal .modal-footer").empty();
         for(var i=0; i<data.termList.length; i++) {
            var term = data.termList[i];
            $("#termTbody").append(
               '<tr>' +
                   '<td class="detailList" data-label="주문번호"><a type="button" class="btn btn-primary" href="javascript:detailOrderList(\'' + term.ogid + '\')">' + term.ogid.substring(4, 7) + term.ogid.substring(11, 14) +'</a></td>' +
                   '<td data-label="아이디">' + term.user_id + '</td>' +
                   '<td data-label="주문시간">' + term.ogtime + '</td>' +
                   '<td data-label="총 가격">' + term.ogtotalprice + '</td>' +
                   '<td data-label="결제 방식">' + term.oghowpay + '</td>' +
              '</tr>'
               );
            
         }
         
         var termPageNo = data.pageNo;
         var termRowsPerPage = data.rowsPerPage;
         var termPagesPerGroup = data.pagesPerGroup;
         var termTotalBoardNo = data.totalBoardNo;
         var termTotalPageNo = data.totalPageNo;
         var termTotalGroupNo = data.totalGroupNo;
         var termGroupNo = data.groupNo;
         var termStartPageNo = data.startPageNo;
         var termEndPageNo = data.endPageNo;
         
         $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(1)">처음</a>');
         
         if(termGroupNo>1) {
            $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + (termStartPageNo-1) + ')">이전</a>');
         }
         
         for(var i=termStartPageNo; i<=termEndPageNo; i++) {
            if(termPageNo == i) {
               $("#termListModal .modal-footer").append('<a type="button" class="btn btn-warning" href="javascript:termList(' + i + ')">' + i + '</a>');
            } else {
               $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + i + ')">' + i + '</a>');
            }
         }
         
         if(termGroupNo<termTotalGroupNo) {
            $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + (termStartPageNo+1) + ')">다음</a>');
         }
         
         
         $("#termListModal .modal-footer").append('<a type="button" class="btn btn-primary" href="javascript:termList(' + termTotalPageNo + ')">맨끝</a>');
         
         $("#orderModal").css("opacity","0.5");
         $("#termListModal").modal({
			backdrop:"static",
			show:true
		});
         $("#termListModal").on('hidden.bs.modal',function(){
     		$("#orderModal").css("opacity","1");
     	});
         
      }
   });

}

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
	         		  '<td style="width:180px; font-size:30px;" data-label="메뉴번호">' + menu.mid + '</td>' + 
	             	  '<td style="width:175px" data-label="메뉴사진"><img src="menu/showPhoto?msavedfile=' + menu.msavedfile + '" width="50px" height="50px"/></td>' + 
	             	  '<td style="width:165px" data-label="메뉴이름"><a type="button" class="btn btn-primary" href="javascript:newOrderSideForm(\'' + menu.mid + '\')">' + menu.mname + '</a></td>' +
	             	'</tr>'
             	);
			}
		}
	});
}

function newOrderSideForm(mid){
	console.log(mid);
	$("#orderForm1Modal").css("opacity","0.5");
	
	$.ajax({
		url: "order/sideList",
		data: {"mid": mid},
		type: "get",
		success: function(data) {
			if(data != null){
				console.log("메뉴 존재");
			}else{
				console.log("메뉴 에러");
			}
			
		}
	});
	
	$("#orderForm2Modal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm2Modal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	});
}

function newOrderSave(){
	var ordercount = $("#orderQuantity").val();
	var hot_ice = $("#orderHotice").val();
	var orderSize = $("#orderSize").val();
	var orderSyrup = $("#orderSyrup").val();
	var orderShot = $("#orderShot").val();
	
	$.ajax({
		url: "order/sideList",
		data: {"ordercount": ordercount,"hot_ice":hot_ice,"orderSize":orderSize,"orderSyrup":orderSyrup,"orderShot":orderShot},
		type: "post",
		success: function(data) {
			if(data != null){
				console.log("주문 저장 성공");
			}else{
				console.log("주문 저장 실패");
			}
			
		}
	});
	$("#orderForm2Modal").modal('hide');
	$("#orderForm1Modal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function resultOrder(){
	
	$.ajax({
		url: "order/orderpay",
		success: function(data) {
			if(data != null){
				console.log("총 주문 완료");
			}else{
				console.log("총 주문 실패");
			}
			
		}
	});
	
	$("#orderForm1Modal").modal('hide');
	
	$("#orderModal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function cancelOrder(){
	
	$.ajax({
		url: "order/ordercancel",
		success: function(data) {
			if(data == null){
				console.log("주문 취소 완료");
			}else{
				console.log("주문 취소 실패");
			}
			
		}
	});
	
	$("#orderForm1Modal").modal('hide');
	
	$("#orderModal").modal({
		backdrop:"static",
		show:true
	});
	
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	});
}

function modifyOrderForm(ogid){
	
	$("#detailListModal").css("opacity","0.5");
		
	$.ajax({
	      url: "order/detailList",
	      data: {"ogid": ogid},
	      success: function(data) {
	    	  $("#orderModifyTbody").empty();
	          $("#orderModifyTbody .modal-footer").empty();
	         for(var i=0; i<data.detailList.length; i++) {
	            var detail = data.detailList[i];
	            console.log(detail);
	            $("#orderModifyTbody").append(
	            	   '<tr>' +
	                   		'<th width="100px;" data-label="제품명">' + detail.mname + '</th>' +
	                   		'<th width="100px;" data-label="수량"><input id="modifyQuantity" type="number" data-style="btn-primary" style="margin-left: 20px;" name="quantity" min="1" max="5" value="1" style="display: inline;"></th>' +
	                   		'<th width="100px;" data-label="orderHotice"><select id="modifyHotice" style="margin-left: 20px;" data-style="btn-primary" style="display: inline;"><option>HOT</option><option>ICE</option></select></td>' +
	                   		'<th width="100px;" data-label="orderSize"><select id="modifySize" style="margin-left: 20px;" data-style="btn-info" style="display: inline;"><option>Midium</option><option>Large</option><option>Small</option></select></td>' +
	                   		'<th width="100px;" data-label="orderSyrup"><select id="modifySyrup" style="margin-left: 20px;" data-style="btn-success" style="display: inline;"><option>설탕시럽</option><option>딸기시럽</option><option>초코시럽</option></select></td>' +
	                   		'<th width="100px;" data-label="orderShot"><select id="modifyShot" style="margin-left: 20px;" data-style="btn-success" style="display: inline;"><option>샷추가1</option><option>샷추가2</option><option>샷추가3</option></select></td>' +    
	                   '</tr>'
	               );
	            
	         }
	         if(detail==null){
	        	 var resultprice = 0;
		         var oghowpay = "카드 결제";
	         }else{
	        	 var resultprice = data.resultprice;
		         var oghowpay = detail.oghowpay; 
	         }
	         
	          
	         $("#orderModifyModal .modal-footer").append('총 가격 : <p class="btn btn-primary">'+resultprice+'</p>&nbsp;&nbsp;');
	         $("#orderModifyModal .modal-footer").append('결제방식 : <p class="btn btn-primary">'+oghowpay+'</p>&nbsp;&nbsp;');
	         $("#orderModifyModal .modal-footer").append('수정하기 : <input id="modifyOrder" onclick="modifyOrder()" class="btn btn-info" type="submit" value="적용"/>&nbsp;&nbsp;');
	         
	         $("#orderModifyModal").modal({
	     		backdrop:"static",
	     		show:true
	     	});
	      }
	   });
	$("#orderModifyModal").on('hidden.bs.modal',function(){
		$("#detailListModal").css("opacity","1");
		$("#detailListModal").modal("hide");
	});
	
}

function orderModify(ogid){
	$("#detailListModal").css("opacity","0.5");

	$("#orderModifyModal").on('hidden.bs.modal',function(){
		$("#detailListModal").css("opacity","1");
	});
}

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





