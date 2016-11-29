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

function eventList(){
	$.ajax({
		url:"event/eventList",
		data:{},
		success:function(data){
			$("#eventTbody").empty();
			for(var i=0; i<data.eventList.length; i++) {
				var event = data.eventList[i];
				$("#eventTbody").append(
			         '<tr>'+
		             '<td>'+ event.eid +'</td>' +
		             '<td><a href="info?eid=${event.eid}">'+ event.etitle +'</td>'+
		             '<td>'+ event.estartperiod + ' ~ ' + event.elastperiod + '</td>'+
		             '<td>'+ event.econtents + '~' + '</td>'+
		             '<td class="text-center"><a class="btn btn-info btn-xs" href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>'+
			         '</tr>'
            	);
			}
			$("#eventModal").modal("show");
		}
	});
};


