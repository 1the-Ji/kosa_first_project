function onClickLogin() {
	var sid = $("#storeId").val();
	var spw = $("#storePw").val();
	console.log(sid);
	console.log(spw);
	
	$.ajax({
		url: "store/login",
		data: {"sid":sid, "spw":spw},
		method: "post",
		success: function(data) {
			if(data.result == 0){
				alert("로그인 성공");
			}else{
				alert("로그인 실패");
			}
			
		}
	});
};


