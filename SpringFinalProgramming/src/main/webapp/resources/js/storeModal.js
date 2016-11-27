$(function(){
	$("#selectEmail").on("change", function() {
		$("#inputSemail2").val($("#selectEmail").val());
	});
});

$(function(){
	$("#selectSname").on("change", function() {
		$("#inputSname").val($("#selectSname").val());
	});
});
