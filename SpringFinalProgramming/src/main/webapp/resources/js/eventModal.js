$(function() {
	$("#btnRegEvent").on("click",function() {
		$("#eventModal").css("opacity","0.5");
		$("#eventRegModal").modal({
			backdrop:"static",
			show:true
		});
	});
	
	$("#eventRegModal").on('hidden.bs.modal',function(){
		$("#eventModal").css("opacity","1");
	});
	
	
	$("#regEvent").on("click",function() {
		var etitle = $("#etitle").val();
		var estartperiod = $("#estartperiod").val();
		var elastperiod = $("#elastperiod").val();
		var econtents =$("#econtents").text();
		var photo = $("#photo")[0];
		
		var data = new FormData();
		data.append("etitle", etitle);
		data.append("estartperiod", estartperiod);
		data.append("elastperiod", elastperiod);
		data.append("econtents", econtents);
		
		if(photo.files.length != 0) {
			data.append("photo", photo.files[0]);
		}			
		
		$.ajax({
			url:"event/register",
			method: "post",
			data: data,
			cache: false,
			processData: false,
			contentType: false,
			success: function(data) {
				if(data.result == "success") {
					$("#eventRegModal").modal("hide");
					eventList();
				}
			}
		});
		
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
		             '<td><a href="javascript:eventInfo('+ event.eid + ')">'+ event.etitle +'</td>'+
		             '<td>'+ event.estartperiod + ' ~ ' + event.elastperiod + '</td>'+
		             '<td>'+ event.econtents + '~' + '</td>'+
		             '<td class="text-center"><a class="btn btn-info btn-xs" href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>'+
			         '</tr>'
            	);
			}
		}
	});
};

function eventInfo(eid){
	$.ajax({
		url:"event/info",
		data: {"eid":eid},
		success: function(data){
			var info = data.event;
			console.log(info);
			$("#eventInfo").append(
			  '<div class="media">' +
			    '<img class="media-object" width=150px src="showPhoto?esavedfile=' + info.esavedfile + '">' +
			  		 '<div class="media-body">' +
			    		'<h4 class="media-heading" id="etitle">' + info.etitle +'</h4>' +
			            '<p>' + info.econtents+ '</p>' +
			  			'<span><i class="glyphicon glyphicon-calendar"></i>'+ info.estartperiod + '~' + info.elastperiod +'</span>' +
			        '</div>' +
			    '</div>'
				);
			$("#eventModal").css("opacity","0.5");
			$("#eventInfoModal").modal({
				backdrop:"static",
				show:true
			});
		}
	});
	
	$("#eventInfoModal").on('hidden.bs.modal',function(){
		$("#eventModal").css("opacity","1");
	});
	
}
