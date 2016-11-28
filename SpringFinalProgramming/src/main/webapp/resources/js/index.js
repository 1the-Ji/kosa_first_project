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
		$("#eventModal").modal("show");
	});
	
	$("#btnOrder").on("click", function () {
		/*$.ajax({
			url: "order/list",
			data: {"pageNo":null},
			method: "get",
			success: function(data) {
				if(data.list != null){
					alert("리스트 성공");
				}else{
					alert("리스트 실패");
				}
				
			}
		});*/
		$("#orderModal").modal("show");
	});
});


