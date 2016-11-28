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
	$("#btnNewOrder").on("click", function() {
		orderMenuList("전체");
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


function orderMenuList(mgroup) {
	$("#menuTbody").empty();
	$.ajax({
		url: "order/menuList",
		data: {"mgroup": mgroup},
		success: function(data) {
			for(var i=0; i<data.length; i++) {
				var menu = data[i];
				$("#menuTbody").append(
	         		'<tr>' + 
	             	'<td style="width:120px" data-label="메뉴번호">' + menu.mid + '</td>' + 
	             	'<td style="width:120px" data-label="메뉴사진"><img src="menu/showPhoto?msavedfile=' + menu.msavedfile + '" width="50px" height="50px"/></td>' + 
	             	'<td class="orderForm2" data-label="메뉴이름"><a  type="button" class="btn btn-primary" href="#">' + menu.mname + '</a></td>' +
	             	'<td class="orderForm2" data-label="메뉴이름"><input  type="number" value="0"/></td>' +
	             	'</tr>'
             	);
			}
		}
	});
}

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





