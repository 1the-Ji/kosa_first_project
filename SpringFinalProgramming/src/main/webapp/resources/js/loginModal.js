
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
				console.log("성공!!!");
				alert("로그인 성공");
				/*if(data.result == 0){
					
				}else{
					console.log("aaaaaaaaaaaa"+data.result);
					alert("로그인 실패");
					
				}*/
				
			}
		});
	};


