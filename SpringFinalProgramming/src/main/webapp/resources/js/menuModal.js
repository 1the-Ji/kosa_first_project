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
	
	
	$("#btnMenuReg").on("click", function(){
		var mid = $("mid").val();
		var mgroup = $("#mgroup").val();
		var mname = $("#mname").val();
		var hot_ice = $("#hot_ice").val();
		var mprice = $("#mprice").val();
		var photo = $("photo").val();
		var sid = $("#sid").val();
		
		$.ajax({
			url: "../menu/register",
			data:{},
			method: "post",
			success: function(data){
				if(data.result == "success"){
					$("#menuRegModal").modal("hide");
					location.reload();
				} else if(data.result == "wrongData"){
					
				}
			}
		})
	});
	
	
	
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
	
	$("#menuInfoModal").on("hidden.bs.modal", function(){
		$("#menuModal").css("opacity", "1");
	})
	
});