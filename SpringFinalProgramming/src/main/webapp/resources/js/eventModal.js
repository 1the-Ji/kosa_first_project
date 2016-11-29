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
	
	
	$("#regEvent").on("click",function() {
		console.log("regEvent");
		var etitle = $("#etitle").val();
		var estartperiod = $("#estartperiod").val();
		var elastperiod = $("#elastperiod").val();
		var econtent =$("econtent").val();
	
	});
});


