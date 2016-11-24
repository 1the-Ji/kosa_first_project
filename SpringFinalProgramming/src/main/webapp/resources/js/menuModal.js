$(function() {
	$("#btnMenuRegForm").on("click", function() {
		$("#menuModal").css("opacity", "0.5");
		$("#menuRegModal").modal({
			backdrop:"static",
			show:true			
		});
	});
	
	$('#menuRegModal').on('hidden.bs.modal', function () {
		$("#menuModal").css("opacity", "1");
	})
});