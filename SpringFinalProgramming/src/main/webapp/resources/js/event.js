$(function() {
	$("#btnRegEvent").on("click",function() {
		$("#eventModal").css("opacity","0.5");
		$("#eventRegister").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#eventRegister").on('hidden.bs.modal',function(){
		$("#eventModal").css("opacity","1");
	})
});


