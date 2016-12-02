$(function() {
	$("#btnLogin").on("click", function() {
		$("#loginModal").modal("show");
	});
	
	$("#btnStore").on("click", function () {
		$("#storeModal").modal("show");
	});
	
	$("#btnMenu").on("click", function() {
		$("#menuModal").modal("show");
		showPageMenuList(1, "전체");
	});
	
	$("#btnEvent").on("click", function() {
		$("#eventModal").modal("show");
		eventList();
	});
	
	$("#btnOrder").on("click", function() {
		showPageList(1);
	}); 
});




