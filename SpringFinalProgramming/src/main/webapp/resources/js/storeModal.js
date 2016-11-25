$(function(){
	$("#selectEmail").on("change", function() {
		$("#inputSemail2").val($("#selectEmail").val());
	});
});
