$(function() {
	$("#btnLogin").on("click", function() {
		$("#joinModal").modal("show");
	});
});


$(function(){
	$("#selectSemail").on("change", function() {
		$("#inputSemail2").val($("#selectSemail").val());
	});
});

$(function(){
	$("#selectSname").on("change", function() {
		$("#inputSname").val($("#selectSname").val());
	});
});
