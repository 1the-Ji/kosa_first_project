$(function() {
	$(".detailList").on("click", function() {
		$("#orderModal").css("opacity","0.5");
		$("#detailListModal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#detailListModal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	})
});

$(function() {
	$("#orderForm1").on("click", function() {
		$("#orderModal").css("opacity","0.5");
		$("#orderForm1Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	})
});

$(function() {
	$(".orderForm2").on("click", function() {
		$("#orderModal").css("opacity","0.5");
		$("#orderForm1Modal").css("opacity","0.7");
		$("#orderForm2Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#orderForm2Modal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	})
});


/*$(function termList() {
	$("#termList").on("click", function() {
		$("#orderModal").css("opacity","0.5");
		$("#termListModal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#termListModal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	})
});

$(function mnameSearch() {
	$("#mnameSearch").on("click", function() {
		$("#orderForm1Modal").css("opacity","0.5");
		$("#mnameSearchModal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#mnameSearchModal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	})
});


$(function mgroupAll() {
	$("#mgroupAll").on("click", function() {
		$("#mgroupCoffModal").modal("hide");
		$("#mgroupTeaModal").modal("hide");
		$("#mgroupDigertModal").modal("hide");
		$("#orderForm1Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#orderForm1Modal").on('hidden.bs.modal',function(){
		$("#orderModal").css("opacity","1");
	})
});

$(function mgroupCoff() {
	$("#mgroupCoff").on("click", function() {
		$("#orderForm1Modal").css("opacity","0.5");
		$("#mgroupCoffModal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#mgroupCoffModal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	})
	
	$(".orderForm2").on("click", function() {
		$("#mgroupCoffModal").css("hide");
		$("#orderForm2Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#orderForm2Modal").on('hidden.bs.modal',function(){
		$("#mgroupCoffModal").css("opacity","1");
	})
});

$(function mgroupTea() {
	$("#mgroupTea").on("click", function() {
		$("#orderForm1Modal").css("opacity","0.5");
		$("#mgroupTeaModal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#mgroupTeaModal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	})
	
	$(".orderForm2").on("click", function() {
		console.log("orderForm2");
		$("#mgroupTeaModal").css("opacity","0.7");
		$("#orderForm2Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#orderForm2Modal").on('hidden.bs.modal',function(){
		$("#mgroupTeaModal").css("opacity","1");
	})
});

$(function mgroupDigert() {
	$("#mgroupDigert").on("click", function() {
		$("#orderForm1Modal").css("opacity","0.5");
		$("#mgroupDigertModal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#mgroupDigertModal").on('hidden.bs.modal',function(){
		$("#orderForm1Modal").css("opacity","1");
	})
	
	$(".orderForm2").on("click", function() {
		console.log("orderForm2");
		$("#mgroupDigertModal").css("opacity","0.7");
		$("#orderForm2Modal").modal({
			backdrop:"static",
			show:true
		});
	});
	$("#orderForm2Modal").on('hidden.bs.modal',function(){
		$("#mgroupDigertModal").css("opacity","1");
	})
});*/





var activeEl = 2;
$(function() {
    var items = $('.btn-nav');
    $( items[activeEl] ).addClass('active');
    $( ".btn-nav" ).click(function() {
        $( items[activeEl] ).removeClass('active');
        $( this ).addClass('active');
        activeEl = $( ".btn-nav" ).index( this );
    });
});





