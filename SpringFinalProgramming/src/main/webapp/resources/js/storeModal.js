$(function() {
	
	$("#btnContents").on("click", function() {
		$("#storeModal").css("opacity","0.5");  
		$("#storeModal").modal("hide");
	});		
	
	
	$("#btnStore").on("click", function() {
		$("#storeModal").modal("show");
		$("#storeModal").css("opacity","1");  	
	});		 
	
	
	
});