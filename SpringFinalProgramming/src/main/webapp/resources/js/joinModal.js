$(function() {
	$("#btnJoin").on("click", function() {
		$("#joinModal").modal("show");
	});
	
	$("#selectSemail").on("change", function() {
		$("#inputSemail2").val($("#selectSemail").val());
	});
	
	$("#selectSname").on("change", function() {
		$("#inputSname").val($("#selectSname").val());
	});
});


