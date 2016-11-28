$(function() {
	
	$("#btnLogin").on("click", function() {
		$("#loginModal").modal("show");
	});
	
	$("#btnStore").on("click", function () {
		$("#storeModal").modal("show");
	});
	
	$("#btnMenu").on("click", function menuList(data) {
		$("#menuModal").modal("show");
		$("#menuModal").val(data.photo);
		$("#menuModal").val(data.mname);
		$("#menuModal").val(data.hot_ice);
		$("#menuModal").val(data.mprice);
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
                   '<td class="detailList" data-label="주문번호"><a type="button" class="btn btn-primary" href="#">' + order.ogid.substring(0, 5) + '</a></td>' +
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
 
function eventList(){
	$.ajax({
		url:"event/eventList",
		data:{},
		success:function(data){
			$("#eventTbody").empty();
			for(var i=0; i<data.eventList.length; i++) {
				var event = data.eventList[i];
				$("#eventTbody").append(
			         '<tr>'+
		             '<td>'+ event.eid +'</td>' +
		             '<td><a href="info?eid=${event.eid}">'+ event.etitle +'</td>'+
		             '<td>'+ event.estartperiod + ' ~ ' + event.elastperiod + '</td>'+
		             '<td>'+ event.econtents + '~' + '</td>'+
		             '<td class="text-center"><a class="btn btn-info btn-xs" href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>'+
			         '</tr>'
            	);
			}
			$("#eventModal").modal("show");
		}
	});
}
