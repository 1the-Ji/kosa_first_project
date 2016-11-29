$(function() {
	$("#btnLogin").on("click", function() {
		$("#loginModal").modal("show");
	});
	
	$("#btnStore").on("click", function () {
		$("#storeModal").modal("show");
	});
	
	$("#btnMenu").on("click", function menuList(data) {
		$("#menuModal").modal("show");
		showPageMenuList(1, mgroup);
	});
	
	$("#btnEvent").on("click", function() {
		$("#eventModal").modal("show");
		eventList();
	});
	
	$("#btnOrder").on("click", function() {
		showPageList(1);
	}); 
});




