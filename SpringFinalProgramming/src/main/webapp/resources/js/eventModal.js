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
		var econtents =$("#econtents").val();
		var photo = $("#photo")[0];
		
		var data = new FormData();
		data.append("etitle", etitle);
		data.append("estartperiod", estartperiod);
		data.append("elastperiod", elastperiod);
		data.append("econtents", econtents);
		
		console.log("eventInfo 성공 " + etitle);
		console.log("eventInfo 성공 " + estartperiod);
		console.log("eventInfo 성공 " + elastperiod);
		console.log("eventInfo 성공 " + econtents);
		console.log("eventInfo 성공 " + photo);
		
		
		
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
	
	
	
	$("#modiEvent").on("click",function() {
		var etitle = $("#etitle").val();
		var estartperiod = $("#estartperiod").val();
		var elastperiod = $("#elastperiod").val();
		var econtents =$("#econtents").val();
		var photo = $("#photo")[0];
		console.log(photo.files);
		
		 
		var data = new FormData();
		data.append("etitle", etitle);
		data.append("estartperiod", estartperiod);
		data.append("elastperiod", elastperiod);
		data.append("econtents", econtents);
		
		console.log("------------------------------------------");
		console.log("eventModi(etitle) 성공 " + etitle);
		console.log("eventModi(estartperiod) 성공 " + estartperiod);
		console.log("eventModi(elastperiod) 성공 " + elastperiod);
		console.log("eventModi(econtents) 성공 " + econtents);
		if(photo.files.length != 0) {
			data.append("photo", photo.files[0]);
			console.log("eventModi(phtoto) 성공 " + photo);
		}			
		console.log("------------------------------------------");
		
		
		$.ajax({
			url:"event/modify",
			method: "post",
			data: data,
			cache: false,
			processData: false,
			contentType: false,
			success: function(data) {
				if(data.result == "success") {
					$("#eventModiModal").modal("hide");
					eventList();
				}
			}
		});
		
	});
	

});

function eventList(){
	console.log("eventList 시작");
	$.ajax({
		url:"event/eventList",
		data:{},
		success:function(data){
			console.log("eventList 중간");
			$("#eventTbody").empty();
			for(var i=0; i<data.eventList.length; i++) {
				var event = data.eventList[i];
				$("#eventTbody").append(
			         '<tr>'+
		             '<td>'+ event.eid +'</td>' +
		             '<td><a href="javascript:eventInfo('+ event.eid + ')">'+ event.etitle +'</td>'+
		             '<td>'+ event.estartperiod + ' ~ ' + event.elastperiod + '</td>'+
		             '<td>'+ event.econtents + '~' + '</td>'+
		             '<td class="text-center"><a class="btn btn-info btn-xs" href="javascript:eventModify(' + event.eid +')" id="btnModiEvent"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>'+
			         '</tr>'
            	);
			}
		},
		error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	       }
	});
}

function eventInfo(eid){
	console.log(eid);
	$.ajax({
		url:"event/info",
		data: {"eid":eid},
		success: function(data){
			console.log("ajax 성공 " + data.eid);
			console.log("ajax 성공 " + data.etitle);
			console.log("ajax 성공 " + data.econtents);
			console.log("ajax 성공 " + data.estartperiod);
			console.log("ajax 성공 " + data.elastperiod);
			console.log("ajax 성공 " + data.esavedfile);
			$("#eventInfo").empty();
			$("#eventInfo").append(
			  '<div class="media">' +
			    '<img class="media-object" width=150px src="event/showPhoto?esavedfile=' + data.esavedfile + '">' +
			  		 '<div class="media-body">' +
			    		'<h4 class="media-heading" id="etitle">' + data.etitle +'</h4>' +
			            '<p>' + data.econtents+ '</p>' +
			  			'<span><i class="glyphicon glyphicon-calendar"></i>'+ data.estartperiod + '~' + data.elastperiod +'</span>' +
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

function eventModify(eid){
	$("#btnModiEvent").on("click",function() {
		$("#eventModal").css("opacity","0.5");
		$("#eventModiModal").modal({
			backdrop:"static",
			show:true
		});
	});
	console.log("eventModify(): "+eid);
	$.ajax({
		url:"event/modify",
		method:"get",
		data:{"eid":eid},
		success: function(data){
			console.log("----------------------------------");
			console.log("ajax modify성공 " + data.eid);
			console.log("ajax modify성공 " + data.etitle);
			console.log("ajax modify성공 " + data.econtents);
			console.log("ajax modify성공 " + data.estartperiod);
			console.log("ajax modify성공 " + data.elastperiod);
			console.log("ajax modify성공 " + data.esavedfile);
			console.log("----------------------------------");
			
			$("#eventModi").empty();
			$("#eventModi").append(
					'<div class="col-md-8">' +
				     '<form class="form-horizontal" method="post" name="signup" id="signup" enctype="multipart/form-data" >'  +      
				       '<div class="form-group">' +
				          '<label class="control-label col-sm-3">제목. <span class="text-danger">*</span></label>' +
				          '<div class="col-md-8 col-sm-9">' +
				            '<input type="text" class="form-control" name="etitle" id="etitle" placeholder="Enter your Name here" value="' + data.etitle + '">'+
				          '</div>' +
				        '</div>' +
				        '<div class="form-group">' +
				          '<label class="control-label col-sm-3">기간. <span class="text-danger">*</span></label>' +
				          '<div class="col-md-8 col-sm-9">' +
				            '<input type="date" class="form-control" name="estartperiod" id="estartperiod" placeholder="Enter your Name here" value="' + data.estartperiod + '"> ~ ' +
				            '<input type="date" class="form-control" name="elastperiod" id="elastperiod" placeholder="Enter your Name here" value="' + data.elastperiod + '">'  +
				          '</div>' +
				        '</div>' +
				        '<div class="form-group">' +
				          '<label class="control-label col-sm-3">내용. <span class="text-danger">*</span></label>' +
				          '<div  class="col-md-8 col-sm-9">' +
				            '<textarea cols=20 rows=3 class="form-control" name="econtents" id="econtents" placeholder="Enter your Name here">' + data.econtents + '</textarea>' +
				          '</div>' +
				        '</div>' +
				        '<div class="form-group">' +
				          '<label class="control-label col-sm-3">첨부파일. </label>' +
				          '<div class="col-md-5 col-sm-8">' +
				          '<img class="media-object" width=150px src="event/showPhoto?esavedfile=' + data.esavedfile + '">' +
				            '<div class="input-group"> <span class="input-group-addon" id="file_upload"><i class="glyphicon glyphicon-upload"></i></span>' +
				              '<input type="file" name="photo" id="photo" placeholder="" aria-describedby="file_upload">' +
				            '</div>' +
				          '</div>' +
				        '</div>' +
				      '</form>' +
				    '</div>'
			);
		},
		error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	       }
		
	});
	
	
	$("#eventModiModal").on('hidden.bs.modal',function(){
		$("#eventModal").css("opacity","1");
	});
}
