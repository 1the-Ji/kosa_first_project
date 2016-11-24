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
	
	
	$("#orderForm1").on("click", function() {
		$("#orderModal").modal("hide");
		$("#orderForm1Modal").modal("show");
	});
	
	$(".orderForm2").on("click", function() {
		$("#orderForm1Modal").modal("hide");
		$("#orderForm2Modal").modal("show");
	});
	
});

$(function termList() {
	$("#termList").on("click", function() {
		$("#orderModal").modal("hide");
		$("#termListModal").modal("show");
	});
});


$(function mgroupAll() {
	$("#mgroupAll").on("click", function() {
		$("#mgroupCoffModal").modal("hide");
		$("#mgroupTeaModal").modal("hide");
		$("#mgroupDigertModal").modal("hide");
		$("#orderForm1Modal").modal("show");
	});
});

$(function mgroupCoff() {
	$("#mgroupCoff").on("click", function() {
		$("#orderForm1Modal").modal("hide");
		$("#mgroupTeaModal").modal("hide");
		$("#mgroupDigertModal").modal("hide");
		$("#mgroupCoffModal").modal("show");
	});
});

$(function mgroupTea() {
	$("#mgroupTea").on("click", function() {
		$("#orderForm1Modal").modal("hide");
		$("#mgroupCoffModal").modal("hide");
		$("#mgroupDigertModal").modal("hide");
		$("#mgroupTeaModal").modal("show");
	});
});

$(function mgroupDigert() {
	$("#mgroupDigert").on("click", function() {
		$("#orderForm1Modal").modal("hide");
		$("#mgroupCoffModal").modal("hide");
		$("#mgroupTeaModal").modal("hide");
		$("#mgroupDigertModal").modal("show");
	});
});

$(function mnameSearch() {
	$("#mnameSearch").on("click", function() {
		$("#orderForm1Modal").modal("hide");
		$("#mgroupCoffModal").modal("hide");
		$("#mgroupTeaModal").modal("hide");
		$("#mgroupDigertModal").modal("hide");
		$("#mnameSearchModal").modal("show");
	});
});



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