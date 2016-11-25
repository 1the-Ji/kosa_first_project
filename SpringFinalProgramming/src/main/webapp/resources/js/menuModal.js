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
	
	$("menuInfoModal").on("hidden.bs.modal", function(){
		$("#menuModal").css("opacity", "1");
	})
});