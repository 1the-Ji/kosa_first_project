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
		$("#eventModal").modal("show");
		eventList();
	});
	
	$("#btnOrder").on("click", function() {
		showPageList(1);
	}); 
});




